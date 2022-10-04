package Classes;

import Interface.Satellitable;

import java.util.Objects;

public class MaritimeSatellite extends Satellite implements Satellitable {
    protected final String appointment;
    protected final int immersionDepth;

    protected final int countOfTask;

    public MaritimeSatellite(int speed, String planet, int life, String name, String appointment,
                             int immersionDepth, int countOfTask) {
        super(speed, planet, life, name);
        this.appointment = appointment;
        this.immersionDepth = immersionDepth;
        this.countOfTask = countOfTask;
    }

    @Override
    public void show() {
        System.out.println("Вы запустили морской спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "Имя спутника: " + this.name + "\nСтандартная скорость: " + this.speed +
                "\nКоличество жизней: " + this.life + "\nПривязанность к планете: " + this.planet +
                "\nНазначение спутника: " + appointment + "\n: " + "\nГлубина погружения в метрах: " + immersionDepth +
                "\nКоличество выполненных задач: " + countOfTask;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MaritimeSatellite))
            return false;

        return this.name.equalsIgnoreCase(((MaritimeSatellite) obj).name)
                && this.planet == ((MaritimeSatellite) obj).planet
                && this.appointment == ((MaritimeSatellite) obj).appointment
                && this.life == ((MaritimeSatellite) obj).life
                && this.immersionDepth == ((MaritimeSatellite) obj).immersionDepth
                && this.countOfTask == ((MaritimeSatellite) obj).countOfTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life, immersionDepth, countOfTask);

    }
}
