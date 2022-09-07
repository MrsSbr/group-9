package MathOperations;

public class CosOperations {

    public static double cosIteration(final double x, final int n) {


        int step = 0;
        double res = 0.0d;
        double tmp = 1.0d;
        for (int i = 0; i < n; i++) {

            res += tmp;
            tmp *= -(tmp * x * x) / ((2 * step + 2) * (2 * step + 1));
            step++;

        }

        return res;
    }

    public static double cosEpsilon(final double x, final double e) {

        int n = 0;
        double res = 0.0d;
        double tmp;
        tmp = x;
        while (Math.abs(tmp) > e) {

            res += tmp;
            tmp *= -(tmp * x * x) / ((2 * n + 2) * (2 * n + 1));
            n++;

        }

        return res;

    }

}
