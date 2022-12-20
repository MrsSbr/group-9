package Reader;

import Models.Championship;

import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ReaderFile {
    private static final String path = "maxim.buhtin\\lab4\\TestFile.txt";
    private static final Logger logger = Logger.getLogger(Reader.class.getName());

    public Championship readFile() {
        Championship championship = new Championship();
        File file = new File(path);
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String match = reader.readLine();
            while (match != null) {
                championship.parsingMatch(match);
                match = reader.readLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }
        return championship;
    }
}
