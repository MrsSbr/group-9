package ru.vsu.entity;


import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Teacher {

    private final String fullName;
    private final Set<Subject> subjects;
    private final BigDecimal salary;


    public Teacher(String fullName, Set<Subject> subjects, BigDecimal salary) {
        this.fullName = fullName;
        this.subjects = subjects;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Teacher teacher = (Teacher) o;
        return Objects.equals(fullName, teacher.fullName)
                && Objects.equals(subjects, teacher.subjects)
                && Objects.equals(salary, teacher.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, subjects, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", subjects=" + subjects +
                ", salary=" + salary +
                '}';
    }
}
