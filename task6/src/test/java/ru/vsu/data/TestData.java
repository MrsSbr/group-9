package ru.vsu.data;

import ru.vsu.entity.ExamResult;
import ru.vsu.entity.Student;
import ru.vsu.entity.Teacher;
import ru.vsu.entity.Subject;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static java.util.Set.of;

public class TestData {

    public static final LocalDate MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME = LocalDate.parse("2021-12-03T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate PROGRAMMING_EXAM_DATE_TIME = LocalDate.parse("2021-12-04T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate LINEAR_ALGEBRA_EXAM_DATE_TIME = LocalDate.parse("2021-12-05T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate HISTORY_EXAM_DATE_TIME = LocalDate.parse("2021-12-06T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME = LocalDate.parse("2021-12-07T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);


    public static final Teacher MAXIM_TEACHER = new Teacher("Maxim Shestakov", of(Subject.MATHEMATICAL_ANALYSIS, Subject.PROGRAMMING), BigDecimal.valueOf(200.50));
    public static final Teacher ANDREY_TEACHER = new Teacher("Andrey Astahov", of(Subject.MATHEMATICAL_ANALYSIS, Subject.LINEAR_ALGEBRA, Subject.FUNCTIONAL_ANALYSIS),  BigDecimal.valueOf(300.00));
    public static final Teacher IRINA_TEACHER = new Teacher("Irina Pereverzeva", Set.of(Subject.HISTORY),  BigDecimal.valueOf(100.00));

    public static final Student STUDENT_MIKE = new Student("Mike", "Portnoy", 18, 1, 3, null, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS, MAXIM_TEACHER),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 4, Subject.PROGRAMMING, MAXIM_TEACHER),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.PROGRAMMING, IRINA_TEACHER)
    ));

    public static final Student STUDENT_ANN = new Student("Anna", "Polyhina", 19, 1, 3, ANDREY_TEACHER, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 3, Subject.MATHEMATICAL_ANALYSIS, MAXIM_TEACHER),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 3, Subject.PROGRAMMING, MAXIM_TEACHER),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 4, Subject.PROGRAMMING, IRINA_TEACHER)
    ));

    public static final Student STUDENT_VLADIMIR = new Student("Vladimir", "Belyaev", 23, 4, 91, MAXIM_TEACHER, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS, MAXIM_TEACHER),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 5, Subject.PROGRAMMING, MAXIM_TEACHER),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.HISTORY, IRINA_TEACHER),
            new ExamResult(LINEAR_ALGEBRA_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA, ANDREY_TEACHER),
            new ExamResult(FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA, ANDREY_TEACHER)
    ));

    public static final Student STUDENT_MARIA = new Student("Maria", "Demchenko", 22, 4, 91, ANDREY_TEACHER, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS, ANDREY_TEACHER),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 5, Subject.PROGRAMMING, MAXIM_TEACHER),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.HISTORY, IRINA_TEACHER),
            new ExamResult(LINEAR_ALGEBRA_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA, ANDREY_TEACHER),
            new ExamResult(FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA, ANDREY_TEACHER)
    ));

    public static final Student STUDENT_ANTON = new Student("Anton", "Obanin", 17, 1, 4, null, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 3, Subject.MATHEMATICAL_ANALYSIS, ANDREY_TEACHER)
    ));

    public static final Set<Student> ALL_STUDENTS = Set.of(STUDENT_MIKE, STUDENT_ANN, STUDENT_VLADIMIR, STUDENT_MARIA, STUDENT_ANTON);

    public static final Set<Teacher> ALL_TEACHERS = Set.of(ANDREY_TEACHER, MAXIM_TEACHER, IRINA_TEACHER);

}

