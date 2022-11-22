package Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Supportive.*;

public class Company {

    public static int amountOfEmployees = 300;

    private final List<Premium> premiums;
    private final List<Employee> employees;

    // По условию задачи всегда должно быть 50,
    // но провести тест при таком малом кол-ве записей и сделать верный вывод затруднительно
    private int yearsSinceFoundation;
    private boolean isArray;


    public Company(boolean makeArrayList, int yearsSinceFoundation){

        isArray = makeArrayList;
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

        for (int i = 0; i < amountOfEmployees; i++) {

            Employee newbie = new Employee();
            employees.add(newbie);

        }

    }


    public void generatePremiums() {

        for (int i = 0; i < yearsSinceFoundation; i++) {

            Premium p = new Premium(Supportive.currentYear - i,
                    employees.get((int)(Math.random() * amountOfEmployees)));
            premiums.add(p);

        }
    }


    public List<String> getMostRewardedDepartments() {

        int maxRewards = -1;
        List<String> result;

        if (isArray) {

            result = new ArrayList<>();

        } else {

            result = new LinkedList<>();
        }

        for (int i = 0; i < Supportive.departments.length; i++) {

            int cnt = 0;
            String curDep = Supportive.departments[i];

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


    public List<Employee> getRewardedEmployees() {

        List<Employee> result;

        if (isArray) {

            result = new ArrayList<>();

        } else {

            result = new LinkedList<>();
        }

        for (Premium p: premiums) {

            Employee curEmp = p.getEmployee();

            if (!result.contains(curEmp)) {

                result.add(curEmp);

            }
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
