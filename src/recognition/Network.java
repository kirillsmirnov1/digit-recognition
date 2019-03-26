package recognition;

import java.util.Arrays;
import java.util.Random;

public class Network {

    // Количество слоёв
    private final int numberOfLayers;

    // Количество нейронов на каждом слое
    private final int[] layerSizes;

    // Слои нейронов
    private double[][] layers;

    // Отличие последнего слоя от желаемого результата
    private double[] lastLayerDifference;

    // Веса между слоями
    private double[][][] weights;

    // Вывод промежуточных результатов в консоль
    private boolean outputMidResults = true;

    // Конструктор по-умолчанию создает НС с двумя слоями по 15 и 10 нейронов соответственно
    public Network(){
        this(new int[] {15, 10});
    }

    // Конструктор принимает на вход размеры слоев
    public Network(int[] layerSizes){
        Random random = new Random();

        this.layerSizes = layerSizes;
        numberOfLayers = layerSizes.length;

        // Инициализирую пустой массив слоёв
        layers = new double[numberOfLayers][];

        // Инициализирую массив весов
        weights = new double[numberOfLayers - 1][][];

        // Заполняю веса случайными значениями
        for(int midLayer = 0; midLayer < numberOfLayers - 1; ++midLayer){
            weights[midLayer] = new double[layerSizes[midLayer]][layerSizes[midLayer+1]];

            for(int i = 0; i < layerSizes[midLayer]; ++i){
                for(int j = 0; j < layerSizes[midLayer+1]; ++j){
                    weights[midLayer][i][j] = random.nextGaussian();
                }
            }
        }
    }

    // Расчёт выходного слоя от входного
    private double[] calculateOutput(double[] input){
        if(input.length != layerSizes[0])
            throw new IllegalArgumentException("Wrong input size");

        layers[0] = input;

        // Инициализирую каждый слой
        for(int layer = 1; layer < numberOfLayers; ++layer){
            layers[layer] = new double[layerSizes[layer]];
        }

        for(int midLayer = 0; midLayer < weights.length; ++midLayer){
            for(int rightNeuron = 0; rightNeuron < layers[midLayer+1].length; ++rightNeuron){
                for(int leftNeuron = 0; leftNeuron < layers[midLayer].length; ++leftNeuron){
                    layers[midLayer+1][rightNeuron] += layers[midLayer][leftNeuron] * weights[midLayer][leftNeuron][rightNeuron];
                }
            }
        }

        if(outputMidResults){
            System.out.println("Output layer:\n" + Arrays.toString(layers[numberOfLayers - 1]));
        }

        return layers[numberOfLayers-1];
    }

    // Подбор результата
    public int guessTheResult(double[] input){
        int lastLayer = numberOfLayers - 1;

        // Самое похожее число
        int nearestResult = 0;
        // Расстояние до этого числа
        double smallestDistance = Integer.MAX_VALUE;

        // Все расстояния
        double[] distance = new double[Numbers.idealOutputNumbers.length];

        // Считаем последний слой
        calculateOutput(input);

        // Сверяем каждое число
        for(int number = 0; number < Numbers.idealOutputNumbers.length; ++number){
            double localDistance = 0d;

            for (int neuron = 0; neuron < layerSizes[lastLayer]; ++neuron){
                localDistance += Math.pow(layers[lastLayer][neuron] - Numbers.idealOutputNumbers[number][neuron], 2); // TODO использовать calculate difference
            }

            distance[number] = localDistance;

            if(localDistance < smallestDistance){
                smallestDistance = localDistance;
                nearestResult = number;
            }
        }

        if(outputMidResults){
            System.out.println("\nDistances:\n" + Arrays.toString(distance));
        }

        // Возвращаю самое похожее число
        return nearestResult;
    }

    // Расчёт разницы последнего слоя нейронов и образца
    private void calculateDifference(int number) {
        lastLayerDifference = new double[layerSizes[numberOfLayers-1]];

        for(int i = 0; i < lastLayerDifference.length; ++i){
            lastLayerDifference[i] = Numbers.idealOutputNumbers[number][i] - layers[numberOfLayers-1][i];
        }
    }
}
