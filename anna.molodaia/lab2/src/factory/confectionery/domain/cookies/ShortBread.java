package factory.confectionery.domain.cookies;

public class ShortBread extends CookieBase {
    private String name;

    public ShortBread(String name, String form) {

        testo = "Песочное";
        this.form = form;
        this.name = name;
    }

    @Override
    public int getTimeCooking() {
        return 5;
    }

    @Override
    public String toString() {
        return "Песочное печенье под названием " + name + " в форме " +
                form.toLowerCase() + " с cоставом: "+getTesto().toLowerCase()+" тестом ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortBread cookie = (ShortBread) o;

        return name.equals(cookie.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

}
