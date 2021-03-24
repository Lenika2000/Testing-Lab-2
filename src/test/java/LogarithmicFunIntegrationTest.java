import log.Ln;
import log.Log2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import system.LogarithmicFun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class LogarithmicFunIntegrationTest {
    private static double eps = 1e-5;
    private static Ln ln;
    private static Log2 log2;
    private static LogarithmicFun logarithmicFun;

    @BeforeAll
    public static void setup() {
        ln = Mockito.mock(Ln.class);

        when(ln.compute(1d)).thenReturn(0d);
        when(ln.compute(2d)).thenReturn(0.693147);
        when(ln.compute(3d)).thenReturn(1.098612);
        when(ln.compute(100d)).thenReturn(4.60517);

        log2 = Mockito.mock(Log2.class);

        when(log2.compute(1d)).thenReturn(0d);
        when(log2.compute(2d)).thenReturn(1d);
        when(log2.compute(3d)).thenReturn(1.584963);
        when(log2.compute(100d)).thenReturn(6.643856);

        logarithmicFun = new LogarithmicFun(ln,log2);
    }

    @Test
    public void testLogFun() {
        assertThrows(IllegalArgumentException.class, () -> {
            logarithmicFun.compute(0d);
        });
        assertThrows(ArithmeticException.class, () -> {
            logarithmicFun.compute(1d);
        });
        assertEquals(0, logarithmicFun.compute(2d), eps);
        assertEquals(0, logarithmicFun.compute(3d), eps);
        assertEquals(0, logarithmicFun.compute(100d), eps);
    }
}
