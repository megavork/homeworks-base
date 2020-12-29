package classes.baseClasses;

import classes.actions.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * class should get parameter and choose what we should do
 */
public class FileCatalog {

    private static ArrayList<MyBase> directoriesMain = new ArrayList<>();      //baseObjects
    private static HashMap<String,Object> actionMap = new HashMap<>();     //command - action

    public FileCatalog(){
        Pwd.setPath("/");
        MyBase base = new MyBase("/");
        directoriesMain.add(base);
    }

    /**
     * Should add new actions if you created new one.
     * This method put all actions in map
     * Also create a dependencies command-actions
     * @param allList
     */
    public void setAllConstCommands(String allList) {
        allList = allList.substring(1,allList.length()-1);
        String[] actions = allList.split(",");

        //command collection
        ActionParent[] actionsArray =
                new ActionParent[]{new Cd(), new Touch(),new Ls(),new Mkdir(),new Pwd()};

        for (int i = 0; i < actions.length; i++) {
            actions[i] = actions[i].toUpperCase().strip();

            for (int j = 0; j < actionsArray.length; j++) {
                if (actions[i].equals(actionsArray[j].getActionName().strip())) {
                    actionMap.put(actions[i],actionsArray[j]);
                }
            }
        }
    }
    /**
     * Check wwhat customer wrote and call the action
     * @param customerResponse
     * @param command
     */
    public void doAction(String customerResponse, String command) {
        command = command.toUpperCase();
        for (int i = 0; i < actionMap.size(); i++) {
            ActionParent actionParent = (ActionParent) actionMap.get(command.strip());
            //System.out.println("."+actionParent.getActionName()+".");
            //System.out.println(command);
            if(command.equals(actionParent.getActionName())) {
                actionParent.startAction(customerResponse);
                break;
            }
        }
    }
    /**
     * return object contains directory from main lib
     * @param dir
     * @return
     */
    public static MyBase getObjectFromMainList(String dir) {
        for (int i = 0; i < directoriesMain.size(); i++) {
            if (directoriesMain.get(i).getCurrentPath().equals(dir)) {
                return directoriesMain.get(i);
            }
        }
        return new MyBase(dir);
    }

    /**
     * if main lib has object contains parm dir, will return its number
     * @param absolutePath
     * @return
     */
    public static int checkPathFromMainDir(String absolutePath) {
        String[] objectsPath = FileCatalog.parsingAbsolutePath(absolutePath);
        //System.out.println(Arrays.toString(objectsPath) + " len " + objectsPath.length);

        //если у нас длинный путь
        for (int i = 0; i < directoriesMain.size(); i++) {
            if (directoriesMain.get(i).getCurrentPath().equals(objectsPath[1])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * will add new object with new currentPath name.
     * @param absolutePath
     */
    public static void setNewObjectToBase(String[] absolutePath) {

        //Step 1 - check main dir:
        if(absolutePath[0].isEmpty()) {
            if (FileCatalog.checkPathFromMainDir(absolutePath[1]) < 0) {
                System.out.println("Bad value or path already exist.");
                return;
            }
            //Step 2 - get object contains pre last path.

            // last path we should create.
            MyBase base = FileCatalog.getObjectFromMainList(absolutePath[1]);
            for (int i = 2; i < absolutePath.length - 1; i++) {
                base = base.findCurrentPath(absolutePath[i]);
            }

            base.setNextPath(new MyBase(absolutePath[absolutePath.length - 1]));
        }
    }

    /**
     * create new dir in main lib
     * @param absolutePath
     */
    public static void setNewMainDir(String absolutePath) {
        if(!absolutePath.startsWith("/")) {
            absolutePath = "/"+absolutePath;
        }
        if(FileCatalog.checkPathFromMainDir(absolutePath) < 0) {
            directoriesMain.add(new MyBase(absolutePath));
        } else {
            System.out.println("Bad value or path already exist.");
        }
    }
    /**
     * parsing absolute Path. First element will will empty if path is OK, or null if ERROR
     * @param absolutePath
     * @return
     */
    public static String[] parsingAbsolutePath(String absolutePath) {
        String[] dirs = absolutePath.split("/");
        int count = 0;

        if(dirs.length == 1) {
            dirs[0] = "/" + dirs[0];
            String[] dirsTemp = {"",dirs[0]};
            return dirsTemp;
        }
        // if we have bad PATH, then don't need to do anything
        for (int i = 1; i < dirs.length; i++) {
            if(dirs[i].isEmpty()) {
                dirs[0] = null;
                return dirs;
            }
        }
        //first dir are always is empty.
        for (int i = 1; i < dirs.length; i++) {
            if(!dirs[i].startsWith("/")) {
                dirs[i] = "/" + dirs[i];
            }
        }
        return dirs;
    }

}
