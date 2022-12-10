package lab4.src.main.java.ru.pirates;

import lab4.src.main.java.ru.pirates.UI.Menu;
import lab4.src.main.java.ru.pirates.service.FileReader;
import lab4.src.main.java.ru.pirates.service.HelpFunctions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static void main(String[] args) {
        HelpFunctions.fileHandlerInit(logger);

        logger.log(Level.INFO, "Начало работы программы");

        Menu.menuWork();

        logger.log(Level.INFO, "Программа завершила работу");
    }
}