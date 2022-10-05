package studentClass;

import checkValidatons.InputValidations;
import checkValidatons.Months;

import java.util.Objects;
import java.util.Random;

public class Student {

    private boolean sex;
    private String month;

    public Student(boolean sex, String month) {

        this.sex = sex;
        this.month = month;

    }

    public Student() {

    }

    public boolean isSex() {

        return sex;

    }

    public String getMonth() {

        return month;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || getClass() != o.getClass()) {

            return false;

        }

        Student student = (Student) o;
        return sex == student.sex && month.equals(student.month);

    }

    @Override
    public int hashCode() {

        return Objects.hash(sex, month);

    }

    public void inputStudentValuesFromConsole() {

        this.sex = InputValidations.checkSexValues();
        this.month = InputValidations.checkMonthValues();

    }

    public void inputStudentRandom() {

        Random random = new Random();
        Months value = Months.getMonth(random.nextInt(12));
        this.sex = random.nextBoolean();
        this.month = value.toStr();

    }

}
