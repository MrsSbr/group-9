package Models;

import java.util.*;

public class Championship {

    private final Map<String, List<Game>> match = new HashMap<>();

    public Championship() {

    }

    public Map<String, List<Game>> add(Game game, String nameTeam) {
        Game newGame = new Game(game.getHome(), game.getVisit(), game.getCountGoolHome(), game.getCountGoolVisit());
        if (!match.containsKey(nameTeam)) {
            match.put(nameTeam, new ArrayList<>());
            match.get(nameTeam).add(newGame);
        } else {
            match.get(nameTeam).add(newGame);
        }
        return match;
    }

    public void parsingMatch(String match) {
        String[] parcMatch = match.split(";");
        String[] matchResult = parcMatch[2].split(":");
        Game game = new Game(parcMatch[0], parcMatch[1], Integer.parseInt(matchResult[0]), Integer.parseInt(matchResult[1]));
        add(game, parcMatch[0]);
        add(game, parcMatch[1]);
    }

    public int scoring(String nameTeam) {
        List<Game> res = this.match.get(nameTeam);
        int pointsWin = res.stream()
                .filter(game -> game.getHome().equals(nameTeam) &&
                        game.getCountGoolHome() > game.getCountGoolVisit() ||
                        game.getVisit().equals(nameTeam) && game.getCountGoolVisit() > game.getCountGoolHome()
                ).mapToInt(game -> 3).sum();
        int pointsDraw = res.stream()
                .filter(game -> game.getVisit().equals(nameTeam) && game.getCountGoolVisit() == game.getCountGoolHome()
                ).mapToInt(game -> 1).sum();

        return (pointsWin + pointsDraw);
    }

    public List<String> defeatedTeams(String nameTeam) {
        List<Game> res = this.match.get(nameTeam);
        List<String> defeatedTeams = new ArrayList<>();

        res.stream().filter(game ->
                        game.getHome().equals(nameTeam) &&
                                game.getCountGoolHome() > game.getCountGoolVisit())
                .forEach(game -> defeatedTeams.add(game.getVisit()));

        res.stream().filter(game ->
                        game.getVisit().equals(nameTeam) && game.getCountGoolVisit() > game.getCountGoolHome())
                .forEach(game -> defeatedTeams.add(game.getHome()));

        return defeatedTeams;
    }

    public boolean dryMatch(String nameTeam) {
        List<Game> res = this.match.get(nameTeam);
        return res.stream().
                filter(game -> game.getHome().equals(nameTeam))
                .mapToInt(Game::getCountGoolVisit).sum() == 0;
    }
    /*
    public List<String> dryMatchAllTeam() {
        List<String> dryMatch = new LinkedList<>();
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            if (this.dryMatch(entry.getKey())) {
                dryMatch.add(entry.getKey());
            }
        }
        return dryMatch;
    }

     */

    public List<String> dryMatchAllTeam() {
        List<String> dryMatch = new LinkedList<>();
        match.forEach(
                (key, value) -> {
                    if (this.dryMatch(key)) {
                        dryMatch.add(key);
                    }
                }
        );
        return dryMatch;
    }
    /*public HashMap<String, List<String>> defeatedAllTeams() {
        HashMap<String, List<String>> defeatedTeams = new LinkedHashMap<>();
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            defeatedTeams.put(entry.getKey(), this.defeatedTeams(entry.getKey()));
        }
        return defeatedTeams;
    }

     */

    public HashMap<String, List<String>> defeatedAllTeams() {
        HashMap<String, List<String>> defeatedTeams = new LinkedHashMap<>();
        match.forEach(
                (key, value) -> {
                    defeatedTeams.put(key, this.defeatedTeams(key));
                }
        );
        return defeatedTeams;
    }
    public List<Team> findTop3(HashMap<String, Integer> scoring) {
        List<Team> teams = new ArrayList<>();
        scoring.forEach(
                (key, value) -> {
                    teams.add(new Team(key, value));
                }
        );
        teams.sort((Team::compareTo));
        List<Team> medalists = new LinkedList<>();
        int count = 0;
        while (count != 3) {
            medalists.add(new Team(teams.get(count).getName(), teams.get(count).getPoints()));
            count++;
        }
        return medalists;
    }

    public HashMap<String, Integer> scoringAllTeam() {
        HashMap<String, Integer> scoring = new LinkedHashMap<>();
        match.forEach(
                (key, value) -> {
                    scoring.put(key, this.scoring(key));
                }
        );
        return scoring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Championship that = (Championship) o;
        return Objects.equals(match, that.match);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match);
    }
}
