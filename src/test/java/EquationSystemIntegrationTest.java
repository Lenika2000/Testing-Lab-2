import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import system.EquationSystem;
import system.LogarithmicFun;
import system.TrigonometricFun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class EquationSystemIntegrationTest {
    private double accuracy = 1e-5;
    private static  EquationSystem equationSystem;
    private static TrigonometricFun trigonometricFun;
    private static LogarithmicFun logarithmicFun;

    @BeforeAll
    public static void setup() {
        trigonometricFun = Mockito.mock(TrigonometricFun.class);

        when(trigonometricFun.compute(0d)).thenReturn(0d);
        when(trigonometricFun.compute(-Math.PI*2)).thenReturn(0d);
        when(trigonometricFun.compute(-Math.PI/2)).thenReturn(-1d);
        when(trigonometricFun.compute(-Math.PI*3/2)).thenReturn(1d);

        logarithmicFun = Mockito.mock(LogarithmicFun.class);

        when(logarithmicFun.compute(0d)).thenThrow(new IllegalArgumentException(""));
        when(logarithmicFun.compute(0d)).thenReturn(1d);
        when(logarithmicFun.compute(0d)).thenReturn(2d);
        when(logarithmicFun.compute(0d)).thenReturn(100d);

        equationSystem = new EquationSystem(trigonometricFun, logarithmicFun);
    }

    @Test
    public void testLeft() {
        assertEquals(0d, equationSystem.compute(0d), accuracy);
        assertEquals(0d, equationSystem.compute(-Math.PI*2), accuracy);
        assertEquals(-1d, equationSystem.compute(-Math.PI/2), accuracy);
        assertEquals(1d, equationSystem.compute(-Math.PI*3/2), accuracy);
    }

    @Test
    public void testRight() {
        assertThrows(IllegalArgumentException.class, () -> {
            equationSystem.compute(0);
        });
        assertEquals(0d, equationSystem.compute(1d), accuracy);
        assertEquals(0d, equationSystem.compute(2d), accuracy);
        assertEquals(0d, equationSystem.compute(100d), accuracy);
    }
}
