package models;

import interfaces.Insects;

import java.util.Objects;


public abstract class Ants implements Insects {

    protected int size;
    protected String color;
    protected String typeAnts;
    protected String habitat;

    public Ants(int size, String color, String type, String habitat) {
        this.size = size;
        this.color = color;
        this.typeAnts = type;
        this.habitat = habitat;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeAnts() {
        return typeAnts;
    }

    public void setTypeAnts(String typeAnts) {
        this.typeAnts = typeAnts;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void live() {
        System.out.println(" Мое место обитание: " + habitat);
    }

    @Override
    public void collectFood() {
    }

    @Override
    public String toString() {
        return " Размер: " + size +
                "; Цвет: " + color +
                "; Тип: " + typeAnts;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || getClass() != o.getClass()) return false;
        Ants ants = (Ants) o;
        return size == ants.size && color.equals(ants.color) && typeAnts.equals(ants.typeAnts) && habitat.equals(ants.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, typeAnts, habitat);
    }


}
