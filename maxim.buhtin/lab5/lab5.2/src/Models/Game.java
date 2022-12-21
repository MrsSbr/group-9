package Models;

import java.util.Objects;

public class Game {
    private String home;
    private String visit;
    private int countGoolHome;
    private int countGoolVisit;

    Game(String home, String visit, int countGoolHome, int countGoolVisit) {
        this.home = home;
        this.visit = visit;
        this.countGoolHome = countGoolHome;
        this.countGoolVisit = countGoolVisit;
    }

    public String getHome() {
        return home;
    }

    public String getVisit() {
        return visit;
    }

    public int getCountGoolHome() {
        return countGoolHome;
    }

    public int getCountGoolVisit() {
        return countGoolVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return countGoolHome == game.countGoolHome && countGoolVisit == game.countGoolVisit && home.equals(game.home) && visit.equals(game.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, visit, countGoolHome, countGoolVisit);
    }

    @Override
    public String toString() {
        return "Game{" +
                "home='" + home + '\'' +
                ", visit='" + visit + '\'' +
                ", countGoolHome=" + countGoolHome +
                ", countGoolVisit=" + countGoolVisit +
                '}';
    }
}
