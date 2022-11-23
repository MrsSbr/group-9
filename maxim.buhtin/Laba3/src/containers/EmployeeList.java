package containers;

import classEmployee.Employee;
import markAuto.MarkAuto;
//import validationData.checkInputData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class EmployeeList {
    private static final int SIZE = 1500;

    private List<Employee> employees;

    public EmployeeList(int choice) {
        if (choice == 1) {
            this.employees = new ArrayList<>();
        }
        if (choice == 2) {
            this.employees = new LinkedList<>();
        }
    }

    private static int getIndexMax() {
        int max = MarkAuto.getMark(0).getCount();
        int indexMax = 0;
        for (int i = 1; i < MarkAuto.values().length; i++) {
            if (max < MarkAuto.getMark(i).getCount()) {
                max = MarkAuto.getMark(i).getCount();
                indexMax = i;
            }
        }
        return indexMax;
    }

    public void fillRandom() {

        for (int i = 0; i < SIZE; i++) {

            employees.add(Employee.createRandomEmployee());

        }
    }

    public void fillFromConsole() {

        for (int i = 0; i < SIZE; i++) {

            employees.add(Employee.readEmployeeFromConsole());
        }

    }

    public void Clear() {

        this.employees.clear();

    }

    public void findPopularMark() {

        fillDataEmployee(0, 100);
        int indexMax = getIndexMax();
        System.out.println("Is the most popular mark: " + MarkAuto.getMark(indexMax));
    }

    public void findPopularMarkWithAge(int minAge, int maxAge) {
        fillDataEmployee(minAge, maxAge);
        int indexMax = getIndexMax();
        System.out.println("most popular brand aged " + minAge + " to " + maxAge + " " +
                MarkAuto.getMark(indexMax));
    }

    private void fillDataEmployee(int minAge, int maxAge) {
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (employee.getAge() > minAge && employee.getAge() > maxAge) {
                    if (MarkAuto.getMark(i).toStr().equals(employee.getMark())) {
                        MarkAuto.getMark(i).incrementCount();
                    }
                }
            }
        }
    }

    public void getListUniqueMark() {
        HashSet<MarkAuto> markAutos = new HashSet<>();
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (MarkAuto.getMark(i).toStr().equals(employee.getMark())) {
                    markAutos.add(MarkAuto.valueOf(employee.getMark()));
                }
            }
        }
        System.out.println(markAutos);

    }

}
