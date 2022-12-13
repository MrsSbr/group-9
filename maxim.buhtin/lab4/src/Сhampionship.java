import java.util.*;

public class Сhampionship {

    private final Map<String, List<Game>> match = new HashMap<>();

    public Map<String, List<Game>> add(Game game, String nameTeam) {
        if (!match.containsKey(nameTeam)) {
            match.put(nameTeam, new ArrayList<>());
            match.get(nameTeam).add(new Game(game.getHome(), game.getVisit(), game.getCountGoolHome(), game.getCountGoolVisit()));
        } else {
            match.get(nameTeam).add(new Game(game.getHome(), game.getVisit(), game.getCountGoolHome(), game.getCountGoolVisit()));
        }
        return match;
    }

    public void printHashMap() {
        int i = 1;
        for (Map.Entry<String, List<Game>> entry : match.entrySet()) {
            System.out.println(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
            System.out.println(entry.getValue().size());
            i++;
        }
    }

    public void parsingMatch(String match) {
        String parcMatch[] = match.split(";");
        String matchResult[] = parcMatch[2].split(":");
        Game game = new Game(parcMatch[0], parcMatch[1], Integer.parseInt(matchResult[0]), Integer.parseInt(matchResult[1]));
        add(game, parcMatch[0]);
        add(game, parcMatch[1]);
    }

    public int scoring(String nameTeam){
        int points=0;
        List<Game>res =this.match.get(nameTeam);
        for (int i=0;i<res.size();i++){
            if(res.get(i).getHome().equals(nameTeam)&&res.get(i).getCountGoolHome() > res.get(i).getCountGoolVisit()){
                points+=3;
            }
            if(res.get(i).getHome().equals(nameTeam)&&res.get(i).getCountGoolHome() < res.get(i).getCountGoolVisit()){
                points+=1;
            }
            if(res.get(i).getVisit().equals(nameTeam) &&res.get(i).getCountGoolVisit() > res.get(i).getCountGoolHome()){
                points+=3;
            }
            if(res.get(i).getVisit().equals(nameTeam) &&res.get(i).getCountGoolVisit() == res.get(i).getCountGoolHome()){
                points+=1;
            }
        }
        return points;
    }

    public List<Integer> scoringAllTeam(){
        List<Integer> scoring=new LinkedList<Integer>();
        for (Map.Entry<String, List<Game>> entry : match.entrySet()){
            scoring.add(this.scoring(entry.getKey()));
        }
        return scoring;
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
