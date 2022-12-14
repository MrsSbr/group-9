import menu.Menu;
import service.Helper;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static void main(String[] args) {
        Helper.fileHandlerInit(logger);

        logger.log(Level.INFO, "Начало работы программы");
        Menu.menuWork();
        logger.log(Level.INFO, "Программа завершила работу");
    }
}