package containers;

import classEmployee.Employee;
import markAuto.MarkAuto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayList {
    private static final int SIZE = 1500;

    private final List<Employee> employees;

    public EmployeeArrayList() {

        this.employees = new ArrayList<>();

    }

    public void fillRandom() {

        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {

            employees.add(Employee.createRandomEmployee());

        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms generate  array list: " + elapsed);

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

        long start = System.nanoTime();
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (MarkAuto.getMark(i).toStr() == employee.getMark()) {
                    MarkAuto.getMark(i).count++;
                }
            }
        }
        int max = MarkAuto.getMark(0).count;
        int indexMax = 0;
        for (int i = 1; i < MarkAuto.values().length; i++) {
            if (max < MarkAuto.getMark(i).count) {
                max = MarkAuto.getMark(i).count;
                indexMax = i;
            }
        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms the most popular mark: " + elapsed);
        System.out.println("Is the most popular mark: " + MarkAuto.getMark(indexMax));
    }

    public void findPopularMarkWithAge(int minAge, int maxAge) {

        long start = System.nanoTime();
        MarkAuto markAuto = MarkAuto.Audi;
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (employee.getAge() > minAge && employee.getAge() > maxAge) {
                    if (markAuto.getMark(i).toStr() == employee.getMark()) {
                        markAuto.getMark(i).count++;
                    }
                }
            }
        }
        int max = markAuto.getMark(0).count;
        int indexMax = 0;
        for (int i = 1; i < markAuto.values().length; i++) {
            if (max < markAuto.getMark(i).count) {
                max = markAuto.getMark(i).count;
                indexMax = i;
            }
        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time the most popular mark with age: " + elapsed);
        System.out.println("Is the most popular mark with age: " + markAuto.getMark(indexMax));
    }

    public void getListUniqueMark() {
        long start = System.nanoTime();
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (MarkAuto.getMark(i).toStr() == employee.getMark()) {
                    MarkAuto.getMark(i).count++;
                }
            }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time Unique mark: " + elapsed);
        for (int i = 0; i < MarkAuto.values().length; i++) {
            if (MarkAuto.getMark(i).count == 1) {
                System.out.println("Unique mark: " + MarkAuto.getMark(i));
            }
        }
    }

}
