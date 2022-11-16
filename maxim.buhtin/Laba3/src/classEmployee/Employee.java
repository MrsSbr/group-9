package classEmployee;

import markAuto.MarkAuto;
import validationData.checkInputData;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private int age;
    private String mark;

    public Employee(MarkAuto markAuto) {
        this.age = checkInputData.checkAgeValues(18, 65);
        this.mark = markAuto.toStr();
    }

    public Employee() {

    }

    public static Employee readEmployeeFromConsole() {
        Employee employee = new Employee();
        employee.age = checkInputData.checkAgeValues(18, 65);
        employee.mark = checkInputData.checkMarkValues();
        return employee;
    }

    public static Employee createRandomEmployee() {
        Employee employee = new Employee();
        Random random = new Random();
        MarkAuto value = MarkAuto.getMark(random.nextInt(5));
        employee.age = random.nextInt();
        employee.mark = value.toStr();
        return employee;
    }

    public int getAge() {
        return age;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Employee employee = (Employee) o;
        return age == employee.age && mark.equals(employee.mark);

    }

    @Override
    public int hashCode() {

        return Objects.hash(age, mark);

    }
}
