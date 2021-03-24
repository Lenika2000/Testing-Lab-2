package trig;

import system.Fun;

import static java.lang.Math.*;

public class Sin extends Fun {
    private double eps;

    public Sin(double eps) {
        funcName = "sin(x)";
        this.eps = eps;
    }

    private double shortenRange(double x) {
        if (x > PI || x < -PI) {
            double k = x % (2 * PI);
            if (k < -PI) {
                return k + 2 * PI;
            }
            if (k > PI) {
                return k - 2 * PI;
            }
            return k;
        } else {
            return x;
        }
    }

    private double sinTailor(double val, int n) {
        return pow(-1, n) * pow(val, 2 * n + 1) / factorial(2 * n + 1);
    }

    public double compute(double x) {
        x = shortenRange(x);
        System.out.print(x < Math.PI && x > -Math.PI);
        if (eps <= 0)
            throw new IllegalArgumentException("Точность должна быть положительным числом");
        double result = 0d;
        double current = 10d;
        double prev = 0d;
        int n = 0;
        while (Math.abs(prev - current) >= eps) {
            prev = current;
            current = sinTailor(x, n);
            result += current;
            n++;
        }
        return result;
//        if (eps <= 0)
//            throw new IllegalArgumentException();
//
//        x %= 2 * PI;
//        boolean minus = false;
//        if (x <= -PI && x > -PI * 2)
//            x = x + 2 * PI;
//
//
//        if(x<0 && x>-PI){
//            x+= PI;
//            minus = true;
//        }
//
//        if (x > PI && x <= PI * 2) {
//            x = 2 * PI - x;
//            minus = true;
//        }
//
//        if (x <= PI && x > PI / 2)
//            x = PI - x;
//
//        double result = 0;
//        double current = 10;
//        double prev = 0;
//        int n = 0;
//        while (Math.abs(prev - current) >= eps) {
//            prev = current;
//            current = sinTailor(x, n);
//            result += current;
//            n++;
//        }
//        return minus?-result:result;
    }

    private int factorial(int val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }
}

