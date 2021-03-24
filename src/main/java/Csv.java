import log.Ln;
import log.Log2;
import system.EquationSystem;
import system.Fun;
import system.LogarithmicFun;
import system.TrigonometricFun;
import trig.Sin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Csv {

    public static void logModuleToCSV(Fun module, double from,
                                      double to, double step) {

        File file = new File("src/main/resources/" +
                module.getFuncName() + ".csv");

        try {
            FileWriter fr = new FileWriter(file);
            fr.write("X,"+module.getFuncName()+'\n');
            for (double i = from; i < to; i += step) {
                fr.write(String.valueOf(i));
                fr.write(',');
                fr.write(String.valueOf(module.compute(i)));
                fr.write('\n');
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        double eps = 0.01;
        Sin sin = new Sin(eps);
        Ln ln = new Ln(eps);
        Log2 log2 = new Log2(ln);
        logModuleToCSV(new EquationSystem(new TrigonometricFun(sin),new LogarithmicFun(ln,log2)),-5,3,0.1);
        logModuleToCSV(new LogarithmicFun(ln,log2),0.001,5,0.1);
        logModuleToCSV(ln,0.001,14,0.1);
        logModuleToCSV(log2,0.001,20,0.1);
        logModuleToCSV(new TrigonometricFun(sin),-5,0,0.1);
        logModuleToCSV(sin,-8,0,0.1);
    }
}
