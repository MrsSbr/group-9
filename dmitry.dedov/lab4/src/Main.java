import service.WorkWithGames;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {



    private static final String DATA_PATH = "dmitry.dedov/lab4/src/resources/games.txt";
    private static final String LOG_PATH = "dmitry.dedov/lab4/logs/logs.txt";
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(final String[] args) {

        try {

            FileHandler fh = new FileHandler(LOG_PATH);
            logger.addHandler(fh);

            logger.log(Level.INFO, "Start program");

            WorkWithGames workWithGames = new WorkWithGames();
            workWithGames.fillFromFile(DATA_PATH, fh);
            workWithGames.workWithGames();

        } catch (IOException e) {

            logger.log(Level.SEVERE, "Error when processing data!", e);

        }

        logger.log(Level.OFF, "End program");

    }

}