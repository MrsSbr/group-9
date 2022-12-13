import java.util.*;

public class Team {
    private String name;
    private int points;
    private int numberOfGoalsScored;

    Team(String name,int points,int numberOfGoalsScored){
        this.name=name;
        this.points=points;
        this.numberOfGoalsScored=numberOfGoalsScored;
    }
    Team(String name){
        this.name=name;
        points=0;
        numberOfGoalsScored=0;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored){
        this.numberOfGoalsScored=numberOfGoalsScored;
    }
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
    public int getNumberOfGoalsScored(){
        return numberOfGoalsScored;
    }

    public void setPoints(int points){
        this.points=points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return points == team.points && numberOfGoalsScored == team.numberOfGoalsScored && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points, numberOfGoalsScored);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", numberOfGoalsScored=" + numberOfGoalsScored +
                '}';
    }
}
