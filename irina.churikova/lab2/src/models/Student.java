package models;

import interfaces.IGroupUniversity;

import java.util.Objects;

public class Student extends Group implements IGroupUniversity {
    private int Capacity;

    public Student(String name, String direction, int Capacity) {
        super(name, direction);
        this.Capacity = Capacity;
    }

    public int getCapacity() {
        return Capacity;
    }

    @Override
    public String getTypeOfGroup() {
        return "Студенты";
    }

    @Override
    public String toString() {
        return super.toString() +
                "' Количество студентов =" + Capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Capacity == student.Capacity && (student.direction.equals(direction)) &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Capacity);
    }
}
