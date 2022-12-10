package models;

import java.time.LocalDate;
import java.util.Objects;

public class Fight {
    private final LocalDate date;
    private final String gladiatorName;
    private final String ludus;
    private final String enemyAnimal;
    private final int result; // 0 - победа, 1 - проигрыш и помилование, 2 - проигрыш без помилования

    public Fight(String date, String gladiatorName, String ludus, String enemyAnimal, String result) {
        this.date = LocalDate.parse(date);
        this.gladiatorName = gladiatorName;
        this.ludus = ludus;
        this.enemyAnimal = enemyAnimal;
        this.result = Integer.parseInt(result);
    }

    public LocalDate getDate() {
        return date;
    }
    public String getGladiatorName() {
        return gladiatorName;
    }
    public String getLudus() {
        return ludus;
    }
    public String getEnemyAnimal() {
        return enemyAnimal;
    }
    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Дата проведения: "
                + date + "\nИмя гладиатора: "
                + gladiatorName + "\n Лудус: "
                + ludus + "\n Животное: "
                + enemyAnimal + "\nРезультат: "
                + result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fight fight = (Fight) o;
        return date.equals(fight.date)
                && Objects.equals(gladiatorName, fight.gladiatorName)
                && Objects.equals(ludus, fight.ludus)
                && Objects.equals(enemyAnimal, fight.enemyAnimal)
                && result == fight.result;
    }
    @Override
    public int hashCode() {
        return Objects.hash(date, gladiatorName, ludus, enemyAnimal, result);
    }
}
