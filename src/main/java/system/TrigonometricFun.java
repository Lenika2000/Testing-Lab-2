package system;

import trig.Sin;

public class TrigonometricFun extends Fun {
    private Sin sin;

    public TrigonometricFun(Sin sin) {
        funcName="trigFunction.csv(x)";
        this.sin = sin;
    }

    public double compute(double x) {
        return Math.pow(sin.compute(x), 3);
    }
}
