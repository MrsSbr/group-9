package Classes;

import Interfaces.GeometricFigures;

import java.util.Objects;

public abstract class PlaneFigure implements GeometricFigures {
    protected double perimeter;
    protected String name;


    public PlaneFigure(String name, double perimeter) {
        this.perimeter = perimeter;
        this.name = name;
    }


    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int countOfAngles();

    @Override
    public String toString() {
        return "PlaneFigure{" +
                "perimeter=" + perimeter +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlaneFigure that = (PlaneFigure) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perimeter, name);
    }

}
