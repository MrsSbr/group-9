package factory.confectionery.domain.candies;

import factory.confectionery.interfaces.Confection;
import factory.confectionery.interfaces.Filling;

import java.util.concurrent.TimeUnit;

public abstract class CandyBase implements Confection, Filling {
    protected String filling;

    public abstract void makeFilling();
    public String getFilling() {
        return filling;
    }
    public  void cook() {
        try {
            System.out.println("Конфета готовиться");
            makeFilling();
            System.out.println("Конфета застывает");
            TimeUnit.MILLISECONDS.sleep(500 * getTimeCooking());
            System.out.println("Конфета готова");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
