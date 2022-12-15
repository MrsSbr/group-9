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
        int points = 0;
        List<Game> res = this.match.get(nameTeam);
        for (Game re : res) {
            if (re.getHome().equals(nameTeam) && re.getCountGoolHome() > re.getCountGoolVisit()) {
                points += 3;
            }
            if (re.getHome().equals(nameTeam) && re.getCountGoolHome() < re.getCountGoolVisit()) {
                points += 1;
            }
            if (re.getVisit().equals(nameTeam) && re.getCountGoolVisit() > re.getCountGoolHome()) {
                points += 3;
            }
            if (re.getVisit().equals(nameTeam) && re.getCountGoolVisit() == re.getCountGoolHome()) {
                points += 1;
            }
        }
        return points;
    }

    public List<String> defeatedTeams(String nameTeam) {
        List<Game> res = this.match.get(nameTeam);
        List<String> defeatedTeams = new ArrayList<>();
        for (Game game : res) {
            if (game.getHome().equals(nameTeam) && game.getCountGoolHome() > game.getCountGoolVisit()) {
                defeatedTeams.add(game.getVisit());
            }
            if (game.getVisit().equals(nameTeam) && game.getCountGoolVisit() > game.getCountGoolHome()) {
                defeatedTeams.add(game.getHome());
            }
        }
        return defeatedTeams;
    }

    public boolean dryMatch(String nameTeam) {
        List<Game> res = this.match.get(nameTeam);
        int countConcededGoals = 0;
        for (Game game : res) {
            if (game.getHome().equals(nameTeam)) {
                countConcededGoals += game.getCountGoolVisit();
            }
        }
        return countConcededGoals == 0;
    }

    public List<String> dryMatchAllTeam() {
        List<String> dryMatch = new LinkedList<>();
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            if (this.dryMatch(entry.getKey())) {
                dryMatch.add(entry.getKey());
            }
        }
        return dryMatch;
    }

    public HashMap<String, List<String>> defeatedAllTeams() {
        HashMap<String, List<String>> defeatedTeams = new LinkedHashMap<>();
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            defeatedTeams.put(entry.getKey(), this.defeatedTeams(entry.getKey()));
        }
        return defeatedTeams;
    }

    public List<Team> findTop3(HashMap<String, Integer> scoring) {
        List<Team> teams = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoring.entrySet()) {
            teams.add(new Team(entry.getKey(), entry.getValue()));
        }
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
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            scoring.put(entry.getKey(), this.scoring(entry.getKey()));
        }
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
