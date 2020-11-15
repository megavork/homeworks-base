package Denis_Belski.homeOOP;

import java.util.Random;
import java.util.Scanner;

/*
Поля:
- процессор
- оперативка
- жесткий диск
- ресурс полных циклов работы (включений/выключений)
Методы:
- метод описание(вывод всех полей)
- метод включить, при включении может произойти сбой, при вывзове метода
рандом загадывает число (0 либо 1), вы вводите число с клавиатуры, если
угадали комп выключается, если нет сгорает.Если комп сгорел, при попытке
включить нужно выдать сообщение что ему конец
- выключить (аналогично включению)
- при превышении лимита ресурса комп сгорает
 */
public class homeOOP_Computer {

    private String processorType = "";
    private String RAM = "";
    private String hardDisk = "";
    private int lockUnlockResources = 5;

    private boolean flagFired = false;
    private boolean flagToAsk = false;
    private int currentResources = lockUnlockResources;

    public homeOOP_Computer () {
        this.processorType = "AMD";
        this.RAM = "DDR4";
        this.hardDisk = "16 GB";
        this.lockUnlockResources = 5;
    }

    public void showAllFields() {
        System.out.println("Processor type: "+this.processorType);
        System.out.println("Ram: "+this.RAM);
        System.out.println("Hard disk: "+this.hardDisk);
        System.out.println("Cycle resources: "+this.lockUnlockResources);
    }

    public int powerOn(int number) {
        currentResources--;
        Random rand = new Random();

        if(flagFired || currentResources == 0) {
            System.out.println("End of resources. Your computer fired!");
            return -1;
        }

        if(rand.nextInt(2) != number) {
            System.out.println("Your computer fired!");
            return -1;
        } else {
            System.out.println("Your computer on");
            return 0;
        }
    }

    public int powerOff(int number) {
        currentResources--;
        Random rand = new Random();

        if(flagFired || currentResources == 0) {
            System.out.println("End of resources. Your computer fired!");
            return -1;
        }

        if(rand.nextInt(2) != number) {
            System.out.println("Your computer fired!");
            return -1;
        } else {
            System.out.println("Your computer off");
            return 0;
        }
    }
    public int getAnswer() {
        String answer = "";
        int number = 0;

        if(currentResources == 0) {
            System.out.println("Your computer fired!");
            return -1;
        }

        if(flagToAsk) {
            System.out.print("Try to OFF your computer. ");
        } else {
            System.out.print("Try to ON your computer. ");
        }

        Scanner in = new Scanner(System.in);

        for(int i=0; i<100; i++) {
            System.out.print("Enter your variable: ");
            answer = in.nextLine();
            try {
                number = Integer.parseInt(answer);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bad value. Try again.");
                continue;
            }
        }
        if(flagToAsk) {
            flagToAsk = false;
            return this.powerOff(number);
        } else {
            flagToAsk = true;
            return this.powerOn(number);
        }
    }
}
