package utils;

import org.mariuszgromada.math.mxparser.Function;

import java.util.Scanner;

public class IOUnit {
    private static final Scanner reader = new Scanner(System.in);

    private static void handleError(String msg) {
        System.out.println(msg);
        System.out.println("Enter = repeat input, any other key + Enter = exit:");
        if (reader.nextLine().isEmpty()) {
            return;
        }
        System.out.println("The program exits.");
        System.exit(-1);
    }

    public static double inputA() {
        double a;
        while (true) {
            System.out.println("Enter the lower limit of the integral:");
            String tmp = reader.nextLine();
            try {
                a = Double.parseDouble(tmp);
                break;
            } catch (NumberFormatException e) {
                handleError("Input Error! You need to enter a real number with a dot (\".\") as a separator.");
            }
        }
        return a;
    }

    public static double inputB(double a) {
        double b;
        while (true) {
            System.out.println("Enter the upper limit of the integral");
            String tmp = reader.nextLine();
            try {
                b = Double.parseDouble(tmp);
                if (b <= a) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Input error! You need to enter a valid number with a dot (\".\") as separator that is greater than \"" + a + "\".");
            }
        }
        return b;
    }

    public static Function inputFunction() {
        Function f;
        while (true) {
            System.out.println("Enter the integranl function f(x):");
            String tmp = reader.nextLine();
            f = new Function("f", tmp, "x");
            try {
                if (!f.checkSyntax()) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                handleError("Input error! The function you entered did not pass the syntax check.");
            }
        }
        return f;
    }

    public static double inputEps() {
        double eps;
        while (true) {
            System.out.println("Enter the precision:");
            String tmp = reader.nextLine();
            try {
                eps = Double.parseDouble(tmp);
                if (eps <= 0 || eps >= 1) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Input Error! You need to enter a positive real number that is less than 1, with a dot(\".\") as a separator.");
            }
        }
        return eps;
    }
}
