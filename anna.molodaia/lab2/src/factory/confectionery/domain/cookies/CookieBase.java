package factory.confectionery.domain.cookies;


import factory.confectionery.interfaces.Confection;
import factory.confectionery.interfaces.Testo;

import java.util.concurrent.TimeUnit;

public abstract class CookieBase implements Confection, Testo {
    protected String form = "Квадрат";
    protected String testo = "Дрожевое";

    public String getForm() {
        return this.form;
    }

    public String getTesto() {
        return testo + " тесто";
    }

    @Override
    public void mixTesto() {
        System.out.println("Готовим тесто для печенья");
        System.out.println("Замешивается " + getTesto().toLowerCase());
        System.out.println("Тесто для печенья готово");
    }

    @Override
    public int getTimeCooking() {
        return 10;
    }

    @Override
    public void cook() {
        try {
            mixTesto();
            System.out.println("Печенье выпекается в форме " + getForm().toLowerCase());
            TimeUnit.MILLISECONDS.sleep(500 * getTimeCooking());
            System.out.println("Печенье  готово");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
