package MathOperations;

public class SinOperations {

    public static double sinIteration(final double x, final int n) {

        int step = 1;
        double res = 0.0d;
        double tmp = 1.0d;
        for (int i = 0; i < n; i++) {

            res += tmp;
            tmp *= (-1) * x * x / (2 * step) / (2 * step + 1);
            step++;

        }

        return res;

    }

    public static double sinEpsilon(final double x, final double e) {

        double res = 0.0d;
        double tmp;
        tmp = x;
        while (Math.abs(tmp) > e) {

            int n = 1;
            res += tmp;
            n++;
            tmp *= (-1) * x * x / (2 * n) / (2 * n + 1);

        }

        return res;

    }

}
