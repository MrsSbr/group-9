package factory.confectionery.domain.cookies;

public class ShortBread extends CookieBase {
    private String name;

    public ShortBread(String name, String form) {

        testo = "песочное";
        this.form = form.toLowerCase();
        this.name = name.toLowerCase();
    }

    @Override
    public int getTimeCooking() {
        return 5;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Песочное печенье под названием " + name + " в форме " +
                form + " с составом: " + getTesto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShortBread cookie = (ShortBread) o;

        return super.equals(cookie) && name.equals(cookie.name);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + (name != null ? name.hashCode() : 0);
    }

}
