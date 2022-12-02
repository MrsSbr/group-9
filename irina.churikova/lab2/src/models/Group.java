package models;
import interfaces.IUniversity;
import java.util.Objects;

public abstract class Group implements IUniversity {
    protected String direction;
    protected String name;


    public Group(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public abstract String getTypeOfGroup();

    @Override
    public String toString() {
        return "Группа: " +
                "Направление = " + direction +
                ", название ='" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return (group.direction.equals(direction)) &&
                name.equals(group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, name);
    }
}
