package models;

import interfaces.University;

import java.util.Objects;

public class Teacher extends Group implements University {
    private int count;

    public Teacher(String name, String direction, int count) {
        super(name, direction);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String getTypeOfGroup() {
        return "Преподаватели";
    }

    @Override
    public String toString() {
        return super.toString() +
                "' Количество преподавателей на кафедре =" + count;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        if( (count == teacher.count) && (teacher.direction.equals(direction))  &&
                name.equals(teacher.name)) return true;

        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), count);
    }
}
