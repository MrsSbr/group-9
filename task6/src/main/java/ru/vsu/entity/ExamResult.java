package ru.vsu.entity;

import java.time.LocalDate;
import java.util.Objects;

public class ExamResult {

    private final LocalDate examDate;
    private final int mark;
    private final Subject subject;
    private final Teacher teacher;

    public ExamResult(LocalDate examDate, Integer mark, Subject subject, Teacher teacher) {
        this.examDate = examDate;
        this.mark = mark;
        this.subject = subject;
        this.teacher = teacher;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public Integer getMark() {
        return mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamResult that = (ExamResult) o;
        return Objects.equals(examDate, that.examDate)
                && Objects.equals(mark, that.mark)
                && subject == that.subject
                && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examDate, mark, subject, teacher);
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "examDate=" + examDate +
                ", mark=" + mark +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
