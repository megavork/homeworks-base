package Denis_Belski.cross_zeross;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class game_field {

    private String[][] game_field = new String[3][3]; //rows and column
    private String row_underscores = new String("    -   -   -  ");
    private int[][] checkField = new int[3][3];
    private int countsOfCustomer = 0;

    private String customersMark = "";
    private String computersMark = "";

    private boolean hardMode = false;

    game_field () {
        String row_separator =   new String("   |");

        //сперва все забъем пустыми значениями,
        // чтобы исключить nullPointerException
        for(int i=0; i<game_field.length; i++) {
            for(int k=0; k<game_field.length; k++) {
                game_field[i][k] = "";
            }
        }

        //вкинем в нечетные строки разделители для колонок.
        for(int i=0; i<game_field.length; i++) {
            for(int k=0; k<game_field.length; k++) {
                if(k==0) {
                    game_field[i][k] = new String(i + 1 +" |   |");
                } else {
                    game_field[i][k] = row_separator;
                }
            }
        }
        //создадим мини-массив для навигации, где кто что поставил
        for(int i=0; i<checkField.length; i++) {
            for (int k = 0; k < checkField.length; k++) {
                checkField[i][k] = 0;
            }
        }
    }

    public void show_field() {

        System.out.println("    1   2   3  ");
        System.out.println(row_underscores);

        for(int i=0; i<game_field.length; i++) {

            for(int k=0; k<game_field.length; k++) {
                System.out.print(this.game_field[i][k]);
            }
            System.out.println();
            System.out.println(row_underscores);
        }
    }

    private int addCustomerMarkToField(int row, int column) {

        row--;
        column--;

        /*
        добавим в знак на поле
         */
        for (int i = 0; i < game_field.length; i++) {
            for (int k = 0; k < game_field.length; k++) {

                String correction = game_field[i][k];
                if (k == row && i == column) {
                    if (row == 0) {
                        correction = i + 1 + " | " + this.customersMark + " |";
                    } else {
                        correction = " " + this.customersMark + " |";
                    }
                    checkField[i][k] = 10;
                }
                game_field[i][k] = correction;
            }
        }
        this.addComputersMark();

        //System.out.println("Comp mark added.");

        // выведем новое поле на экран
        this.show_field();

        /*
        for (int i = 0; i < checkField.length; i++) {
            System.out.println(Arrays.toString(checkField[i]));
        }
        */
        int letsCheck = checkField();

        if (letsCheck == 100) {
            System.out.println("YOU WIN!");
            return 100;
        } else if (letsCheck == -100) {
            System.out.println("You LOSE!");
            return -100;
        } else if(letsCheck == 200) {
            return 200;
        } else {
            return 0;
        }
    }

    public int putCustomerMark(String whereMark) {
        String[] result = whereMark.split(",");
        int row = Integer.parseInt(result[0]);
        int column = Integer.parseInt(result[1]);

        if(checkField[row-1][column-1] != 0) {
            System.out.println("Does already exist. PLease, change your answer.");
            //System.out.println(Arrays.toString(checkField[row-1]));
            return 0;
        }
        int checkWin = this.addCustomerMarkToField(column,row);
        return checkWin;
    }

    public void getCustomerMark(int checkMark) {
        if(checkMark == 1) {        //если 1, то за О
            this.customersMark = "X";
            this.computersMark = "O";
        } else if(checkMark == 0) {
            this.customersMark = "O";
            this.computersMark = "X";
        }
    }

    private void addComputersMark() {

        if(hardMode) {      //если хард включен, то идем в него
            this.hardMode();
        } else {

            Random rand = new Random();

            int row = rand.nextInt(this.checkField.length);
            int column = rand.nextInt(this.checkField.length);

            while (checkField[row][column] != 0) {
                row = rand.nextInt(this.checkField.length);
                column = rand.nextInt(this.checkField.length);
            }
            //System.out.println(Arrays.toString(checkField[1]));

            for (int i = 0; i < game_field.length; i++) {
                for (int k = 0; k < game_field.length; k++) {

                    String correction = game_field[i][k];
                    if (k == column && i == row) {
                        if (column == 0) {
                            correction = i + 1 + " | " + this.computersMark + " |";
                        } else {
                            correction = " " + this.computersMark + " |";
                        }
                        checkField[i][k] = -10;
                    }
                    game_field[i][k] = correction;
                }
            }
        }
    }

    private int checkField() {

        int[] checkResult = new int[4];
        int count = 0;  //сделаю счетчик, чтобы проче было выловить все ли поля заполнены

        checkResult[0] = this.checkAllRows();
        //System.out.println("Check row: "+checkResult[0]);
        checkResult[1] = this.checkAllColumns();
        //System.out.println("Check column: "+checkResult[1]);
        checkResult[2] = this.checkMainDiagonal();
        //System.out.println("Check main diag: "+checkResult[2]);
        checkResult[3] = this.checkSecondDiagonal();
        //System.out.println("Check bad diag: "+checkResult[3]);

        for(int i=0; i<checkResult.length; i++) {
            if(checkResult[i] != 0) {
                return checkResult[i];
            }
        }
        return 0;
    }

    private int checkAllRows() {

        //все строки
        for(int i=0; i<game_field.length; i++) {
            if(checkField[i][0] > 0 && checkField[i][1] > 0 && checkField[i][2] > 0){
                return 100;
            } else if(checkField[i][0] < 0 && checkField[i][1] < 0 && checkField[i][2] < 0) {
                //System.out.println("row="+i);
                return -100;
            }
        }
        return 0;
    }
    private int checkAllColumns() {

        //все столбцы
        for(int i=0; i<game_field.length; i++) {
            if(checkField[0][i] < 0 && checkField[1][i] < 0 && checkField[2][i] < 0) {
                return -100;
            } else if(checkField[0][i] > 0 && checkField[1][i] > 0 && checkField[2][i] > 0) {
                return 100;
            }
        }
        return 0;
    }
    private int checkMainDiagonal() {

        int fullCustomerRow = 0;
        int fullCompRow = 0;
        //главная диагональ
        for(int i=0; i<game_field.length; i++) {
            if (checkField[i][i] > 0) {
                fullCustomerRow++;
            } else if (checkField[i][i] < 0){
                fullCompRow++;
            }
        }
        if(fullCustomerRow == 3) {
            return 100;
        } else if(fullCompRow == 3){
            return -100;
        }
        return 0;
    }

    private int checkSecondDiagonal() {

        int fullCustomerRow = 0;
        int fullCompRow = 0;
        //побочная диагональ
        for(int i=0; i<game_field.length; i++) {

            if (checkField[i][game_field.length-i-1] > 0) {
                fullCustomerRow++;
            } else if (checkField[i][game_field.length-i-1] < 0) {
                fullCompRow++;
            }
        }

        if(fullCustomerRow == 3) {
            return 100;
        } else if(fullCompRow == 3){
            return -100;
        }
        return 0;
    }

    private void hardMode() {
        Random rand = new Random();

        //генерируем координаты куда комп поставит символ
        int row = -1;
        int column = -1;

        //проверим поле
        //все строки
        //
        //если пользователь ввел два рядом стоящих значения,
        //то нужно не дать ему поставить в 3е поле знак, иначе он победит
        for(int i=0; i<game_field.length; i++) {
            if(checkField[i][0] > 0 && checkField[i][1] > 0 && checkField[i][2] == 0) {
                row = i;
                column = 2;
                break;
            }
            if (checkField[i][1] > 0 && checkField[i][2] > 0 && checkField[i][0] == 0) {
                row = i;
                column = 0;
                break;
            }
        }
        //System.out.println("row="+row + "col="+column);
        // проверяем столбцы
        if(row < 0 && column < 0) {
            //все столбцы
            for (int i = 0; i < game_field.length; i++) {
                if (checkField[0][i] > 0 && checkField[1][i] > 0 && checkField[2][i] == 0) {
                    row = 2;
                    column = i;
                    break;
                } else if (checkField[0][i] == 0 && checkField[1][i] > 0 && checkField[2][i] > 0) {
                    row = 0;
                    column = i;
                    break;
                }
            }
        }
        //проверяем главную диагональ
        //System.out.println("row="+row + "col="+column);
        if(row < 0 && column < 0) {
            if (checkField[0][0] > 0 && checkField[1][1] > 0 && checkField[2][2] == 0) {
                row = 2;
               column = 2;
            } else if (checkField[0][0] > 0 && checkField[1][1] > 0 && checkField[2][2] == 0) {
                row = 0;
                column = 0;
            }
        }
        //проверяем побочную диагональ
        if(row < 0 && column < 0) {
            if (checkField[0][2] > 0 && checkField[1][1] > 0 && checkField[2][0] == 0) {
                row = 2;
                column = 0;
            } else if (checkField[1][1] == 0 && checkField[2][1] > 0 && checkField[0][2] > 0) {
                row = 1;
                column = 1;
            }
        }
        //если пользователь не ввел 2 рядом стоящих значения, то генерируем любые свои.
        //сперва проверим, сколько у нас пустых клеток
        if(row < 0 && column < 0) {
            row=rand.nextInt(3);;
            column=rand.nextInt(3);
            while(checkField[row][column] != 0) {
                row = rand.nextInt(3);
                column = rand.nextInt(3);
            }
        }
        //пользователь сделал ход
        this.countsOfCustomer++;

        //вывод
        for(int i=0; i<game_field.length; i++) {
            for(int k=0; k<game_field.length; k++) {

                String correction = game_field[i][k];
                if(k==column && i==row) {
                    if(k==0) {
                        correction = i + 1 + " | " + this.computersMark + " |";
                    } else {
                        correction = " " + this.computersMark + " |";
                    }
                    checkField[i][k] = -10;
                }
                game_field[i][k] = correction;
            }
        }
    }

    public void getHardMode(boolean mode) {
        this.hardMode = mode;
    }

    public int getFreeField() {
        int count = 0;
        for(int i=0; i<game_field.length; i++) {
            for (int k = 0; k < game_field.length; k++) {
                if(checkField[i][k] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
