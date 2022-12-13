package logic;

import org.junit.jupiter.api.Test;
import test.*;

import static org.junit.jupiter.api.Assertions.*;

class BenchmarkTest {


    @Test
    public void notNullStat() {

        // when
        Stat actualStat = Benchmark.getStat(new test());

        // then
        assertNotNull(actualStat);
    }
    @Test
    public void notNullTrack() {
        //given
        Service service = new test();
        // when
        Service actualService = Benchmark.track(service);

        // then
        assertNotNull(actualService);
    }
    @Test
    public void nullReactionTrack() {


        Service actualService = Benchmark.track(null);
        assertNull(actualService);
    }
    @Test
    public void nullReactionStat() {

        // when
        Stat actualStat = Benchmark.getStat(null);
        assertNull(actualStat);
    }
    @Test
    public void exeptionReactionStat() {
        Exception actual = null;
        // when
        try{
            Stat actualStat = Benchmark.getStat(new badTest());
        }catch (RuntimeException e) {
            actual = e;
        }
        assertNotNull(actual);
    }


}