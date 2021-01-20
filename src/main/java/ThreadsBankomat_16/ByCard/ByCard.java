package ThreadsBankomat_16.ByCard;

import ThreadsBankomat_16.Checker.TimeMoneyChecker;

public class ByCard {

    private int currentMoney = TimeMoneyChecker.getInitialMoney();
    private boolean isDone = false;

    public Integer getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

}
