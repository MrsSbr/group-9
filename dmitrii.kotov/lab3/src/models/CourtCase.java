package models;

import java.time.LocalDate;

public class CourtCase {

    private String defendantName;
    private String plaintiffName;
    private LocalDate date;
    private String article;
    private boolean isConvicted;

    public CourtCase(String defendantName, String plaintiffName, LocalDate date, String article, boolean isConvicted) {
        this.defendantName = defendantName;
        this.plaintiffName = plaintiffName;
        this.date = date;
        this.article = article;
        this.isConvicted = isConvicted;
    }

    public boolean getConvicted() {
        return isConvicted;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArticle() {
        return article;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public String getPlaintiffName() {
        return plaintiffName;
    }

    @Override
    public String toString() {
        return "Судебное дело:\nИмя ответчика: " + defendantName + "| Имя истца: " + plaintiffName + "| Дата: " + date
                + "| Статья: " + article + "| Приговор : " + isConvicted;
    }
}
