package MathsOperations;

public class SinOperations {

    public static double sinIteration(double x, int n) {

        int step = 1;
        double res = 0.0;
        double tmp = 1.0;

        for (int i = 0; i < n; ++i) {

            res += tmp;
            tmp *= -1.0 * x * x / (double) (2 * step) / (double) (2 * step + 1);
            ++step;

        }

        return res;

    }

    public static double sinEpsilon(double x, double e) {

        int n = 0;
        double res = 0.0;

        for (double tmp = x; Math.abs(tmp) > e; ++n) {

            res += tmp;
            tmp *= -1.0 * x * x / (double) (2 * n) / (double) (2 * n + 1);

        }

        return res;

    }

}
