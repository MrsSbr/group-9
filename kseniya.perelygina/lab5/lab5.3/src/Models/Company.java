package Models;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Supportive.*;

public class Company {

    public static int AMOUNT_OF_EMPLOYEES = 300;

    private final List<Premium> premiums;
    private final List<Employee> employees;

    // По условию задачи всегда должно быть 50,
    // но провести тест при таком малом кол-ве записей и сделать верный вывод затруднительно
    private int yearsSinceFoundation;


    public Company(boolean makeArrayList, int yearsSinceFoundation){

        this.yearsSinceFoundation = yearsSinceFoundation;

        if (makeArrayList) {

            premiums = new ArrayList<>();
            employees = new ArrayList<>();

        } else {

            premiums = new LinkedList<>();
            employees = new LinkedList<>();

        }

        generateEmployees();
        generatePremiums();

    }


    public void generateEmployees() {

        IntStream.range(0, AMOUNT_OF_EMPLOYEES)
                .mapToObj(i -> new Employee())
                .forEach(employees::add);

    }


    public void generatePremiums() {

        IntStream.range(0, yearsSinceFoundation)
                .mapToObj(i -> new Premium(Supportive.CURRENT_YEAR - i,
                employees.get((int) (Math.random() * AMOUNT_OF_EMPLOYEES))))
                .forEach(premiums::add);
    }


    public Set<String> getMostRewardedDepartments() {

        int maxRewards = -1;
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < Supportive.DEPARTMENTS.length; i++) {

            String curDep = Supportive.DEPARTMENTS[i];
            int cnt = (int) premiums.stream()
                    .filter(p -> p.getDepartment() == curDep)
                    .count();

            if (cnt > maxRewards) {

                maxRewards = cnt;
                result.clear();
                result.add(curDep);

            } else if (cnt == maxRewards) {

                result.add(curDep);

            }
        }

        return result;

    }


    public Set<Employee> getRewardedEmployees() {

        HashSet<Employee> result = premiums.stream()
                .map(Premium::getEmployee)
                .collect(Collectors.toCollection(HashSet::new));

        return result;
    }


    public int countOnceRewardedEmployees() {

        int resultCnt = (int) premiums.stream()
                .map(Premium::getEmployee)
                .mapToInt(curEmp -> (int) premiums
                        .stream()
                        .filter(p -> curEmp.equals(p.getEmployee()))
                        .count())
                .filter(cnt -> cnt == 1).count();

        return resultCnt;

    }

}
