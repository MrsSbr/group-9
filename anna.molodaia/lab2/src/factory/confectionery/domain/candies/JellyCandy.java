package factory.confectionery.domain.candies;

public class JellyCandy extends CandyBase {
    private final String name;

    public JellyCandy(String name) {
        this.name = name.toLowerCase();
        filling = "желейная";
    }

    @Override
    public int getTimeCooking() {
        return 3;
    }

    @Override
    public void makeFilling() {
        System.out.println("Готовится начинка " + getFilling()  + " для конфеты " + name);
        System.out.println("Мешаем\nНачинка готова");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JellyCandy candy = (JellyCandy) o;

        return super.equals(candy) && name.equals(candy.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (name != null ? name.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Желейная конфета " +
                " под названием " + name;
    }
}
