package Classes;

import Interface.Satellitable;

import java.util.Objects;

public class MedicalSatellite extends Satellite implements Satellitable {
    protected final String appointment;
    protected final int countOfLiveSaved;

    protected final int countOfLiveKill;

    public MedicalSatellite(int speed, String planet, int life, String name, String appointment,
                            int countOfLiveSaved, int countOfLiveKill) {
        super(speed, planet, life, name);
        this.appointment = appointment;
        this.countOfLiveSaved = countOfLiveSaved;
        this.countOfLiveKill = countOfLiveKill;
    }

    @Override
    public void show() {
        System.out.println("Вы запустили медицинский спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "Имя спутника: " + this.name + "\nСтандартная скорость: " + this.speed +
                "\nКоличество жизней: " + this.life + "\nПривязанность к планете: " + this.planet +
                "\nНазначение спутника: " + appointment + "\n: " + "\nКоличество убитых пациентов: " + countOfLiveKill +
                "\nКоличество спасенных пациентов: " + countOfLiveSaved;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MedicalSatellite))
            return false;

        return this.name.equalsIgnoreCase(((MedicalSatellite) obj).name)
                && this.planet == ((MedicalSatellite) obj).planet
                && this.appointment == ((MedicalSatellite) obj).appointment
                && this.life == ((MedicalSatellite) obj).life
                && this.countOfLiveKill == ((MedicalSatellite) obj).countOfLiveKill
                && this.countOfLiveSaved == ((MedicalSatellite) obj).countOfLiveSaved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life, countOfLiveKill, countOfLiveSaved);

    }
}
