package models;

import enums.GenreOfGame;

import java.util.Objects;
import java.time.LocalDate;
import java.util.IllegalFormatException;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {

    private static final Logger logger = Logger.getLogger(Game.class.getName());
    private final String nameOfGame;
    private final GenreOfGame genre;
    private final LocalDate dateOfComplete;
    private final int timeToCompleteInHours;
    private final int score;

    public Game(String nameOfGame, GenreOfGame genre, LocalDate dateOfComplete, int timeToCompleteInHours, int score) {

        this.nameOfGame = nameOfGame;
        this.genre = genre;
        this.dateOfComplete = dateOfComplete;
        this.timeToCompleteInHours = timeToCompleteInHours;
        this.score = score;

    }

    public String getNameOfGame() { return nameOfGame; }

    public GenreOfGame getGenre() { return genre; }

    public LocalDate getDateOfComplete() { return dateOfComplete; }

    public int getTimeToCompleteInHours() { return timeToCompleteInHours; }

    public int getScore() { return score; }

    public static Game parseToGame(String text) {

        try {

            String[] parts = text.split(";");
            return new Game(parts[0], GenreOfGame.valueOf(parts[1].toUpperCase()), LocalDate.parse(parts[2]),
                    Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));

        } catch (IllegalFormatException e) {

            logger.log(Level.SEVERE, "GenreOfGame parse exception");

        } catch (NumberFormatException e) {

            logger.log(Level.SEVERE, "timeToCompleteInHours/Score parse exception", e);

        } catch (DateTimeParseException e) {

            logger.log(Level.SEVERE, "dateOfComplete parse exception", e);

        }

        return null;

    }

    @Override
    public String toString() {

        return "nameOfGame: " + nameOfGame +
                "genre: " + genre +
                "dateOfComplete: " + dateOfComplete +
                "timeToCompleteInHours: " + timeToCompleteInHours +
                "score: " + score;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;

        }

        if (obj == null || getClass() != obj.getClass()) {

            return false;

        }

        Game game = (Game) obj;
        return nameOfGame.equals(game.nameOfGame) &&
                genre.equals(game.genre) &&
                dateOfComplete.equals(game.dateOfComplete) &&
                timeToCompleteInHours == game.timeToCompleteInHours &&
                score == game.score;

    }

    @Override
    public int hashCode() {

        return Objects.hash(nameOfGame, genre, dateOfComplete, timeToCompleteInHours, score);

    }

}