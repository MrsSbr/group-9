package ru.pirates.service;

import ru.pirates.entity.Citizenship;
import ru.pirates.entity.LootedShip;
import ru.pirates.entity.RecordsOfLootedShips;
import ru.pirates.entity.ShipClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;

public class FileOfRecordsReader {
    private static final Logger logger = Logger.getLogger(FileOfRecordsReader.class.getName());
    private static final String PATH = "anatoliy.zagorovskiy/lab4/src/main/resources/res.txt";

    public static RecordsOfLootedShips readFile() {
        HelpFunctions.fileHandlerInit(logger);

        RecordsOfLootedShips recordsOfLootedShips = new RecordsOfLootedShips();
        try (FileReader fileOfRecordsReader = new FileReader(PATH)) { // TODO добавить нормальный импорт
            Scanner fileScanner = new Scanner(fileOfRecordsReader);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] info = line.split(";");
                LootedShip lootedShip = new LootedShip(LocalDate.parse(info[0]),
                        ShipClass.valueOf(info[1]),
                        Citizenship.valueOf(info[2]),
                        BigDecimal.valueOf(Long.parseLong(info[3])),
                        Integer.parseInt(info[4]),
                        Boolean.parseBoolean(info[5]));
                recordsOfLootedShips.addLootedShip(lootedShip);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File not found");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при вводе-выводе данных: " + e.getMessage());
        }
        return recordsOfLootedShips;
    }
}
