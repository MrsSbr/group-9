package MathsOperations;

public class CosOperations {

    public static double cosIteration(double x, int n) {

        int step = 0;
        double res = 0.0;
        double tmp = 1.0;

        for (int i = 0; i < n; ++i) {

            res += tmp;
            tmp *= -(tmp * x * x) / (double) ((2 * step + 2) * (2 * step + 1));
            ++step;

        }

        return res;

    }

    public static double cosEpsilon(double x, double e) {

        int n = 0;
        double res = 0.0;

        for (double tmp = x; Math.abs(tmp) > e; ++n) {

            res += tmp;
            tmp *= -(tmp * x * x) / (double) ((2 * n + 2) * (2 * n + 1));

        }

        return res;

    }

}
