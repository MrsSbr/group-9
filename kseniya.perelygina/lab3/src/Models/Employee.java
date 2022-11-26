package Models;

import Supportive.*;

import java.util.Objects;

public class Employee {

    private String name;
    private String department;

    public Employee() {

        name = generateName();
        department = generateDepartment();

    }

    public String getDepartment() {

        return department;

    }

    private String generateName() {
        StringBuffer tmp = new StringBuffer();
        tmp.append(Supportive.NAMES[(int)(Math.random() * (Supportive.NAMES.length))]);
        tmp.append(' ');
        tmp.append(Supportive.SURNAMES[(int)(Math.random() * (Supportive.SURNAMES.length))]);
        return tmp.toString();
    }

    private String generateDepartment() {

        return Supportive.DEPARTMENTS[(int)(Math.random() * (Supportive.DEPARTMENTS.length))];

    }

    @Override
    public int hashCode() {
        return Objects.hash(department, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass() ) {
            return false;
        }

        Employee emp = (Employee) obj;

        return (name == emp.name && department == emp.department);
    }

    @Override
    public String toString() {
        return "Работник: " +
                name + ", " +
                department ;
    }


}
