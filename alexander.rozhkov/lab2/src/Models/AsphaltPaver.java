package Models;

import java.util.Objects;

public class AsphaltPaver extends ConstructionVehicle {
    int layingWidth;

    public AsphaltPaver(String model, int motorPower, int layingWidth) {
        super(model, motorPower);
        this.layingWidth = layingWidth;
    }

    public int getLayingWidth() {
        return layingWidth;
    }

    public void someAction(){
        System.out.println("Асфальтоукладчик работает...");
    }

    @Override
    public String toString() {
        return super.toString() + "\nШирина укладки асфальта - " + layingWidth + "м";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof AsphaltPaver that)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }
        return layingWidth == that.layingWidth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), layingWidth);
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getMotorPower() {
        return motorPower;
    }
}