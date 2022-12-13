import test.*;

public class Main {
    public static void main(String[] args) {

        Service service = new test();
        Service trackedService = Benchmark.track(service);
        trackedService.counter();
        Stat stat = Benchmark.getStat(service);
        stat.print(System.out);

    }
}