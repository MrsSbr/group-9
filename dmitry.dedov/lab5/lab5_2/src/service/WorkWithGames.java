package service;

import enums.GenreOfGame;
import models.Game;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkWithGames {

    private final List<Game> games = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(WorkWithGames.class.getName());

    public void fillFromFile(String filePathForInput) {

        logger.log(Level.INFO, "Start read file");

        try (Stream<String> stringsStream = Files.newBufferedReader(Paths.get(filePathForInput)).lines()) {

            stringsStream.forEach(line -> {

                Game game = Game.parseToGame(line);
                if (game == null) {

                    logger.log(Level.SEVERE, "Parse game error! Stop read");

                } else {

                    games.add(game);

                }

            });

        } catch (FileNotFoundException e) {

            logger.log(Level.SEVERE, "File not found", e);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "Read file exception", e);

        }

        logger.log(Level.INFO, "End read file");

    }

    private Map<GenreOfGame, List<Integer>> getScoresOfAllGenres() {

        return games.stream()
                .collect(Collectors.groupingBy(
                        Game::getGenre,
                        Collectors.mapping(Game::getScore, Collectors.toList())
                ));

    }

    private Set<GenreOfGame> getGenresWithBestAverageScore() {

        Map<GenreOfGame, List<Integer>> scoresOfAllGenres = getScoresOfAllGenres();

        Map<GenreOfGame, Double> averageScoresOfAllGenres = scoresOfAllGenres.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        score -> score.getValue().stream()
                                .mapToInt(elem -> elem)
                                .average()
                                .orElse(0)
                ));

        var maxAverageScore = averageScoresOfAllGenres.entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(NoSuchElementException::new);

        return averageScoresOfAllGenres.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxAverageScore.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

    private Map<Month, Integer> getMonthsWithTimeSpentOnGames() {

        return games.stream()
                .collect(Collectors.toMap(game -> game.getDateOfComplete().getMonth(),
                        Game::getTimeToCompleteInHours,
                        Integer::sum
                ));

    }

    private Set<Month> getMonthWithMaxTimeSpentOnGames() {

        Map<Month, Integer> monthsWithTimeSpentOnGames = getMonthsWithTimeSpentOnGames();

        var maxTimeSpentOnGames = monthsWithTimeSpentOnGames.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow(NoSuchElementException::new);


        return monthsWithTimeSpentOnGames.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxTimeSpentOnGames.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

    private Set<String> getGamesWithMultiplePassing() {

        Set<String> gamesWithOnePassing = new HashSet<>();

        return games.stream()
                .map(Game::getNameOfGame)
                .filter(nameOfGame -> !gamesWithOnePassing.add(nameOfGame))
                .collect(Collectors.toSet());

    }

    public void workWithGames() {

        System.out.println("Results of the work: ");
        System.out.println("1. The genre(s) in which the games received the highest average score:\n");
        System.out.println(getGenresWithBestAverageScore());

        System.out.println("\n\n2. The month in which the total time spent on completing games completed in this month is the maximum:\n");
        System.out.println(getMonthWithMaxTimeSpentOnGames());

        System.out.println("\n\n3. All games that Innokenty has played more than 1 time:\n");
        System.out.println(getGamesWithMultiplePassing());

    }

}