package ru.pirates;

import ru.pirates.UI.Menu;
import ru.pirates.service.FileOfRecordsReader;
import ru.pirates.service.HelpFunctions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(FileOfRecordsReader.class.getName());

    public static void main(String[] args) {
        HelpFunctions.fileHandlerInit(logger);

        logger.log(Level.INFO, "Начало работы программы");

        Menu.menuWork();

        logger.log(Level.INFO, "Программа завершила работу");
    }
}