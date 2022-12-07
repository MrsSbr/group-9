import java.util.*;

public class Сhampionship {

    private Map<String,List<Team>> match = new HashMap<>();
    public Map<String,List<Team>> addNewElement(Team team,String nameTeam){
        match.put(nameTeam,new ArrayList<>(Collections.singletonList(team)));
        return match;
    }
    public void printHashMap(){
        int i=1;
        for (Map.Entry<String,List<Team>> entry : match.entrySet()) {
            System.out.println(i);
            System.out.println(entry.getKey()+" "+entry.getValue());
            i++;
        }
    }

    public Map<String,List<Team>> getMatch() {
        return match;
    }

    public void parsingMatch(String match){
        String parcMatch[]=match.split(";");
        String matchResult[]= parcMatch[2].split(":");
        Team teamHome= new Team(parcMatch[0]);
        Team teamVisiting= new Team(parcMatch[1]);
        teamHome.setNumberOfGoalsScored(Integer.parseInt(matchResult[0]));
        teamVisiting.setNumberOfGoalsScored(Integer.parseInt(matchResult[1]));
        if(teamHome.getNumberOfGoalsScored()>teamVisiting.getNumberOfGoalsScored()){
            teamHome.win();
        }
        if(teamHome.getNumberOfGoalsScored()<teamVisiting.getNumberOfGoalsScored()){
            teamVisiting.win();
        }
        if(teamHome.getNumberOfGoalsScored()==teamVisiting.getNumberOfGoalsScored()){
            teamHome.draw();
            teamVisiting.draw();
        }
        if(!this.match.containsKey(teamHome)) {
            addNewElement(teamHome,teamHome.getName());
        }
        if(!this.match.containsKey(teamVisiting)) {
            addNewElement(teamVisiting,teamVisiting.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сhampionship that = (Сhampionship) o;
        return Objects.equals(match, that.match);
    }
    @Override
    public int hashCode() {
        return Objects.hash(match);
    }
}
