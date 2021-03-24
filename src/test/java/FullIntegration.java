import log.Ln;
import log.Log2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import system.EquationSystem;
import system.LogarithmicFun;
import system.TrigonometricFun;
import trig.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FullIntegration {

    private static double eps = 1e-5;
    private static EquationSystem equationSystem;

    @BeforeAll
    public static void setup() {
        Sin sin = new Sin(eps);
        Ln ln = new Ln(eps);
        Log2 log2 = new Log2(ln);
        equationSystem = new EquationSystem(new TrigonometricFun(sin),new LogarithmicFun(ln,log2));
    }

    @Test
    public void systemTest() {
        assertEquals(0d, equationSystem.compute(-Math.PI*2), eps);
        assertEquals(-1d, equationSystem.compute(-Math.PI/2), eps);
        assertEquals(1d, equationSystem.compute(-Math.PI*3/2), eps);
        assertEquals(0d, equationSystem.compute(0d), eps);
        assertThrows(ArithmeticException.class, () -> equationSystem.compute(1d));
        assertEquals(0d, equationSystem.compute(2d), eps);
        assertEquals(0d, equationSystem.compute(100d), eps);
    }
}
