package factory.confectionery.domain.cakes;

import factory.confectionery.interfaces.Filling;
import factory.confectionery.interfaces.Confection;
import factory.confectionery.interfaces.Testo;

import java.util.concurrent.TimeUnit;

public class Cake implements Confection, Testo, Filling {
    protected String name;
    protected String filling;
    protected String testo;

    public Cake(String name, String filling, String testo) {
        this.name = name.toLowerCase();
        this.filling = filling.toLowerCase();
        this.testo = testo.toLowerCase();
    }

    @Override
    public int getTimeCooking() {
        return 15;
    }

    @Override
    public void cook() {
        try {
            System.out.println("Начало приготовления торта");
            mixTesto();
            makeFilling();
            TimeUnit.MILLISECONDS.sleep(500 * getTimeCooking());
            System.out.println("Торт " + name + " готов");

        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void makeFilling() {
        System.out.println("Готовится начинка " + filling );
        System.out.println(filling + " замешивается");
        System.out.println(filling + " варится");
        System.out.println(filling + " для торта готов");

    }

    @Override
    public void mixTesto()  {
        System.out.println("Замешивается " + testo  + " тесто");
        System.out.println("Раскатыаваются коржи ");
        System.out.println("Выпекаются коржи");
        System.out.println("Тесто для торта " + name + " готово");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cake cake = (Cake) o;

        if (!name.equals(cake.name)) return false;
        if (!filling.equals(cake.filling)) return false;
        return testo.equals(cake.testo);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (filling != null ? filling.hashCode() : 0);
        result = 31 * result + (testo != null ? testo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Торт под названием " + name + "\nСостав: начинка " + filling  +
                " и " + testo + " тесто";
    }

}
