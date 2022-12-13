package test;

public interface Service {
    @Benchmarked
    void counter();
}
