package Models;

import java.util.*;

public class Team {
    private String name;
    private int points;


    Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    Team(String name) {
        this.name = name;
        points = 0;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Team team) {
        return (team.points - this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return points == team.points && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
