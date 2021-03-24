import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import trig.Sin;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;

public class SinUnitTest {
    private HashMap<Double, Double> arrayTestValues = new HashMap<>();
    private static final double DELTA = 0.00001;
    private Sin sin = new Sin(DELTA);

    @Before
    public void setUp() {
        // ключ - x, значение - введенное значение - y

        //проверка нулевого значения
//        arrayTestValues.put( 0d, 0d);

        //проверка правой стороны
//        arrayTestValues.put(Math.PI / 6, 0.5);
//        arrayTestValues.put(Math.PI / 4, Math.sqrt(2) / 2);
//        arrayTestValues.put(Math.PI / 3, Math.sqrt(3) / 2);
//        arrayTestValues.put(Math.PI / 2, 1d);
        arrayTestValues.put(2*Math.PI / 3, Math.sqrt(3.0) / 2);
//        arrayTestValues.put(3* Math.PI / 4, Math.sqrt(2) / 2);
//        arrayTestValues.put(5*Math.PI / 6, 0.5);

        //проверка левой стороны (на четность)
//        arrayTestValues.put(-Math.PI / 6, -0.5);
//        arrayTestValues.put(-Math.PI / 4, -Math.sqrt(2) / 2);
//        arrayTestValues.put(-Math.PI / 3, -Math.sqrt(3) / 2);
//        arrayTestValues.put(-Math.PI / 2, -1d);
//        arrayTestValues.put(-2*Math.PI / 3, -Math.sqrt(3) / 2);
//        arrayTestValues.put(-3* Math.PI / 4, -Math.sqrt(2) / 2);
//        arrayTestValues.put(-5*Math.PI / 6, -0.5);

        //проверка граничных значений
//        arrayTestValues.put(-Math.PI, 0d);
//        arrayTestValues.put(Math.PI, 0d);

//        //тестирование NaN, Infinity
//        arrayTestValues.put(NaN, NaN);
//        arrayTestValues.put(Double.POSITIVE_INFINITY, NaN);
//        arrayTestValues.put(Double.NEGATIVE_INFINITY, NaN);

        //тестовые значения за границами -2pi ; 2pi
//        arrayTestValues.put(7*Math.PI / 6, -0.5);
//        arrayTestValues.put(-7*Math.PI / 6, 0.5);

    }

    @After
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void testSin() {
        double expected, actual;
        for (Map.Entry<Double, Double> entry : arrayTestValues.entrySet()) {
            expected = entry.getValue();

            actual = sin.compute(entry.getKey());
            System.out.println("x = " + entry.getKey() + " actual = " + actual
                    + " expected = " + expected);
            assertEquals(expected, actual, DELTA);
        }
    }
}
