package models;

import java.time.LocalDate;

public class CourtCase {

    private String defendantName; // ответчик
    private String plaintiffName; // истец
    private LocalDate date; // дата
    private String article; // статья
    private boolean isConvicted; // итог (true если осужден)

    public CourtCase(String defendantName, String plaintiffName, LocalDate date, String article, boolean isConvicted) {
        this.defendantName = defendantName;
        this.plaintiffName = plaintiffName;
        this.date = date;
        this.article = article;
        this.isConvicted = isConvicted;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public String getPlaintiffName() {
        return plaintiffName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArticle() {
        return article;
    }
    public boolean getConvicted() {
        return isConvicted;
    }


    @Override
    public String toString() {
        return "Судебное дело:\nИмя ответчика: " + defendantName + "\t|\tИмя истца: " + plaintiffName + "\t|\tДата: " + date
                + "\t|\tСтатья: " + article + "\t|\tПриговор : " + isConvicted;
    }
}
