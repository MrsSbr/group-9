package Classes;


import java.util.Objects;

public class MedicalSatellite extends Satellite {

    protected int countOfLiveSaved;

    protected int countOfLiveKill;

    public MedicalSatellite(int speed, String planet, int life, String name, String appointment,
                            int countOfLiveSaved, int countOfLiveKill) {
        super(speed, planet, life, name, appointment);
        this.countOfLiveSaved = countOfLiveSaved;
        this.countOfLiveKill = countOfLiveKill;
    }


    @Override
    public void show() {
        System.out.println("Вы запустили медицинский спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "\nКоличество убитых пациентов: " + countOfLiveKill +
                "\nКоличество спасенных пациентов: " + countOfLiveSaved;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MedicalSatellite))
            return false;

        return this.name.equalsIgnoreCase(((MedicalSatellite) obj).name)
                && this.planet.equalsIgnoreCase(((MedicalSatellite) obj).planet)
                && this.appointment.equalsIgnoreCase(((MedicalSatellite) obj).appointment)
                && this.life == ((MedicalSatellite) obj).life
                && this.countOfLiveKill == ((MedicalSatellite) obj).countOfLiveKill
                && this.countOfLiveSaved == ((MedicalSatellite) obj).countOfLiveSaved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life, countOfLiveKill, countOfLiveSaved);

    }

    public void editLive(int Live) {
        countOfLiveSaved += Live;
        System.out.println("Вы изменили количество спасенных жизней!");
    }
}
