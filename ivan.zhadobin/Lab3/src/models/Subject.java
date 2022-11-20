package models;

public enum Subject {
    MathAn("Математический анализ "),
    ALgebra("Алгебра "),
    Inform("Информатика "),
    ChislMethod("Численные методы "),
    DU("Дифференциальные уравнения "),
    TerVer("Теория вероятностей "),
    FunkAn("Функциональный анализ ");
    private String str;

    Subject(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
