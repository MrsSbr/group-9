package logic;

import Benchmark.Benchmark;
import Benchmark.Stat;
import Temparary.BadTemparary;
import Temparary.Service;
import Temparary.Temparary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BenchmarkTest {


    @Test
    public void notNullStat() {

        // when
        Stat actualStat = Benchmark.getStat(new Temparary());

        // then
        assertNotNull(actualStat);
    }

    @Test
    public void testStatContainsValue() {

        // when
        Stat actualStat = Benchmark.getStat(new Temparary());

        // then
        assertEquals(actualStat.getStats().size(), 1);
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

        assertThrows(RuntimeException.class, () -> {

            Stat actualStat = Benchmark.getStat(new BadTemparary());

        });
    }


}