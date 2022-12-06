import java.util.List;

public class main {
    public static void main(String[] args) {
        task();
    }

    public static void task(){
        long startTime = System.currentTimeMillis();
        List<Sacrifice> sacrificesArr;
        sacrificesArr = Table.generate(1);
        Table.outputAll(sacrificesArr);
        Table.results(sacrificesArr);
        System.out.println("Дождь на следующий день: " + Table.rainNextDay(sacrificesArr));
        Table.lastDate(sacrificesArr);
        long endTime = System.currentTimeMillis();
        System.out.println("Ваше время выполнения: " + (endTime - startTime));
        System.out.println("––––––––––––––––––––––––––");
        startTime = System.currentTimeMillis();
        List<Sacrifice> sacrificesList;
        sacrificesList = Table.generate(2);
        Table.outputAll(sacrificesList);
        Table.results(sacrificesList);
        System.out.println("Дождь на следующий день: " + Table.rainNextDay(sacrificesList));
        Table.lastDate(sacrificesList);
        endTime = System.currentTimeMillis();
        System.out.println("Ваше время выполнения: " + (endTime - startTime));
    }
}
