package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(1 > 0);
    }

    @Test
    public void getMaxValue() {
        int max = App.showMax(3, 9);
        assertEquals(9, max);
    }

    @Test
    public void getAnotherMaxValue() {
        int max = App.showMax(9, 3);
        assertEquals(9, max);
    }
}
