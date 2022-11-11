package Models;

import Enum.BreedType;

import java.util.Objects;

public class BreedStatistic {
    private final BreedType breed;
    private final double statistic;

    public BreedStatistic(BreedType breed, double statistic) {
        this.breed = breed;
        this.statistic = statistic;
    }

    public BreedType getBreed() {
        return breed;
    }

    public double getStatistic() {
        return statistic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BreedStatistic that)) {
            return false;
        }

        return Double.compare(that.statistic, statistic) == 0 && breed == that.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, statistic);
    }

    @Override
    public String toString() {
        return "BreedStatistic {" +
                "breed=" + breed +
                ", statistic=" + statistic +
                '}';
    }
}
