package utils;

import java.util.Locale;

public class Convertor {
    public static String toPrecision(double n, double eps) {
        int count = 0;
        while (eps < 1) {
            eps *= 10;
            count++;
        }
        return String.format(Locale.ENGLISH, "%." + count + "f", n);
    }
}
