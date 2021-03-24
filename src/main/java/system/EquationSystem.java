package system;

public class EquationSystem extends Fun {
    TrigonometricFun trigonometricFun;
    LogarithmicFun logarithmicFun;

    public EquationSystem(TrigonometricFun trigonometricFun, LogarithmicFun logarithmicFun) {
        this.trigonometricFun = trigonometricFun;
        this.logarithmicFun = logarithmicFun;
        funcName="equationSystem(x)";
    }

    public double compute(double x) {
        if (x <= 0) {
           return trigonometricFun.compute(x);
        } else {
           return logarithmicFun.compute(x);
        }
    }
}
