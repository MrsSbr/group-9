import models.Fight;
import models.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFileReader {
    private static final String FILE_PATH = "dmitrii.kotov/lab4/src/resources/fights.txt";
    private static final String LOG_PATH = "dmitrii.kotov/lab4/logs/logs.txt";

    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static List<Fight> getFightsListFromFile() {
        List<Fight> fights = new ArrayList<>();
        File file = new File(FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            FileHandler fileHandler = new FileHandler(LOG_PATH);
            logger.addHandler(fileHandler);

            String fileLine = reader.readLine();
            while (fileLine != null) {
                String[] info = fileLine.split(";");
                Fight fight = new Fight(info[0], info[1], info[2].equals("") ? null : info[2],
                        info[3], Result.valueOf(info[4]));
                fights.add(fight);
                fileLine = reader.readLine();
            }

            logger.log(Level.INFO, "Информация из файла успешно считана");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при чтении из файла: ", e);
        }

        return fights;
    }
}
