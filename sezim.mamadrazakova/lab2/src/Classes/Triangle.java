package Classes;


import java.util.Objects;

public class Triangle extends PlaneFigure {
    private String type;

    public Triangle(String name, double perimeter, String type) {
        super(name, perimeter);
        this.type = type;
    }

    public String getType() {
        return type;
    }


    @Override
    public int countOfAngles() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Вид: " + type;
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
        Triangle triangle = (Triangle) o;
        return Objects.equals(type, triangle.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
