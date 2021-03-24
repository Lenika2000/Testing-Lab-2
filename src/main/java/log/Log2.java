package log;

import system.Fun;

public class Log2 extends Fun {
    private Ln ln;
    private double ln2;

    public Log2(Ln ln) {
        funcName="log2(x)";
        this.ln = ln;
        ln2 = ln.compute(2.0);
    }

    public double compute(double x) {
        return ln.compute(x) / ln2;
    }
}
