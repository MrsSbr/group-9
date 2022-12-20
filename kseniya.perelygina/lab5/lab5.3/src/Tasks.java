import Models.Company;
import Models.Employee;
import Supportive.Supportive;

import java.util.Set;
import java.util.stream.IntStream;

public class Tasks {

    public static void performTasks(Company c, boolean display) {

        Set<String> deps = c.getMostRewardedDepartments();
        Set<Employee> emps = c.getRewardedEmployees();
        int cnt = c.countOnceRewardedEmployees();

        if (display) {

            System.out.println("\nОтделы, выигрывавшие чаще всего:");
            deps.stream().forEach(System.out::println);

            System.out.println("\nРаботники, выигрывавшие премию:");
            emps.stream().forEach(System.out::println);

            System.out.println("\nКол-во работников, которые становились лучшими только раз: " + cnt);

        }

    }


    public static void compareLists(int yearsPassed) {

        {
            long startTime = System.currentTimeMillis();
            Company c = new Company(true, yearsPassed);
            performTasks(c, false);
            System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime));

        }

        {
            long startTime = System.currentTimeMillis();
            Company c = new Company(false, yearsPassed);
            performTasks(c, false);
            System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime));

        }
    }

    public static void performComparisonTest() {

        for (int yearsPassed = Supportive.DEFAULT_YEARS_SINCE_FOUNDATION; yearsPassed <= 5050; yearsPassed += 1000) {

            System.out.println("\nВсего было премий: " + yearsPassed);
            compareLists(yearsPassed);

        }
    }
}
