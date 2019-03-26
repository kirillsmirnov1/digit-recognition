package recognition;

// Класс для работы с числами
public class Numbers {
    // Образцы входных данных
    public static final double[][] idealInputNumbers = {
            { 1,  1,  1,  1,  0,  1,  1,  0,  1,  1,  0,  1,  1,  1,  1}, // 0
            { 0,  1,  0,  0,  1,  0,  0,  1,  0,  0,  1,  0,  0,  1,  0}, // 1
            { 1,  1,  1,  0,  0,  1,  1,  1,  1,  1,  0,  0,  1,  1,  1}, // 2
            { 1,  1,  1,  0,  0,  1,  1,  1,  1,  0,  0,  1,  1,  1,  1}, // 3
            { 1,  0,  1,  1,  0,  1,  1,  1,  1,  0,  0,  1,  0,  0,  1}, // 4
            { 1,  1,  1,  1,  0,  0,  1,  1,  1,  0,  0,  1,  1,  1,  1}, // 5
            { 1,  1,  1,  1,  0,  0,  1,  1,  1,  1,  0,  1,  1,  1,  1}, // 6
            { 1,  1,  1,  0,  0,  1,  0,  0,  1,  0,  0,  1,  0,  0,  1}, // 7
            { 1,  1,  1,  1,  0,  1,  1,  1,  1,  1,  0,  1,  1,  1,  1}, // 8
            { 1,  1,  1,  1,  0,  1,  1,  1,  1,  0,  0,  1,  1,  1,  1}  // 9
    };

    // Образцы выходных данных
    public static final double[][] idealOutputNumbers = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 0
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 1
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, // 2
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, // 3
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, // 4
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, // 5
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, // 6
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, // 7
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 8
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}  // 9
    };
}
