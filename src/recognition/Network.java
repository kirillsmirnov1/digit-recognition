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
    public Network(int numberOfLayers){
        this(new int[] {15, 10});
    }

    // Конструктор принимает на вход размеры слоев
    public Network(int[] layerSizes){
        Random random = new Random();

        this.layerSizes = layerSizes;
        numberOfLayers = layerSizes.length;

        // Инициализирую пустой массив слоёв
        layers = new double[numberOfLayers][];

        // Инициализирую каждый слой
        for(int layer = 0; layer < numberOfLayers; ++layer){
            layers[layer] = new double[layerSizes[layer]];
        }

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
}
