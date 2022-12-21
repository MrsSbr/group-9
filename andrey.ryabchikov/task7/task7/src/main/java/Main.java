import Benchmark.Benchmark;
import Benchmark.Stat;
import Temparary.Service;
import Temparary.Temparary;

public class Main {
    public static void main(String[] args) {

        Service service = new Temparary();
        Service trackedService = Benchmark.track(service);
        trackedService.counter();
        Stat stat = Benchmark.getStat(service);
        stat.print(System.out);

    }
}