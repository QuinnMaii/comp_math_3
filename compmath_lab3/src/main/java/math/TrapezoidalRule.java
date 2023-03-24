package math;

import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;

public class TrapezoidalRule {
    public static double calcIntegral(double a, double b, Function f, double eps) throws NumberFormatException {
        double currResult = 0, prevResult = 0;
        ArrayList<Double> secDerivatives = new ArrayList<>();
        for (int n = 1; n <= 2 || Math.abs(currResult - prevResult) > eps; n *= 2) {
            prevResult = currResult;
            currResult = 0;
            secDerivatives.clear();
            double h = (b - a) / n;
            for (int i = 0; i <= n; i++) {
                double tmp = f.calculate(a + h * i);
                if (!Double.isFinite(tmp)) {
                    tmp = (f.calculate(a + h * i - eps) + f.calculate(a + h * i + eps)) / 2;
                }
                if (i == 0 || i == n) {
                    tmp /= 2;
                }
                currResult += tmp;
                secDerivatives.add(Math.abs(calcSecDerivative(a + h * i, f, eps)));
            }
            currResult *= h;
            double R = secDerivatives.stream().max(Double::compareTo).get() * Math.pow(b - a, 3) / (12 * n);
            System.out.println("n = " + n + ", integral = " + currResult + ", R = " + R);
            if (R > Math.abs(currResult)) {
                System.out.println("There is no answer because there is an irreparable gap on the chosen interval!:(");
                throw new NumberFormatException();
            }
        }
        return currResult;
    }

    private static Double calcSecDerivative(double x, Function f, double eps) {
        return (f.calculate(x + 2 * eps) - 2 * f.calculate(x + eps) + f.calculate(x)) / (eps * eps);
    }
}
