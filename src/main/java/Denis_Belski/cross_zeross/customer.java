package Denis_Belski.cross_zeross;

import java.util.Scanner;

public class customer {

    private Scanner in = new Scanner(System.in);
    private static boolean flagOnX = false;
    private int countAnswers = 0;
    public static boolean hardMode = false;

    customer() {

    }

    public int askAboutMode() {
        System.out.println("Would you like to use Hard Mode ? ");
        for( ;true; ) {
            System.out.print("Enter Y or N: ");
            String answer = new String();

            answer = in.nextLine();
            answer = answer.toUpperCase();
            try {
                if(answer.toUpperCase().contentEquals("EXIT")) {
                    System.out.println("Exit.");
                    return -100;
                }
                if(answer.contentEquals("Y")) {
                    this.hardMode = true;
                    return 0;
                }else if (answer.contentEquals("N")) {
                    this.hardMode = false;
                    return 0;
                } else {
                    System.out.println(" Bad value. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
                continue;
            }
        }
    }

    public boolean checkGameRules() {

        System.out.println("You start to play in 'X or O' game.");
        System.out.println("You can exit from game in any time. Just write 'exit'.");
        System.out.println("Player will make the first move.");
        System.out.println("You will have to write where you would like to put your mark.");
        System.out.println("Please use only number in your answers.");

        if(this.askAboutMode() < 0 ) {
            return false;
        }
        System.out.print("Enter any mark to start or 'exit' to end of game: ");

        String answer = new String("");

        answer = in.nextLine();
        answer = answer.toUpperCase();

        if(answer.contentEquals("EXIT")) {
            System.out.println("Exit.");
            return false;
        } else {
            return true;
        }
    }

    public int get_X_or_O() {

        for( ;true; ) {
            System.out.print("Please, choose which mark you would like to use: X or O. ");
            String answer = new String();

            answer = in.nextLine();
            answer = answer.toUpperCase();
            try {
                if(answer.toUpperCase().contentEquals("EXIT")) {
                    System.out.println("Exit.");
                    return 4;
                }
                if(answer.contentEquals("X")) {
                    flagOnX = true;
                    return 1;
                }else if (answer.contentEquals("0") || answer.contentEquals("O")){
                    return 0;
                } else {
                    System.out.println(" Bad value. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
                continue;
            }
        }
    }

    public String getAnswer() {

        //Scanner in = new Scanner(System.in);
        boolean flag = false;
        String result = "";


        for( ;true; ) {
            String answer = new String();
            int number = 0;     //to make sure that customer wrote number

            if(!flag) {
                System.out.print("Enter Row number: ");
            } else {
                System.out.print("Enter Column number: ");
            }
            answer = in.nextLine();
            try {
                if(answer.toUpperCase().contentEquals("EXIT")) {
                    System.out.println("Exit.");
                    return "EXIT";
                }
                number = Integer.parseInt(answer);

                if (number >0 && number < 4) {
                    if (flag) {
                        result += answer;
                        break;
                    } else {
                        result += answer + ",";
                        flag = true;
                    }
                } else {
                    System.out.println(" Bad value. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
                continue;
            }
        }

        countAnswers++;
        return result;
    }

    public int checkCountAnswers() {
        return countAnswers;
    }

    public static boolean getMark() {
        return flagOnX;
    }

    public boolean getMode() {
        return hardMode;
    }
}
