package factory.confectionery.domain.candies;

public class JellyCandy extends CandyBase {
    final private String name;

    public JellyCandy(String name) {
        this.name = name;
        filling = "Желейная";
    }

    @Override
    public int getTimeCooking() {
        return 3;
    }

    @Override
    public void makeFilling() {
        System.out.println("Готовится начинка " + getFilling().toLowerCase() + " для конфеты " + name);
        System.out.println("Мешаем\nНачинка готова");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JellyCandy candy = (JellyCandy) o;

        return name.equals(candy.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Желейная конфета " +
                " под названием " + name;
    }
}
