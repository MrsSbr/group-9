package Model.SmartObject;

import Interface.ElectronicDevice;

import java.util.Objects;

import Enum.*;

public abstract class SmartObject implements ElectronicDevice {
    protected int idSmartObject; // id прибора
    protected boolean isActive; // подключено к сети
    protected Rooms position; // в какой комнате находится
    protected String objectDescription; // описание устройства

    public SmartObject(int idSmartObject, boolean isActive, Rooms position, String objectDescription) {
        this.idSmartObject = idSmartObject;
        this.isActive = isActive;
        this.position = position;
        this.objectDescription = objectDescription;
    }

    @Override
    public void StartWorking() {
        isActive = true;
    }

    @Override
    public void EndWorking() {
        isActive = false;
    }

    public int GetID() { //provides the object’s identifier
        return idSmartObject;
    }

    public boolean GetIsActive() {
        return isActive;
    }

    @Override
    public String GetPosition() { //returns its location
        return String.valueOf(position);
    }

    @Override
    public String GetObjectDescription() {
        return objectDescription;
    }

    @Override
    public String toString() {
        return "SmartObject: " +
                "ID: " + idSmartObject +
                ", Местоположение: " + position +
                ", Статус: " + isActive +
                ", Описание устройства: " + objectDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartObject that = (SmartObject) o;
        return idSmartObject == that.idSmartObject && isActive == that.isActive &&
                Objects.equals(position, that.position) && Objects.equals(objectDescription, that.objectDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSmartObject, isActive, position, objectDescription);
    }
}
