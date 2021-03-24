import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import system.TrigonometricFun;
import trig.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TrigonometricFunIntegrationTest {
    private static double eps = 1e-5;
    private static Sin sin;
    private static TrigonometricFun trigonometricFun;

    @BeforeAll
    public static void setup() {
        sin = Mockito.mock(Sin.class);

        when(sin.compute(0d)).thenReturn(0d);
        when(sin.compute(-Math.PI/3)).thenReturn(-0.866025404);
        when(sin.compute(-Math.PI/2)).thenReturn(-1d);
        when(sin.compute(-Math.PI*5/6)).thenReturn(-0.5);
        when(sin.compute(-Math.PI*3/2)).thenReturn(1d);
        when(sin.compute(-Math.PI*2)).thenReturn(0d);
        trigonometricFun = new TrigonometricFun(sin);
    }

    @Test
    public void testTrigFun() {
        assertEquals(0d, trigonometricFun.compute(0d), eps);
        assertEquals(-0.649519053, trigonometricFun.compute(-Math.PI/3), eps);
        assertEquals(-1d, trigonometricFun.compute(-Math.PI/2), eps);
        assertEquals(-0.125, trigonometricFun.compute(-Math.PI*5/6), eps);
        assertEquals(1d, trigonometricFun.compute(-Math.PI*3/2), eps);
        assertEquals(0d, trigonometricFun.compute(-Math.PI*2), eps);
    }
}
