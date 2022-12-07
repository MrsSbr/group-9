package ru.vsu.logic.implementations;

import ru.vsu.entity.ExamResult;
import ru.vsu.entity.Student;
import ru.vsu.logic.interfaces.StudentService;

import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImplementation implements StudentService {
    @Override
    public List<String> getAdultStudentsLastNameSorted(Collection<Student> students) {
        return students.stream().filter(x -> x.getAge() >= 18).map(Student::getLastName).sorted().collect(Collectors.toList());
    }

    @Override
    public Set<Student> getExcellentStudents(Collection<Student> students) {
        return students.stream().filter(x -> x.getExamResults().stream().mapToDouble(ExamResult::getMark).average().orElse(0) == 5).collect(Collectors.toSet());
    }

    @Override
    public Double getAverageMark(Collection<Student> students) {
        return students.stream().map(Student::getExamResults).flatMap(Collection::stream).mapToInt(ExamResult::getMark).average().orElse(0);
    }

    @Override
    public Student findYoungestStudent(Collection<Student> students) {
        return students.stream().min(Comparator.comparing(Student::getAge)).orElseThrow(NoSuchElementException::new);
    }
}
