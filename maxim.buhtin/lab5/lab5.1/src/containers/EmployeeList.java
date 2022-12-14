package containers;

import models.Employee;
import models.MarkAuto;

import java.util.*;
import java.util.stream.IntStream;

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
        return IntStream.range(0, MarkAuto.values().length)
                .boxed().max(Comparator.comparing(MarkAuto::getMark)).orElse(-1);
    }


    public void fillRandom() {
        IntStream.range(0, SIZE)
                .mapToObj(i -> Employee.createRandomEmployee())
                .forEach(employees::add);
    }

    public void fillFromConsole() {
        IntStream.range(0, SIZE)
                .mapToObj(i -> Employee.readEmployeeFromConsole())
                .forEach(employees::add);
    }

    public void сlear() {

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
        employees
                .stream()
                .filter(employee -> employee.getAge() > minAge && employee.getAge() < maxAge)
                .forEach(employee -> {
                    Arrays.stream(MarkAuto.values())
                            .filter(markAuto -> markAuto.toString().equals(employee.getMark()))
                            .findFirst()
                            .ifPresent(MarkAuto::incrementCount);
                });
    }

    public void getListUniqueMark() {
        HashSet<MarkAuto> markAutos = new HashSet<>();
        employees.forEach(employee -> {
                    Arrays.stream(MarkAuto.values())
                            .filter(markAuto -> markAuto.toString().equals(employee.getMark()))
                            .findFirst()
                            .ifPresent(markAutos::add);
                });
        System.out.println(markAutos);
    }
}
