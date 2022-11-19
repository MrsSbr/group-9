package models;

// Суд цветочного города ведет статистику судебного делопроизводства, записывает имя ответчика, имя истца, дату, статью, итог(оправдан/осужден);

import enums.Result;

import java.time.LocalDate;
import java.util.Objects;

public class CourtCase {
    private final String respondent; // ответчик
    private final String plaintiff; // истец
    private final LocalDate date; // дата
    private final Integer article; // статья
    private final Result result; // итог


    public CourtCase(String respondent, String plaintiff, LocalDate date, Integer article, Result result) {
        this.respondent = respondent;
        this.plaintiff = plaintiff;
        this.date = date;
        this.article = article;
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public String getRespondent() {
        return respondent;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getArticle() {
        return article;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourtCase courtCase = (CourtCase) o;
        return respondent.equals(courtCase.respondent) && plaintiff.equals(courtCase.plaintiff) && date.equals(courtCase.date) && article.equals(courtCase.article) && result == courtCase.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondent, plaintiff, date, article, result);
    }

    @Override
    public String toString() {
        return "Ответчик: " + respondent + '\n' +
                "Истец: " + plaintiff + '\n' +
                "Дата: " + date + '\n' +
                "Статья: " + article + '\n' +
                "Итог: " + result;
    }
}
