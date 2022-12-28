package studentClass;

import classHelper.Months;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class StudentList {

    private static final int SIZE = 1200;

    private final List<Student> students;

    public StudentList() {

        this.students = new ArrayList<>();

    }

    public StudentList(boolean isArray) {

        if (isArray) {
            this.students = new ArrayList<>();
        } else {
            this.students = new LinkedList<>();
        }


    }

    public void fillRandom() {

        long start = System.nanoTime();

        IntStream.range(0, SIZE)
                .mapToObj(i -> Student.createRandomStudent())
                .forEach(students::add);

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

    public void fillFromConsole() {

        IntStream.range(0, SIZE)
                .mapToObj(i -> Student.readStudentFromConsole())
                .forEach(students::add);

    }

    public void clear() {

        this.students.clear();

    }

    public int countMale(Months month) {

        return (int) students.stream().
                filter(student -> (month.toStr().equals(student.getMonth())) && !student.isSex())
                .count();

    }
    public int countFemale(Months month) {

        return (int) students.stream().
                filter(student -> (month.toStr().equals(student.getMonth())) && student.isSex())
                .count();

    }

    public void findCount() {

        long start = System.nanoTime();
        Arrays.stream(Months.values()).forEach(month -> {

            System.out.println(month + ": ");
            System.out.println("Male: " + countMale(month) + "\n" + "Female: " + countFemale(month));

        });

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

    public void findBiggerFemalesThanMales() {

        long start = System.nanoTime();

        System.out.println("Months where female students bigger then male students: ");

        Arrays.stream(Months.values())
                .filter(month -> countFemale(month) > countMale(month))
                .forEach(System.out::println);

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

}


