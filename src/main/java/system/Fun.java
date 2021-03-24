package system;

abstract public class Fun {
    protected String funcName;
    public abstract double compute(double x);

    public String getFuncName() {
        return funcName;
    }
}
