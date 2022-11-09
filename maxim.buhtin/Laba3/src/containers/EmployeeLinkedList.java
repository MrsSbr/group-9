package containers;

import classEmployee.Employee;
import markAuto.MarkAuto;

import java.util.LinkedList;
import java.util.List;

public class EmployeeLinkedList {
    private static final int SIZE = 1500;

    private final List<Employee> employees;

    public EmployeeLinkedList() {

        this.employees = new LinkedList<>();

    }

    public void fillRandom() {

        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {

            employees.add(Employee.createRandomEmployee());

        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time  generate linked list: " + elapsed);

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

        System.out.println("Time the most popular mark: " + elapsed);
        System.out.println("Is the most popular mark: " + MarkAuto.getMark(indexMax));
    }

    public void findPopularMarkWithAge(int minAge, int maxAge) {

        long start = System.nanoTime();
        for (int i = 0; i < MarkAuto.values().length; i++) {
            for (Employee employee : employees) {
                if (employee.getAge() > minAge && employee.getAge() > maxAge) {
                    if (MarkAuto.getMark(i).toStr() == employee.getMark()) {
                        MarkAuto.getMark(i).count++;
                    }
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

        System.out.println("Time ms find count: " + elapsed);
        System.out.println("Is the most popular mark with age: " + MarkAuto.getMark(indexMax));
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