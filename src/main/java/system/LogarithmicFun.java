package system;

import log.Ln;
import log.Log2;

public class LogarithmicFun extends Fun {
    private Ln ln;
    private Log2 log2;

    public LogarithmicFun(Ln ln, Log2 log2) {
        funcName="logFunction.csv(x)";
        this.ln = ln;
        this.log2 = log2;
    }

    public double compute(double x) throws ArithmeticException {
        if (x == 0) throw new IllegalArgumentException("Выход за пределы области определения");
        if (log2.compute(x) == 0) throw new ArithmeticException("Деление на ноль!");
        return Math.pow(((log2.compute(x) - ln.compute(x)) / log2.compute(x)), 27);
    }
}
