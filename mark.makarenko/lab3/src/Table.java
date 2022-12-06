import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Table {
    final static int overall = 20;


    public static List<Sacrifice> generate(int choice) {
        LocalDate begin = LocalDate.of(2020,1,10);
        LocalDate end = LocalDate.of(2025,12,10);
        List<Sacrifice> sacrifices;
        if (choice == 1) {
            sacrifices = new ArrayList<>();
            for (int i = 0; i < overall; i++) {
                sacrifices.add(new Sacrifice((Helper.between(begin,end)), humanOrAnimal(Helper.getRandomIndexInRange(1,3)), Helper.getRandomIndexInRange(1,7)));
            }
        } else {
            sacrifices = new LinkedList<>();
            for (int i = 0; i < overall; i++) {
                sacrifices.add(new Sacrifice((Helper.between(begin,end)), humanOrAnimal(Helper.getRandomIndexInRange(1,3)), Helper.getRandomIndexInRange(1,7)));
            }
        }
        return sacrifices;
    }

    public static void outputAll(List<Sacrifice> sacrifices){
        for (int i = 0; i < overall; i++)
            System.out.println(i + " : " + sacrifices.get(i).getDate() + " " + sacrifices.get(i).getType() + " " + sacrifices.get(i).getDaysTillRain());
    }

    public static int rainNextDay(List<Sacrifice> sacrifices){
        int count = 0;
        for (int i = 0; i < overall; i++){
            if (sacrifices.get(i).getDaysTillRain() == 1){
                count ++;
            }
        }
        return count;
    }

    public static void results(List<Sacrifice> sacrifices){
        int humanCount = 0;
        int animalCount = 0;
        for (int i = 0; i < overall; i++){
            if (Objects.equals(sacrifices.get(i).getType(), "human")) {
                humanCount += sacrifices.get(i).getDaysTillRain();
            }
            else{
                animalCount += sacrifices.get(i).getDaysTillRain();
            }
        }
        System.out.print("человеческие : ");
        System.out.println(humanCount);
        System.out.print("животные : ");
        System.out.println(animalCount);
        if (animalCount > humanCount) {
            System.out.println("Животные лучше");
        }
        else if (animalCount < humanCount){
            System.out.println("человеки лучше");
        }
        else{
            System.out.println("ничья");
        }
    }


    public static String humanOrAnimal (int choice) {
        if (choice == 1)
            return "human";
        else return "animal";

    }

    public static void lastDate(List<Sacrifice> sacrifices){
        int maxLastMonth = 0;
        int maxLastYear = 0;
        int index = 0;
        for (int i = 0; i < overall; i++){
            if (sacrifices.get(i).getDate().getMonthValue() > maxLastMonth &&
                    sacrifices.get(i).getDate().getYear() >= maxLastYear){
                maxLastMonth = sacrifices.get(i).getDate().getMonthValue();
                maxLastYear = sacrifices.get(i).getDate().getYear();
                index = i;
            }
        }
        boolean check = false;
        while (!check){
            maxLastMonth --;
            if (maxLastMonth == 0){
                maxLastMonth = 12;
                maxLastYear --;
            }
            boolean insideCheck = true;
            for (int i = 0; i < overall; i++){
                if (maxLastYear == sacrifices.get(i).getDate().getYear() && maxLastMonth == sacrifices.get(i).getDate().getMonthValue()) {
                    insideCheck = false;
                    break;
                }
            }
            if (insideCheck){
                check = true;
            }
        }
        System.out.println(index + " : " + maxLastYear + " " + maxLastMonth);
    }
}