package helper;

import loger.Logs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Reader {

    private static final Path path = Paths.get("src/loger/Logs.txt");
    private static final Logger logger = Logger.getLogger(Reader.class.getName());

    public static void readFile(Logs logs) {

        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

            List<String> lines = lineStream.toList();
            lines.forEach(logs::add);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "Error file work ", e);

        }

    }

}