package studentClass;

import checkValidatons.Months;

import java.util.*;

public class StudentArrayList {

    private static final int SIZE = 1200;

    private final List<Student> students;

    public StudentArrayList() {

        this.students = new ArrayList<>();

    }

    public void fillRandom() {

        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {

            students.add(Student.createRandomStudent());

        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

    public void fillFromConsole() {

        for (int i = 0; i < SIZE; i++) {

            students.add(Student.readStudentFromConsole());

        }

    }

    public void Clear() {

        this.students.clear();

    }

    public void findCount() {

        long start = System.nanoTime();

        for (int i = 0; i < Months.values().length; i++) {

            int countMale = 0;
            int countFemale = 0;

            System.out.println(Months.getMonth(i) + ": ");

            for (Student student : students) {

                if ((Months.getMonth(i).toStr().equals(student.getMonth())) && student.isSex()) {

                    countMale++;

                } else if ((Months.getMonth(i).toStr().equals(student.getMonth())) && !student.isSex()) {

                    countFemale++;

                }

            }

            System.out.println("Male: " + countMale + "\n" + "Female: " + countFemale);

        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

    public void findBiggerFemalesThanMales() {

        long start = System.nanoTime();

        System.out.println("Months where female students bigger then male students: ");

        for (int i = 0; i < Months.values().length; i++) {

            int countMale = 0;
            int countFemale = 0;


            for (Student student : students) {

                if ((Months.getMonth(i).toStr().equals(student.getMonth())) && student.isSex()) {

                    countMale++;

                } else if ((Months.getMonth(i).toStr().equals(student.getMonth())) && !student.isSex()) {

                    countFemale++;

                }

            }

            if (countFemale > countMale) {

                System.out.println(Months.getMonth(i));

            }

        }

        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Time ms: " + elapsed);

    }

}



