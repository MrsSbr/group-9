package ru.vsu.logic;

import org.junit.jupiter.api.Test;
import ru.vsu.entity.Student;
import ru.vsu.entity.Subject;
import ru.vsu.utils.TestReflectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.vsu.data.TestData.*;

public class TeacherServiceTests {

    private final TeacherService teacherService = TestReflectionUtils.findImplementationOf(TeacherService.class);

    @Test
    public void getSingleSubjectLecturerFio() {
        // given
        List<String> expectedTeachers = List.of(IRINA_TEACHER.getFullName());

        // when
        List<String> actualTeachers = teacherService.getSingleSubjectLecturerFio(ALL_TEACHERS);

        // then
        assertEquals(expectedTeachers, actualTeachers);
    }

    @Test
    public void getSupervisorNameToStudentsMap() {
        // given
        Map<String, List<Student>> expectedTeachersToStudentsMap =
                Map.of(
                        MAXIM_TEACHER.getFullName(), List.of(STUDENT_VLADIMIR),
                        ANDREY_TEACHER.getFullName(), List.of(STUDENT_MARIA, STUDENT_ANN)
                );

        // when
        Map<String, List<Student>> actualTeachersToStudentsMap = teacherService.getTeacherNameToSupervisedStudentsMap(ALL_STUDENTS);

        // then
        assertEquals(expectedTeachersToStudentsMap.get(MAXIM_TEACHER.getFullName()), actualTeachersToStudentsMap.get(MAXIM_TEACHER.getFullName()));
        assertEquals(expectedTeachersToStudentsMap.get(ANDREY_TEACHER.getFullName()), actualTeachersToStudentsMap.get(ANDREY_TEACHER.getFullName()));
    }

    @Test
    public void getTeachersSalarySumReturnsCorrectSum() {
        // given
        BigDecimal expectedSalary = BigDecimal.valueOf(600.5);

        // when
        BigDecimal actualSalary = teacherService.getTeachersSalarySum(ALL_TEACHERS);

        // then
        assertEquals(expectedSalary, actualSalary);
    }

    @Test
    public void findMathematicalAnalysisTeacherNames() {
        // given
        Subject subject = Subject.MATHEMATICAL_ANALYSIS;
        // when
        String name = teacherService.findTeacherBySubject(ALL_TEACHERS, subject);

        // then
        assertTrue(MAXIM_TEACHER.getFullName().equals(name) || ANDREY_TEACHER.getFullName().equals(name));
    }

    @Test
    public void findTeacherReturnsNullIfNoTeacherBySubjectPresent() {
        // given
        Subject subject = Subject.HISTORY;
        // when
        String name = teacherService.findTeacherBySubject(List.of(ANDREY_TEACHER, MAXIM_TEACHER), subject);
        // then
        assertNull(name);
    }
}
