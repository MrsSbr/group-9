import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String PATH = "anna.molodaia/lab5/lab5.2/lab4/TaskGifts/src/resources/info_santa_claus.csv";

    public static void main(String[] args) {
        logger.log(Level.INFO, "Старт анализа Теодора");
        boolean isEnd = false;
        TeodorAnalysis analysis = Helper.readFileInListGift(PATH);
        if (analysis.isEmpty()) {
            logger.log(Level.OFF, "Не удалось считать подарки из файла.");
            return;
        }

        while (!isEnd) {

            System.out.println("Меню:");
            System.out.println("[1]. Вывести года, в которые были подарки всех используемых размеров.");
            System.out.println("[2]. Вывести максимальный вес для подарка каждого цвета.");
            System.out.println("[3]. Вывести суммарный вес для каждого типа подарка.");
            System.out.println("[0]. Выход.");
            int choice = Helper.getIntInDiapason(0, 3);
            switch (choice) {
                case 0 -> isEnd = true;
                case 1 -> System.out.println(analysis.getYearsWithAllSizeGift());
                case 2 -> System.out.println(analysis.getMaxWeightForEachColor());
                case 3 -> System.out.println(analysis.getSumWeightForEachType());

            }
        }

        logger.log(Level.OFF, "Конец анализа Теодора");
    }
}
