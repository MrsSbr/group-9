package Models.SmartObject;

import Enum.Rooms;

import java.util.Objects;
import java.util.Scanner;

public class Lightning extends SmartObject {
    private String color;
    private int brightness;

    void setColor(String col) {
        color = col;
    }

    void setBrightness(int b) {
        brightness = b;
    }

    public Lightning(int idSmartObject, boolean isActive, Rooms position, String objectDescription, String color, int dim) {
        super(idSmartObject, isActive, position, objectDescription);
        this.color = color;
        this.brightness = dim;
    }

    @Override
    public void switchOn() {
        Scanner input = new Scanner(System.in);
        isActive = true;
        System.out.println("Введите цвет освещения:");
        String col = input.nextLine();
        setColor(col);
        System.out.println("Введите яркость освещения: от 1 до 10");
        int dim = input.nextInt();
        setBrightness(dim);
    }

    @Override
    public void switchOff() {
        isActive = false;
    }

    @Override
    public void switcher() {
        isActive = !isActive;
    }

    // добавить все геттеры
    @Override
    public String getStatus() {
        if (isActive) {
            return ("Сейчас включен");
        } else {
            return ("Сейчас выключен");
        }
    }

    @Override
    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public int getID() { //provides the object’s identifier
        return idSmartObject;
    }

    @Override
    public String getPosition() { //returns its location
        return String.valueOf(position);
    }

    @Override
    public String getObjectDescription() {
        return objectDescription;
    }

    public String getColor() {
        return color;
    }

    public int getDim() {
        return brightness;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Цвет подсветки: " + color +
                ", Яркость подсветки: " + brightness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Lightning that = (Lightning) o;
        return Objects.equals(color, that.color) && brightness == that.brightness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brightness, color);
    }
}
// переопределение методов включения и выключения с учетом получения яркости
