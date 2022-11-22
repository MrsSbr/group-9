package Models;

public class Premium {

    private Employee employee;
    private int year;

    @Override
    public String toString() {
        return employee.toString() +
                "Премия плолучена: " + year + "г.\n";
    }


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

}
