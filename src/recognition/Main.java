package recognition;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Network network = new Network();

        while(true){
            System.out.println("\nWhat do you want?");
            System.out.println("1. Teach the network");
            System.out.println("2. Guess a number");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            switch(scanner.nextInt()){
                case 1:{ // Обучение сети
                    network.teachNetwork(1000);
                    break;
                }
                case 2:{ // Отгадать введённый номер
                    System.out.println("\nLooks like: " + network.guessTheResult(readInput()));
                    break;
                }
                case 3:{ // Выход
                    saveNetwork(network);
                    System.out.println("\nBye bye!");
                    System.exit(0);
                }
                default: // Некорректный ввод
                    System.out.println("\nWrong input");
            }
        }
    }

    // Сохранение сети в файл
    private static void saveNetwork(Network network) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("NetworkObj.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(network);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("\nNetwork saved");
        } catch (Exception e){
            System.out.println("\nError saving network");
            e.printStackTrace();
        }
    }

    // Читаю из консоли число в виде матрицы 5х3
    private static double[] readInput() {
        double[] a = new double[15];
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInput 5x3 grid ('_' for white, any other for blue):");
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