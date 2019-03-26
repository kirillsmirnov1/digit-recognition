package recognition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nWhat do you want?");
            System.out.println("1. Teach the network");
            System.out.println("2. Guess a number");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            switch(scanner.nextInt()){
                case 1:{ // ???????? ????
                    // TODO
                    System.out.println("\nTODO");
                    break;
                }
                case 2:{ // ???????? ????????? ?????
                    // TODO
                    System.out.println("\nTODO");
                    break;
                }
                case 3:{ // ?????
                    System.out.println("\nBye bye!");
                    System.exit(0);
                }
                default: // ???????????? ????
                    System.out.println("\nWrong input");
            }
        }
    }

    // ????? ?? ??????? ????? ? ???? ??????? 5?3
    private static double[] readInput() {
        double[] a = new double[15];
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