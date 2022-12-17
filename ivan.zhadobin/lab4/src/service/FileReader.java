package service;

import entity.Chronicle;
import entity.Khanate;
import entity.PlaceBattle;
import entity.RecordsOfChronicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final String path = "ivan.zhadobin\\lab4\\src\\text.txt";
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static RecordsOfChronicle readFile() {
        Helper.fileHandlerInit(logger);

        RecordsOfChronicle recordsOfChronicle = new RecordsOfChronicle();
        try (java.io.FileReader fileReader = new java.io.FileReader(path)) {
            Scanner fileScanner = new Scanner(fileReader);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] info = line.split(";");
                Chronicle chronicle = new Chronicle(LocalDate.parse(info[0]),
                        PlaceBattle.valueOf(info[1]),
                        Khanate.valueOf(info[2]),
                        Integer.parseInt(info[3]));
                recordsOfChronicle.addChronicle(chronicle);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File not found");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при вводе-выводе данных: " + e.getMessage());
        }
        return recordsOfChronicle;
    }

}
