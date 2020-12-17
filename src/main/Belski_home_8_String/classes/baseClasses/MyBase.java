package classes.baseClasses;

import classes.actions.Pwd;
import java.util.ArrayList;

/**
 * Class should contains only current path, link to next path and all files
 * which it have
 */
public class MyBase {

    private String currentPath = "";                                    //имя текущего каталога
    private ArrayList<String> filesList = new ArrayList<>();            //храним здесь имена файлов в этом каталоге
    private ArrayList<MyBase> embeddedDir = new ArrayList<>();          //храним здесь подкаталоги

    public MyBase(String path) {
        this.currentPath = path;
        this.filesList.add("example.txt");      // will delete
    }
    /**
     * add file to container
     * @param file
     */
    public void putFile(String file) {
        filesList.add(file);
    }
    /**
     * set link to next filePath
     * next path is the object with new current path and link to next path
     * @param myBase
     */
    public void setNextPath(MyBase myBase) {
        //System.out.println(myBase.getCurrentPath());
        this.embeddedDir.add(myBase);
    }
    /**
     * show all file container has
     */
    public String[] showAllFiles() {
        String[] fileArray = new String[filesList.size()];
        for (int i = 0; i < fileArray.length; i++) {
            fileArray[i] = filesList.get(i);
        }
        return fileArray;
    }

    public String getCurrentPath() {
        return this.currentPath;
    }

    /**
     * Needs to check all objects from Array list
     * @param dir
     * @return
     */
    public MyBase findCurrentPath(String dir) {
        for (int i = 0; i < this.embeddedDir.size(); i++) {
            if(this.embeddedDir.get(i).currentPath.equals(dir)) {
                return this.embeddedDir.get(i);
            }
        }
        return new MyBase("NONE");
    }

    /**
     * return all directories contains current path.
     * @return
     */
    public String[] getAllNextPath() {
        //System.out.println(this.getCurrentPath()+"+"+this.embeddedDir.size());
        int index = 0;
        String[] result = new String[this.embeddedDir.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = this.embeddedDir.get(i).getCurrentPath();
        }
        return result;
    }

    /**
     * return boolean values if object has this path
     * @param str
     * @return
     */
    public boolean checkNextPathExist(String str) {
        if(!str.startsWith("/")) {
            str = "/" + str;
        }
        for (int i = 0; i < this.embeddedDir.size(); i++) {
            if(this.embeddedDir.get(i).currentPath.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * return true if embedded list is empty.
     * @return
     */
    public boolean isEmptyEmbedded() {
        if(embeddedDir.isEmpty())
            return true;
        else
            return false;
    }
}
