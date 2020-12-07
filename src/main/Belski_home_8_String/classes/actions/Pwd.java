package classes.actions;

import classes.baseClasses.FileCatalog;
import classes.baseClasses.MyBase;

public class Pwd extends ActionParent{

    private static String absolutePAth = "";

    public Pwd() {
        this.action = "PWD";
    }
    public static void setPath(String path) {
        absolutePAth = path;
    }

    public static String getPath() {
        return absolutePAth;
    }
    @Override
    public void startAction(String customersResponse) {
        showCurrentAbsolutePath();
    }
    public static void showCurrentAbsolutePath() {
        System.out.println("pwd: "+absolutePAth);
    }

}
