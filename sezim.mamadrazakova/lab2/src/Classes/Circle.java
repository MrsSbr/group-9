package Classes;
import Classes.PlaneFigure;
import Interfaces.GeometricFigures;
import java.util.Objects;
public class Circle extends PlaneFigure implements GeometricFigures{
    double radius;
    public Circle(String name, double perimeter,double radius){
        super(name, perimeter);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int countOfAngles() {
        return 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
