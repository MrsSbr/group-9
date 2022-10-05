package Classes;

import Interface.Satellitable;

import java.util.Objects;

public abstract class Satellite implements Satellitable {
    protected int speed;
    protected int life;
    protected String planet;

    protected String name;

    protected String appointment;

    public Satellite(int speed, String planet, int life, String name, String appointment) {
        this.speed = speed;
        this.planet = planet;
        this.life = life;
        this.name = name;
        this.appointment = appointment;
    }

    public abstract void show();

    public String getPlanet() {
        return planet;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return super.toString() + "Имя спутника: " + this.name + "\nСтандартная скорость: " + this.speed +
                "\nКоличество жизней: " + this.life + "\nПривязанность к планете: " + this.planet +
                "\nНазначение спутника: " + appointment;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MilitarySatellite))
            return false;

        return this.name.equalsIgnoreCase(((MilitarySatellite) obj).name)
                && this.planet.equalsIgnoreCase(((MilitarySatellite) obj).planet)
                && this.appointment.equalsIgnoreCase(((MilitarySatellite) obj).appointment)
                && this.life == ((MilitarySatellite) obj).life;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life, speed);

    }
}
