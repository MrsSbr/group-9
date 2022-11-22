package helper;

import loger.Logs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {

    private static final Logger logger = Logger.getLogger(Reader.class.getName());
    public static void readFile(Logs logs) {

        File file = new File("C:\\Users\\Nikita\\Desktop\\Java_Labs\\group-9\\nikita.zazulin\\Lab_4\\src\\loger\\Logs.txt");

        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();

            while (line != null) {

                logs.add(line);
                line = reader.readLine();

            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "File error!", e);
        }

    }

}
