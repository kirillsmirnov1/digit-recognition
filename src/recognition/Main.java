package recognition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int[][] w = {
            { 1,  1,  1,  1, -1,  1,  1, -1,  1,  1, -1,  1,  1,  1,  1}, // 0
            {-1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1}, // 1
            { 1,  1,  1, -1, -1,  1,  1,  1,  1,  1, -1, -1,  1,  1,  1}, // 2
            { 1,  1,  1, -1, -1,  1,  1,  1,  1, -1, -1,  1,  1,  1,  1}, // 3
            { 1, -1,  1,  1, -1,  1,  1,  1,  1, -1, -1,  1, -1, -1,  1}, // 4
            { 1,  1,  1,  1, -1, -1,  1,  1,  1, -1, -1,  1,  1,  1,  1}, // 5
            { 1,  1,  1,  1, -1, -1,  1,  1,  1,  1, -1,  1,  1,  1,  1}, // 6
            { 1,  1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1}, // 7
            { 1,  1,  1,  1, -1,  1,  1,  1,  1,  1, -1,  1,  1,  1,  1}, // 8
            { 1,  1,  1,  1, -1,  1,  1,  1,  1, -1, -1,  1,  1,  1,  1}  // 9
    };

    private static final int[] b = {-1, 6, 0, 0, 0, 0, -1, 4, -2, -1};

    public static void main(String[] args) {
        int[] a0 = readInput();
    }

    private static int[] readInput() {
        int[] a = new int[15];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 5x3 grid ('_' for white, any other for blue):");
        for(int i=0; i < 5; ++i){
            String str = scanner.nextLine();
            for(int j = 0; j < 3; ++j){
                a[3*i + j] =  (str.charAt(j) == '_') ? 0 : 1;
            }
        }

        System.out.println("\nInput:\n" + Arrays.toString(a) + "\n");

        return a;
    }
}