package Temparary;

import Benchmark.Benchmarked;

public interface Service {
    @Benchmarked
    void counter();
}
