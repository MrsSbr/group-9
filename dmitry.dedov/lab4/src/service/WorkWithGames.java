package service;

import enums.GenreOfGame;
import models.Game;

import java.time.Month;
import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkWithGames {

    private List<Game> games = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(WorkWithGames.class.getName());

    public void fillFromFile(String filePathForInput, FileHandler fh) {

        logger.log(Level.INFO, "Start read file");
        File file = new File(filePathForInput);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();
            while (line != null) {

                Game game = Game.parseToGame(line);
                if (game == null) {

                    logger.log(Level.SEVERE, "Parse game error! Stop read");

                } else {

                    games.add(game);

                }

                line = bufferedReader.readLine();

            }

        } catch (FileNotFoundException e) {

            logger.log(Level.SEVERE, "File not found", e);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "Read file exception", e);

        }

        logger.log(Level.INFO, "End read file");

    }

    private Map<GenreOfGame, List<Integer>> getScoresOfAllGenres() {

        Map<GenreOfGame, List<Integer>> scoresOfAllGenres = new HashMap<>();

        for (Game game : games) {

            GenreOfGame genreOfGame = game.getGenre();

            if (scoresOfAllGenres.containsKey(genreOfGame)) {

                scoresOfAllGenres.get(genreOfGame).add(game.getScore());

            }
            else {

                List<Integer> scores = new ArrayList<>();
                scores.add(game.getScore());
                scoresOfAllGenres.put(genreOfGame, scores);

            }

        }

        return scoresOfAllGenres;

    }

    private Set<GenreOfGame> getGenresWithBestAverageScore() {

        Map<GenreOfGame, List<Integer>> scoresOfAllGenres = getScoresOfAllGenres();
        double maxAverageScore = 0.0;
        Set<GenreOfGame> genresWithBestAverageScore = new HashSet<>();

        for (var scoresOfGenre : scoresOfAllGenres.entrySet()) {

            double sumOfScores = 0.0;

            for (int score: scoresOfGenre.getValue()) {

                sumOfScores += score;

            }

            double averageScoreOfGenre = sumOfScores / scoresOfGenre.getValue().size();

            if (averageScoreOfGenre > maxAverageScore) {

                maxAverageScore = averageScoreOfGenre;
                genresWithBestAverageScore.clear();
                genresWithBestAverageScore.add(scoresOfGenre.getKey());

            }
            else if (averageScoreOfGenre == maxAverageScore) {

                genresWithBestAverageScore.add(scoresOfGenre.getKey());

            }

        }

        return genresWithBestAverageScore;

    }

    private Map<Month, Integer> getMonthsWithTimeSpentOnGames() {

        Map<Month, Integer> monthsWithTimeSpentOnGames = new HashMap<>();

        for (Game game : games) {

            Month month = game.getDateOfComplete().getMonth();

            if (monthsWithTimeSpentOnGames.containsKey(month)) {

                monthsWithTimeSpentOnGames.put(month, monthsWithTimeSpentOnGames.get(month)
                        + game.getTimeToCompleteInHours());

            }
            else {

                monthsWithTimeSpentOnGames.put(month, game.getTimeToCompleteInHours());

            }

        }

        return monthsWithTimeSpentOnGames;

    }

    private Set<Month> getMonthWithMaxTimeSpentOnGames() {

        Map<Month, Integer> monthsWithTimeSpentOnGames = getMonthsWithTimeSpentOnGames();
        Set<Month> monthsWithMaxTimeSpentOnGames = new HashSet<>();
        int maxTimeSpentOnGames = 0;

        for (var monthWithTimeSpentOnGames : monthsWithTimeSpentOnGames.entrySet()) {

            if (monthWithTimeSpentOnGames.getValue() > maxTimeSpentOnGames) {

                maxTimeSpentOnGames = monthWithTimeSpentOnGames.getValue();
                monthsWithMaxTimeSpentOnGames.clear();
                monthsWithMaxTimeSpentOnGames.add(monthWithTimeSpentOnGames.getKey());

            }
            else if (monthWithTimeSpentOnGames.getValue() == maxTimeSpentOnGames) {

                monthsWithMaxTimeSpentOnGames.add(monthWithTimeSpentOnGames.getKey());

            }

        }

        return monthsWithMaxTimeSpentOnGames;

    }

    private Set<String> getGamesWithMultiplePassing() {

        Set<String> gamesWithOnePassing = new HashSet<>();
        Set<String> gamesWithMultiplePassing = new HashSet<>();

        for (Game game : games) {

            if (!gamesWithOnePassing.add(game.getNameOfGame())) {

                gamesWithMultiplePassing.add(game.getNameOfGame());

            }

        }

        return gamesWithMultiplePassing;

    }

    public void workWithGames() {

        System.out.println("Results of the work: ");
        System.out.println("1. The genre(s) in which the games received the highest average score:\n");
        System.out.println(getGenresWithBestAverageScore());

        System.out.println("\n\n2. The month in which the total time spent on completing games " +
                "completed in this month is the maximum:\n");
        System.out.println(getMonthWithMaxTimeSpentOnGames());

        System.out.println("\n\n3. All games that Innokenty has played more than 1 time:\n");
        System.out.println(getGamesWithMultiplePassing());

    }

}