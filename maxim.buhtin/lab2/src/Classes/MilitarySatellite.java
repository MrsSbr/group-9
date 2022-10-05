package Classes;


import java.util.Objects;

public class MilitarySatellite extends Satellite  {


    protected int countOfTasks;

    public MilitarySatellite(int speed, String planet, int life, String name, String appointment, int numberOfTasks) {
        super(speed, planet, life, name,appointment);
        this.countOfTasks = numberOfTasks;
    }

    @Override
    public void show() {
        System.out.println("Вы запустили космический спутник!");
    }

    @Override
    public String toString() {
        return super.toString() + "\nКоличество выполненных задач: " + countOfTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MilitarySatellite))
            return false;

        return this.name.equalsIgnoreCase(((MilitarySatellite) obj).name)
                && this.planet.equalsIgnoreCase(((MilitarySatellite) obj).planet)
                && this.appointment.equalsIgnoreCase(((MilitarySatellite) obj).appointment)
                && this.life == ((MilitarySatellite) obj).life
                &&this.countOfTasks==((MilitarySatellite) obj).countOfTasks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet, appointment, life,countOfTasks);

    }

    public void editCountOfTask(int CountTask){
        countOfTasks+=CountTask;
        System.out.println("Вы изменили количество выполненных задач у космического спутника!");
    }
}
