package log;

import system.Fun;

import static java.lang.StrictMath.pow;

public class Ln extends Fun {
    private double eps;
    private double ln2;
    private double ln1000;

    public Ln(double eps) {
        funcName="ln(x)";
        this.eps = eps * 0.001;
        ln2 = compute(2.0);
        ln1000 = compute(1000.0);
    }

    private double lnTailor(double val, int n) {
//        return pow(val - 1, n) / (n * pow(val, n));
        return pow(- 1, n-1) * pow(val-1, n)/n;
    }

    public double compute(double x) {
        if (eps < 0 || x < 0)
            throw new IllegalArgumentException("Точность должна быть положительной");

        if (x == 0d) return Double.NEGATIVE_INFINITY;

        // за данными значениями ряд расходится
        if (x > 2) return compute(x / 2d) + ln2;
        if (x <= 0.5) return compute(x * 1000d) - ln1000;

        double result = 0d;
        double current = 10d;
        double prev = 0d;
        int n = 1;
        while (Math.abs(prev - current) >= eps) {
            prev = current;
            current = lnTailor(x, n);
            result += current;
            n++;
        }
        return result;
    }
}
