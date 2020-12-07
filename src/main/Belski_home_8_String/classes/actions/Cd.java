package classes.actions;

import classes.baseClasses.FileCatalog;
import classes.baseClasses.MyBase;

import java.util.Arrays;

public class Cd extends ActionParent{


    public Cd() {
        this.action = "CD ";
    }

    /**
     * cd command
     * @param customerResponse
     */
    @Override
    public void startAction(String customerResponse) {

        String checkAction = customerResponse.substring(0,4);

        if(checkAction.toUpperCase().equals("CD /")) {
            String dirs = customerResponse.substring(0,customerResponse.length());
            changeDirWithSlash(dirs);
            return;
        } else {
            String dirs = customerResponse.substring(3,customerResponse.length());
            //System.out.println("PWD: "+Pwd.getPath());
            dirs = Pwd.getPath() + "/" + dirs;
            //System.out.println("cust " + dirs);
            changeDirWithoutSlash(dirs);
            return;
        }
    }

    /**
     * using this if we have: cd /var/...
     * @param customerResponse
     */
    private void changeDirWithSlash(String customerResponse) {
        customerResponse = customerResponse.substring(3,customerResponse.length());
        String[] pathes = FileCatalog.parsingAbsolutePath(customerResponse);

        if(pathes.length == 0) {    // if was request: cd /
            Pwd.setPath("/");
            return;
        }

        if(FileCatalog.checkPathFromMainDir(pathes[1]) >= 0){
            MyBase base = FileCatalog.getObjectFromMainList(pathes[1]);

            int index = 2;
            while(index < pathes.length && base.checkNextPathExist(pathes[index])) {
                base = base.findCurrentPath(pathes[index]);
                index++;
            }
            if(index == pathes.length) {
                Pwd.setPath(customerResponse);
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }

    /**
     * using this if we have: cd pp
     * @param customerResponse
     */
    private void changeDirWithoutSlash(String customerResponse) {
        String[] pathes = FileCatalog.parsingAbsolutePath(customerResponse);

        if(FileCatalog.checkPathFromMainDir(pathes[1]) >= 0){
            MyBase base = FileCatalog.getObjectFromMainList(pathes[1]);

            int index = 2;
            while(index < pathes.length && base.checkNextPathExist(pathes[index])) {
                base = base.findCurrentPath(pathes[index]);
                index++;
            }
            if(index == pathes.length) {
                Pwd.setPath(customerResponse);
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}
