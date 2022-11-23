package factory.confectionery.domain.candies;

import factory.confectionery.interfaces.Confection;
import factory.confectionery.interfaces.Filling;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class CandyBase implements Confection, Filling {
    protected String filling;

    public abstract void makeFilling();

    public String getFilling() {
        return filling;
    }

    public void cook() {
        try {
            System.out.println("Конфета готовится");
            makeFilling();
            System.out.println("Конфета застывает");
            TimeUnit.MILLISECONDS.sleep(500 * getTimeCooking());
            System.out.println("Конфета готова");

        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CandyBase candyBase = (CandyBase) o;

        return filling.equals(candyBase.filling);
    }

    @Override
    public int hashCode() {
        return filling != null ? filling.hashCode() : 0;
    }
}
