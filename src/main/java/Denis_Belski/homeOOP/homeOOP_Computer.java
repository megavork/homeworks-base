package Denis_Belski.homeOOP;

import java.util.Random;

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
    private int lockUnlockResources = 0;
    private boolean flagFired = false;
    private int currentResources = lockUnlockResources;

    homeOOP_Computer () {
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

    public void powerOn(int number) {
        Random rand = new Random();

        if(flagFired || currentResources != 0) {
            System.out.println("Your computer fired!");
            return;
        }

        if(rand.nextInt(2) != number) {
            System.out.println("Your computer fired!");
        } else {
            System.out.println("Your computer on");
        }
        currentResources--;
    }

    public void powerOff(int number) {
        Random rand = new Random();

        if(flagFired || currentResources != 0) {
            System.out.println("Your computer fired!");
            return;
        }

        if(rand.nextInt(2) != number) {
            System.out.println("Your computer fired!");
        } else {
            System.out.println("Your computer off");
        }
        currentResources--;
    }
}
