package Models;

import java.util.*;

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

        for (int i = 0; i < AMOUNT_OF_EMPLOYEES; i++) {

            Employee newbie = new Employee();
            employees.add(newbie);

        }

    }


    public void generatePremiums() {

        for (int i = 0; i < yearsSinceFoundation; i++) {

            Premium p = new Premium(Supportive.CURRENT_YEAR - i,
                    employees.get((int)(Math.random() * AMOUNT_OF_EMPLOYEES)));
            premiums.add(p);

        }
    }


    public Set<String> getMostRewardedDepartments() {

        int maxRewards = -1;
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < Supportive.DEPARTMENTS.length; i++) {

            int cnt = 0;
            String curDep = Supportive.DEPARTMENTS[i];

            for (Premium p: premiums) {

                if (p.getDepartment() == curDep) {
                    cnt++;
                }

            }

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

        HashSet<Employee> result = new HashSet<>();

        for (Premium p: premiums) {

            Employee curEmp = p.getEmployee();

            result.add(curEmp);

        }

        return result;
    }


    public int countOnceRewardedEmployees() {

        int resultCnt = 0;

        for (Premium curP: premiums) {

            Employee curEmp = curP.getEmployee();
            int cnt = 0;

            for (Premium p: premiums) {

                if (curEmp.equals(p.getEmployee())) {

                    cnt++;

                }

            }

            if (cnt == 1) {

                resultCnt++;

            }

        }

        return resultCnt;

    }

}
