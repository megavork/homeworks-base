package main;

import classes.baseClasses.FileCatalog;
import classes.baseClasses.GetFileDirectory;

public class main {
    public static void main(String[] args) {
        FileCatalog catalog = new FileCatalog();

        while(true) {
            String answer = GetFileDirectory.askCustomer();     //customer wrote command

            //System.out.println("Answer: " + answer);
            catalog.setAllConstCommands(GetFileDirectory.getAllActionFromList());       //just transfer all defined commands
            catalog.doAction(answer, GetFileDirectory.getStaticListParam(answer));      //do
        }
    }
    /*

     */
}