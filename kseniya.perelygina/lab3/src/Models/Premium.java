package Models;

import java.util.Objects;

public class Premium {

    private Employee employee;
    private int year;

    public Employee getEmployee() {
        return employee;
    }

    public String getDepartment() {
        return employee.getDepartment();
    }
    public Premium(int year, Employee employee) {
        this.year = year;
        this.employee = employee;
    }
    @Override
    public String toString() {
        return employee.toString() +
                "Премия плолучена: " + year + "г.\n";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Premium prem = (Premium) obj;

        return (employee.equals(prem.employee) && year == prem.year);

    }

    @Override
    public int hashCode() {

        return Objects.hash(employee.hashCode(), year);

    }
}
