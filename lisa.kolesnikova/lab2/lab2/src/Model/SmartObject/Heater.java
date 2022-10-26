package Model.SmartObject;
import java.util.Objects;
import java.util.Scanner;
import Enum.*;

public class Heater extends SmartObject {

    protected double temperature;

    public Heater(int idSmartObject, boolean isActive, Rooms position, String objectDescription, double temperature) {
        super(idSmartObject, isActive, position, objectDescription);
        this.temperature = temperature;
    }
    public void setTemperature(double temp){
        temperature = temp;
    }
    @Override
    public void StartWorking(){
        Scanner input = new Scanner(System.in);
        isActive = true;
        System.out.println("Введите температуру для нагрева помещения:");
        double temp = input.nextDouble();
        setTemperature(temp);
    }
    @Override
    public void EndWorking(){
        isActive = false;
    }

    @Override
    public void Switch(){
        isActive = !isActive;
    }

    // добавить все геттеры
    @Override
    public String GetStatus(){
        if (isActive) {
            return ("Сейчас включен");
        }
        else {
            return ("Сейчас выключен");
        }
    }
    @Override
    public boolean GetIsActive(){
        return isActive;
    }

    @Override
    public int GetID(){ //provides the object’s identifier
        return idSmartObject;
    }
    @Override
    public String GetPosition(){ //returns its location
        return String.valueOf(position);
    }

    @Override
    public String GetObjectDescription(){
        return objectDescription;
    }
    public double GetTemperature(){
        return temperature;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Температура: " + temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Heater that = (Heater) o;
        return temperature == that.temperature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), temperature);
    }

}
