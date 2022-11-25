package ru.vsu.logic;

import ru.vsu.entity.Student;
import ru.vsu.entity.Subject;
import ru.vsu.entity.Teacher;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TeacherService {

    /**
     * Возвращает имя и фамилию преподавателей, преподающих только один предмет
     */
    List<String> getSingleSubjectLecturerFio(Collection<Teacher> teachers);

    /**
     * Возвращает мапу, где ключ - имя преподавателя, а значение - студенты, для которых он является наставником
     */
    Map<String, List<Student>> getTeacherNameToSupervisedStudentsMap(Collection<Student> students);

    /**
     * Возвращает сумму зарплат всех преподавателей
     */
    BigDecimal getTeachersSalarySum(Collection<Teacher> teachers);

    /**
     * Возвращает имя и фамилию преподавателя, который может вести заданный предмет
     */
    String findTeacherBySubject(Collection<Teacher> teachers, Subject subject);
}
