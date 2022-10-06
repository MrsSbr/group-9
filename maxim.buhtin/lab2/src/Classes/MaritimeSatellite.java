package Classes;


import java.util.Objects;

public class MaritimeSatellite extends Satellite {
    protected int immersionDepth;


    public MaritimeSatellite(int speed, String planet, int life, String name, String appointment,
                             int immersionDepth) {
        super(speed, planet, life, name, appointment);
        this.immersionDepth = immersionDepth;
    }

    @Override
    public void show() {
        System.out.println("Вы запустили морской спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "\nГлубина погружения в метрах: " + immersionDepth;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MaritimeSatellite))
            return false;

        return this.name.equalsIgnoreCase(((MaritimeSatellite) obj).name)
                && this.planet.equalsIgnoreCase(((MaritimeSatellite) obj).planet)
                && this.appointment.equalsIgnoreCase(((MaritimeSatellite) obj).appointment)
                && this.life == ((MaritimeSatellite) obj).life
                && this.immersionDepth == ((MaritimeSatellite) obj).immersionDepth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life, immersionDepth);

    }

    public void editImmersionDepth(int Depth) {
        this.immersionDepth += Depth;
        System.out.println("Глубина погружения морского спутника изменена!");
    }

    public void printImmersionDepth() {
        System.out.println("Глубина погружения морского спутника!= " + immersionDepth);
    }

}
