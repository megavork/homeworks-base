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

    public static MyBase getLastPathObject() {
        if(Pwd.getPath().equals("/")) {
            return FileCatalog.getObjectFromMainList(Pwd.getPath());
        } else {
            String[] catalog = FileCatalog.parsingAbsolutePath(Pwd.getPath());
            if(catalog[0] != null) {
                MyBase base = FileCatalog.getObjectFromMainList(catalog[1]);
                for (int i = 2; i < catalog.length; i++) {
                    if (base.checkNextPathExist(catalog[i])) {
                        base = base.findCurrentPath(catalog[i]);
                    }
                }
                return base;
            } else {
                return null;
            }
        }
    }

}
