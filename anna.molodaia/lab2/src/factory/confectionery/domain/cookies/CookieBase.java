package factory.confectionery.domain.cookies;


import factory.confectionery.interfaces.Confection;
import factory.confectionery.interfaces.Testo;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class CookieBase implements Confection, Testo {
    protected String form;
    protected String testo;

    public String getForm() {
        return this.form;
    }

    public String getTesto() {
        return testo + " тесто";
    }

    @Override
    public void mixTesto() {
        System.out.println("Готовим тесто для печенья");
        System.out.println("Замешивается " + getTesto() );
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
            System.out.println("Печенье выпекается в форме " + getForm());
            TimeUnit.MILLISECONDS.sleep(500 * getTimeCooking());
            System.out.println("Печенье  готово");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CookieBase that = (CookieBase) o;

        if (!form.equals(that.form)) return false;
        return testo.equals(that.testo);
    }

    @Override
    public int hashCode() {
        int result = form != null ? form.hashCode() : 0;
        result = 31 * result + (testo != null ? testo.hashCode() : 0);
        return result;
    }
}
