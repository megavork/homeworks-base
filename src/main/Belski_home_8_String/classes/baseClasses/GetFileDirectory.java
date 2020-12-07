package classes.baseClasses;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to ask customer
 */
public class GetFileDirectory {

    private static ArrayList<String> list = new ArrayList();

    static {
        list.add("mkdir");     //create path
        list.add("chmod ");     //get access
        list.add("pwd");        //show full current path
        list.add("cd ");        //go to the path
        list.add("ls");         //show all files and directories in current path
    }

    /**
     * was realised next commands:
     * print
     * ./
     * mkdir
     * chmod
     */
    public static String askCustomer() {
        Scanner scan = new Scanner(System.in);
        String tempVal = "-1";
        boolean flag = true;

        while(flag) {

            try {
                System.out.print("bash-$: ");
                tempVal = scan.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    if(tempVal.startsWith(list.get(i))) {
                        return tempVal;
                    }
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(tempVal + " - bad value. Try again.");
                continue;
            }
        }
        return tempVal;
    }

    /**
     * get static value from ArrayList
     * @param command
     * @return
     */
    public static String getStaticListParam(String command) {
        for (int i = 0; i < list.size(); i++) {
            if(command.startsWith(list.get(i))) {
                return list.get(i);
            }
        }
        return "-1";
    }

    /**
     * get size of ArrayList
     * @return
     */
    public static String getAllActionFromList() {
        return list.toString();
    }
}
