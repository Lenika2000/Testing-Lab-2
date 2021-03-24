import log.Ln;
import log.Log2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogarithmicIntegrationTest {
    private static double eps = 1e-5;
    private static Ln ln;
    private static Log2 log2;

    @BeforeAll
    public static void setup() {
        ln = Mockito.mock(Ln.class);

        when(ln.compute(0.5)).thenReturn(-0.693147181);
        when(ln.compute(1d)).thenReturn(0d);
        when(ln.compute(2d)).thenReturn(0.693147);
        when(ln.compute(3d)).thenReturn(1.098612);
        when(ln.compute(100d)).thenReturn(4.60517);

        log2 = new Log2(ln);
    }

    @Test
    public void testLog2() {
        assertEquals(-1, log2.compute(0.5), eps);
        assertEquals(0, log2.compute(1d), eps);
        assertEquals(1, log2.compute(2d), eps);
        assertEquals(1.584962501, log2.compute(3d), eps);
        assertEquals(6.64385619, log2.compute(100d), eps);
    }
}
