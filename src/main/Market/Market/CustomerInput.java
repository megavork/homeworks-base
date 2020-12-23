package Market;

import java.util.Scanner;

public class CustomerInput {

    public static int getIntegerInputAnswer(String word) {
        String answer = "";
        int result = -1;

        Scanner in = new Scanner(System.in);

        while(result < 0) {
            System.out.print("Enter " + word + ": ");
            answer = in.nextLine();

            try {
                result = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
            }
        }
        return result;
    }

    public static String getStringInputAnswer(String word) {
        String answer = "";

        Scanner in = new Scanner(System.in);

        while(answer.isEmpty()) {
            System.out.print("Enter item " + word + ": ");
            answer = in.nextLine();
        }
        return answer;
    }

    /**
     * Use to get empty String
     * @param word
     * @param canGetEmptyString
     * @return
     */
    public static String getStringInputAnswer(String word, boolean canGetEmptyString) {
        String answer = "";

        Scanner in = new Scanner(System.in);

        System.out.print("Enter item " + word + " or press enter to do not change this parameter: ");
        answer = in.nextLine();

        return answer;
    }

    public static double getDoubleInputAnswer(String word) {
        String answer = "";
        double result = -1;

        Scanner in = new Scanner(System.in);

        while(result <= 0) {
            System.out.print("Enter item " + word + ": ");
            answer = in.nextLine();

            try {
                result = Double.parseDouble(answer);
            } catch (NumberFormatException e) {
                System.out.println("Bad value or price can't be equals or less then 0. Try again.");
            }
        }
        return result;
    }

    /**
     * Use to get empty string
     * @param word
     * @param canGetEmptyString
     * @return
     */
    public static double getDoubleInputAnswer(String word, boolean canGetEmptyString) {
        String answer = "";
        double result = -1;

        Scanner in = new Scanner(System.in);

        while(result <= 0) {
            System.out.print("Enter item " + word + " or press enter to do not change this parameter: ");
            answer = in.nextLine();

            if (answer.isEmpty())   //if we no need to change field
                return -1;

            try {
                result = Double.parseDouble(answer);
            } catch (NumberFormatException e) {
                System.out.println("Bad value or price can't be equals or less then 0. Try again.");
            }
        }
        return result;
    }
}
