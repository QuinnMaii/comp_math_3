import math.TrapezoidalRule;
import org.mariuszgromada.math.mxparser.Function;

import static utils.Convertor.toPrecision;
import static utils.IOUnit.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("You are using the Trapezoid method to calculate the integral.");
        double a = inputA();
        double b = inputB(a);
        Function f = inputFunction();
        double eps = inputEps();
        try {
            System.out.println("Answer: " + toPrecision(TrapezoidalRule.calcIntegral(a, b, f, eps), eps));
        } catch (NumberFormatException e) {
        }
    }
}
