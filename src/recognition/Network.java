package recognition;

import java.util.Random;

public class Network {

    // Количество слоёв
    private final int numberOfLayers;

    // Количество нейронов на каждом слое
    private final int[] layerSizes;

    // Слои нейронов
    private double[][] layers;

    // Веса между слоями
    private double[][][] weights;

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

    public double[] calculateOutput(double[] input){
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

        return layers[numberOfLayers-1];
    }
}
