package Benchmark;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Stat {

    private final List<String> stats;

    public Stat() {

        this.stats = new ArrayList<>();

    }

    public void add(String text){

        stats.add(text);

    }
    public void print(PrintStream out) {

        for (var text:stats) {

            out.print(text);

        }

    }
}
