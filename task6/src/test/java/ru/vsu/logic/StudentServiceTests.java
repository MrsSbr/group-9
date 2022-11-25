package ru.vsu.logic;

import org.junit.jupiter.api.Test;
import ru.vsu.entity.Student;
import ru.vsu.utils.TestReflectionUtils;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vsu.data.TestData.*;

public class StudentServiceTests {

    private final StudentService studentService = TestReflectionUtils.findImplementationOf(StudentService.class);

    @Test
    public void getAdultStudentsLastNameSorted() {
        // given
        List<String> expectedLastNames = List.of("Belyaev", "Demchenko", "Polyhina", "Portnoy");

        // when
        List<String> actualExcellentStudents = studentService.getAdultStudentsLastNameSorted(ALL_STUDENTS);

        // then
        assertEquals(expectedLastNames, actualExcellentStudents);
    }


    @Test
    public void getExcellentStudentReturnsOnlyExcellentStudents() {
        // given
        Set<Student> expectedExcellentStudents = Set.of(STUDENT_MARIA, STUDENT_VLADIMIR);

        // when
        Set<Student> actualExcellentStudents = studentService.getExcellentStudents(ALL_STUDENTS);

        // then
        assertEquals(expectedExcellentStudents, actualExcellentStudents);
    }

    @Test
    public void getAverageMarkReturnsAverageMark() {
        // given
        double expectedAverageMark = 4.5;

        // when
        double actualAverageMark = studentService.getAverageMark(ALL_STUDENTS);

        // then
        assertEquals(expectedAverageMark, actualAverageMark, 0.1);
    }

    @Test
    public void findYoungestStudentReturnsYoungestStudent() {
        // given
        Student expectedStudent = STUDENT_ANTON;

        // when
        Student actualStudent = studentService.findYoungestStudent(ALL_STUDENTS);

        // then
        assertEquals(expectedStudent, actualStudent);
    }

}
