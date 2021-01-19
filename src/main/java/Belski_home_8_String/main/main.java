package Belski_home_8_String.main;

import Belski_home_8_String.classes.baseClasses.FileCatalog;
import Belski_home_8_String.classes.baseClasses.GetFileDirectory;

public class main {
    public static void main(String[] args) {
        FileCatalog catalog = new FileCatalog();
        catalog.setAllConstCommands(GetFileDirectory.getAllActionFromList());           //just transfer all defined commands

        String answer = "";

        while (true) {
            answer = GetFileDirectory.askCustomer();                                    //customer wrote command

            if (answer.equals("EXIT")) {
                break;
            }
            catalog.doAction(answer, GetFileDirectory.getStaticListParam(answer));      //do
        }
    }
}