import models.AntIsABullet;
import models.Ants;
import models.GiantAntTurtle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Муравьи в муравейнике");
        Ants giantAntTurtle = new GiantAntTurtle(3, "желтый", "рабочий", 5, "Америка");
        Ants giantAntTurtle2 = new GiantAntTurtle(3, "черный", "самка", 7, "Америка");
        Ants antsABullet = new AntIsABullet(5, "красный", "рабочий", "Америка", false);
        Ants antsABullet2 = new AntIsABullet(4, "черный", "рабочий", "Россия", true);

        List<Ants> ants = new ArrayList<>();
        ants.add(giantAntTurtle);
        ants.add(giantAntTurtle2);
        ants.add(antsABullet);
        ants.add(antsABullet2);
        int position = 1;
        for (Ants ant : ants) {

            System.out.println(position + ". " + ant.toString());
            if (ant instanceof GiantAntTurtle) {
                System.out.println("; Имеет " + ((GiantAntTurtle) ant).getSpikes() + " шипов ");
            } else if (ant instanceof AntIsABullet) {
                System.out.println("; Наличие яда->" + ((AntIsABullet) ant).getPresenceOfPoison());
            }
            System.out.println();
            ant.live();
            System.out.println();
            ant.collectFood();
            System.out.println();
            position++;
        }
        System.out.println();
        GiantAntTurtle ant = new GiantAntTurtle(3, "черный", "рабочий", 5, "Америка");
        System.out.println(ant + "; Имеет " + ant.getSpikes() + " шипов ");
        System.out.println("Сравнение 2 объектов: " + giantAntTurtle.equals(ant));
        System.out.println("Hash ant: " + ant.hashCode());


    }
}















