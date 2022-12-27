package entity;

import java.util.stream.Stream;

public enum Subject {
    MathAn("Математический анализ "),
    ALgebra("Алгебра "),
    Inform("Информатика "),
    ChislMethod("Численные методы "),
    DU("Дифференциальные уравнения "),
    TerVer("Теория вероятностей "),
    FunkAn("Функциональный анализ ");
    private final String str;


    Subject(String str) {
        this.str = str;
    }

    public static Stream<Subject> stream() {
        return Stream.of(Subject.values());
    }

    @Override
    public String toString() {
        return this.str;
    }
}
