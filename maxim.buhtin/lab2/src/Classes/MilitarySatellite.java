package Classes;

import Interface.Satellitable;

import java.util.Objects;

public class MilitarySatellite extends Satellite implements Satellitable {

    protected final String appointment;
    protected final int countOfTasks;

    public MilitarySatellite(int speed, String planet, int life, String name, String appointment, int numberOfTasks) {
        super(speed, planet, life, name);
        this.appointment = appointment;
        this.countOfTasks = numberOfTasks;
    }

    @Override
    public void show() {
        System.out.println("Вы запустили космический спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "Имя спутника: " + this.name + "\nСтандартная скорость: " + this.speed +
                "\nКоличество жизней: " + this.life + "\nПривязанность к планете: " + this.planet +
                "\nНазначение спутника: " + appointment + "\nКоличество выполненных задач: " + countOfTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MilitarySatellite))
            return false;

        return this.name.equalsIgnoreCase(((MilitarySatellite) obj).name)
                && this.planet == ((MilitarySatellite) obj).planet
                && this.appointment == ((MilitarySatellite) obj).appointment
                && this.life == ((MilitarySatellite) obj).life;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life);

    }
}
