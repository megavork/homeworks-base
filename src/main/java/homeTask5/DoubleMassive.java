package homeTask5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DoubleMassive {
    public static void main(String[] args) {

        Random random = new Random();
        String answer = "";
        int numberOne = 0;
        int numberTwo = 0;
        int flag = 0;

        Scanner in = new Scanner(System.in);

        for(int i=0; i<100; i++) {
            if(flag==0) {
                System.out.print("Enter count of rows: ");
            } else if (flag ==1){
                System.out.print("Enter count of columns: ");
            }
            answer = in.nextLine();
            try {
                if(flag==0) {
                    numberOne = Integer.parseInt(answer);
                    if (numberOne <= 0) {
                        throw new NumberFormatException();
                    }
                    flag++;
                } else {
                    numberTwo = Integer.parseInt(answer);
                    if (numberTwo <= 0) {
                        throw new NumberFormatException();
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
                continue;
            }
        }

        int[][] array = new int[numberOne][numberTwo];

        for(int i=0; i<array.length; i++) {
            for(int k=0; k<array.length; k++) {
                array[i][k] = random.nextInt(51);
            }
        }

        for(int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        //задача 2
        System.out.println("Second Part:");
        for(int i=0; i<array.length; i++) {
            for(int k=0; k<=i; k++) {
                if (array[i][k] % 2 != 0) {
                    System.out.print(array[i][k] + " ");
                }
            }
        }
        //задача 5
        System.out.println();
        int[][] transportArray = new int[array.length][array.length];
        System.out.println("Fives Part:");

        for(int i=0; i<array.length; i++) {
            for(int k=0; k<array.length; k++) {
                transportArray[i][k] = array[k][i];
            }
        }

        for(int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(transportArray[i]));
        }
    }
}
