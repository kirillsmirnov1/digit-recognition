package recognition;

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
                case 1:{
                    // TODO
                    System.out.println("\nTODO");
                    break;
                }
                case 2:{
                    // TODO
                    System.out.println("\nTODO");
                    break;
                }
                case 3:{
                    System.out.println("\nBye bye!");
                    System.exit(0);
                }
                default:
                    System.out.println("\nWrong input");
            }
        }
    }
}