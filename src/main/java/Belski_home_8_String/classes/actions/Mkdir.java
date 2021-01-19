package Belski_home_8_String.classes.actions;

import Belski_home_8_String.classes.baseClasses.FileCatalog;

public class Mkdir extends ActionParent {

    public Mkdir() {
        this.action = "MKDIR";
    }

    @Override
    public void startAction(String customersResponse) {
        if (customersResponse.length() > 6) {
            customersResponse = customersResponse.substring(6, customersResponse.length()).strip();
        } else {
            System.out.println("Path value is empty. Try again.");
            return;
        }
        String[] response = FileCatalog.parsingAbsolutePath(customersResponse);

        // 2 метода - короткий путь и длинный путь
        if (response.length < 3) {   //если короткий путь
            if (response[0] != null && checkMainPath(response[1]) && Pwd.getPath().equals("/")) {
                startActionMakeNewMainDir(response[1]);
            } else if (response[0] != null) {
                customersResponse = Pwd.getPath() + response[1];
                startActionSlashDir(customersResponse);
            } else {
                System.out.println("Path value is empty. Try again.");
                return;
            }
        } else {    // если длинный
            startActionSlashDir(customersResponse);
        }
    }

    /**
     * if you use absolute path looks like
     * mkdir /var/te to create /te dir in /var path.
     *
     * @param absolutePath
     */
    private void startActionSlashDir(String absolutePath) {
        String[] dirs = FileCatalog.parsingAbsolutePath(absolutePath);
        FileCatalog.setNewObjectToBase(dirs);
    }

    /**
     * Create new Main path
     *
     * @param absolutePath
     */
    private void startActionMakeNewMainDir(String absolutePath) {
        //System.out.println(absolutePath);
        FileCatalog.setNewMainDir(absolutePath);
    }

    /**
     * just to check have already exist path or not
     * if path does not exist - return true;
     *
     * @param dir
     * @return
     */
    private boolean checkMainPath(String dir) {
        if (Pwd.getPath().equals("/"))
            return true;
        else if (FileCatalog.checkPathFromMainDir(dir) >= 0)
            return false;
        else
            return true;
    }
}
