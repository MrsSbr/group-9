package campaign;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static settings.Random.*;

public class MarketCampaigns {
    private LocalDate start;
    private LocalDate finish;
    private TypeCampaign type;
    private long coverage;
    private BigDecimal budget;

    MarketCampaigns() {
    }

    MarketCampaigns(String start, String finish, TypeCampaign type, long coverage, String budget) {
        this.start = LocalDate.parse(start);
        this.finish = LocalDate.parse(finish);
        this.type = type;
        this.coverage = coverage;
        this.budget = new BigDecimal(budget);
    }

    void setRandom() {
        this.start = createRandomDate(MIN_YEAR, MAX_YEAR);
        this.finish = start.plusDays(createRandomDuration());
        this.type = TypeCampaign.randomTypeCampaign();
        this.coverage = createRandomIntBetween(1, MAX_COVERAGE);
        this.budget = random();
    }

    int getDurationDays() {
        return (int) ChronoUnit.DAYS.between(start, finish);
    }

    BigDecimal getCorrelation() {
        return budget.divide(BigDecimal.valueOf(coverage), RoundingMode.HALF_UP);
    }

    public LocalDate getFinish() {
        return finish;
    }

    public LocalDate getStart() {
        return start;
    }

    public TypeCampaign getType() {
        return type;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Маркетинговая кампания { " +
                "Дата начала = " + start +
                ", Дата окончания = " + finish +
                ", Тип = " + type +
                ", Охват = " + coverage +
                ", Бюджет = " + budget +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketCampaigns that = (MarketCampaigns) o;
        if (type != that.type) return false;
        if (!Objects.equals(start, that.start)) return false;
        if (!Objects.equals(finish, that.finish)) return false;
        if (coverage != that.coverage) return false;
        return Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) (coverage ^ (coverage >>> 32));
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        return result;
    }
}
