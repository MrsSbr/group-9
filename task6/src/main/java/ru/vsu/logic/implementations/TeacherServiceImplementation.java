package ru.vsu.logic.implementations;

import ru.vsu.entity.Student;
import ru.vsu.entity.Subject;
import ru.vsu.entity.Teacher;
import ru.vsu.logic.interfaces.TeacherService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeacherServiceImplementation implements TeacherService {
    @Override
    public List<String> getSingleSubjectLecturerFio(Collection<Teacher> teachers) {
        return teachers.stream().filter(x -> x.getSubjects().size() == 1).map(Teacher::getFullName).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Student>> getTeacherNameToSupervisedStudentsMap(Collection<Student> students) {
        return students.stream().collect(Collectors.groupingBy(x -> { // как пропустить null значения?
            if(x.getSupervisor() != null)
                return x.getSupervisor().getFullName();
            return "None";
        })).entrySet().stream().filter(x -> !Objects.equals(x.getKey(), "None")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public BigDecimal getTeachersSalarySum(Collection<Teacher> teachers) {
        return teachers.stream().map(Teacher::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String findTeacherBySubject(Collection<Teacher> teachers, Subject subject) {
        return teachers.stream().filter(x -> x.getSubjects().contains(subject)).map(Teacher::getFullName).findFirst().orElse(null);
    }
}
