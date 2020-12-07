package classes.actions;

import classes.baseClasses.FileCatalog;
import classes.baseClasses.MyBase;

import java.util.Arrays;

public class Ls extends ActionParent {
    public Ls() {
        this.action = "LS";
    }

    @Override
    public void startAction(String customerResponse) {

        String[] absolutePath = FileCatalog.parsingAbsolutePath(Pwd.getPath());
        //System.out.println(absolutePath.length);
        if(absolutePath.length > 1) {
            MyBase base = FileCatalog.getObjectFromMainList(absolutePath[1]);
            //System.out.println(Arrays.toString(base.getAllNextPath()));
            for (int i = 2; i < absolutePath.length; i++) {
                base = base.findCurrentPath(absolutePath[i]);
            }
            //Pwd.showCurrentAbsolutePath();
            System.out.println("All dirs in: " + Pwd.getPath() + ": " + Arrays.toString(base.getAllNextPath()));
            System.out.println("All files in: " + Pwd.getPath() + ": " + Arrays.toString(base.showAllFiles()));
        } else {
            MyBase base = FileCatalog.getObjectFromMainList(Pwd.getPath());
            System.out.println("All dirs in: " + Pwd.getPath() + ": " + Arrays.toString(base.getAllNextPath()));
            System.out.println("All files in: " + Pwd.getPath() + ": " + Arrays.toString(base.showAllFiles()));
            //Pwd.showCurrentAbsolutePath();

        }
    }
}
