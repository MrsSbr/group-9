package logic;

import Benchmark.Benchmark;
import Benchmark.Stat;
import Temparary.Service;
import Temparary.Temparary;
import Temparary.badTemparary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class BenchmarkTest {


    @Test
    public void notNullStat() {

        // when
        Stat actualStat = Benchmark.getStat(new Temparary());

        // then
        assertNotNull(actualStat);
    }
    @Test
    public void notNullTrack() {
        //given
        Service service = new Temparary();
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
            Stat actualStat = Benchmark.getStat(new badTemparary());
        }catch (RuntimeException e) {
            actual = e;
        }
        assertNotNull(actual);
    }


}