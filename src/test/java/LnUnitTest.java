import log.Ln;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LnUnitTest {
    private HashMap<Double, Double> arrayTestValues = new HashMap<>();
    private static final double DELTA = 0.00001;
    private Ln ln = new Ln(DELTA);

    @Before
    public void setUp() {
        // ключ - x, значение - введенное значение - y

        arrayTestValues.put( 0d, Double.NEGATIVE_INFINITY);
        arrayTestValues.put( 0.1, -2.302585092994045684017991454);
        arrayTestValues.put( 0.5, -0.69315);
        // пересечение с осью OX
        arrayTestValues.put( 1d, 0d);
        arrayTestValues.put( 1.4, 0.33647223662121293050459341021);
        arrayTestValues.put( 2d, 0.693147180559945309417232);
        // проверка для x>2
        arrayTestValues.put( 3d, 1.098612);
        arrayTestValues.put( 100d, 4.60517);
    }

    @After
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void testLn() {
        double expected, actual;
        for (Map.Entry<Double, Double> entry : arrayTestValues.entrySet()) {
            expected = entry.getValue();

            actual = ln.compute(entry.getKey());
            System.out.println("x = " + entry.getKey() + " actual = " + actual
                    + " expected = " + expected);
            assertEquals(expected, actual, DELTA);
        }
    }
}
