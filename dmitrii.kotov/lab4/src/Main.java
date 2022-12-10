import models.Fight;
import models.WorkingWithFights;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

public class Main {
    private static final String LOG_PATH = "dmitrii.kotov/lab4/logs/logs.txt";
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler(LOG_PATH);
            logger.addHandler(fh);
            logger.log(Level.INFO, "Начало работы");

            WorkingWithFights worker = new WorkingWithFights();
            List<Fight> fights = MyFileReader.getFightsListFromFile();
            logger.log(Level.INFO, "Информация из файла успешно передана и конвертирована");
            worker.makeWorkWithFights(fights);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при обработке последовательности данных", e);
        }
        logger.log(Level.INFO, "Задача успешно выполнена. Завершение работы");
    }
}