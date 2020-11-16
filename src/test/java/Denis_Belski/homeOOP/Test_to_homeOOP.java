package Denis_Belski.homeOOP;

import Denis_Belski.homeOOP.homeOOP_Computer;
import org.example.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class Test_to_homeOOP {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerZeroOff() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOff(0);
        assertEquals(0,result);
    }

    @Test
    public void shouldAnswerOneOff() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOff(1);
        assertEquals(0,result);
    }

    @Test
    public void shouldAnswerMinesOneOff() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOff(6);
        assertEquals(-1,result);
    }

    @Test
    public void shouldAnswerZeroOn() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOn(0);
        assertEquals(0,result);
    }

    @Test
    public void shouldAnswerOneOn() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOn(1);
        assertEquals(0,result);
    }

    @Test
    public void shouldAnswerMinesOneOn() {
        homeOOP_Computer task = new homeOOP_Computer();
        int result = task.powerOn(6);
        assertEquals(-1,result);
    }

    @Test
    public void getAnotherMaxValue() {
        int max = App.showMax(9, 3);
        assertEquals(9, max);
    }
}
