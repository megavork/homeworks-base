package classes.actions;

import classes.baseClasses.MyBase;

public class Touch extends ActionParent{
    public Touch() {
        this.action = "TOUCH";
    }

    @Override
    public void startAction(String customersResponse) {

        String fileName = customersResponse.substring(6,customersResponse.length());
        MyBase base = Pwd.getLastPathObject();
        base.putFile(fileName);
    }
}
