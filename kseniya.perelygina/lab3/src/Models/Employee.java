package Models;

import Supportive.*;

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

    private String generateName() {
        StringBuffer tmp = new StringBuffer();
        tmp.append(Supportive.names[(int)(Math.random() * (Supportive.names.length))]);
        tmp.append(' ');
        tmp.append(Supportive.surnames[(int)(Math.random() * (Supportive.surnames.length))]);
        return tmp.toString();
    }

    private String generateDepartment() {
        return Supportive.departments[(int)(Math.random() * (Supportive.departments.length))];
    }
}
