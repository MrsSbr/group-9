package lab4.src.main.java.ru.pirates.service;

import lab4.src.main.java.ru.pirates.entity.Citizenship;
import lab4.src.main.java.ru.pirates.entity.LootedShip;
import lab4.src.main.java.ru.pirates.entity.RecordsOfLootedShips;
import lab4.src.main.java.ru.pirates.entity.ShipClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

@SuppressWarnings("resource")
public class FileReader {
    private static final Path PATH = Paths.get("anatoliy.zagorovskiy/lab4/src/main/resources/res.txt");
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public static RecordsOfLootedShips readFile() {
        HelpFunctions.fileHandlerInit(logger);

        RecordsOfLootedShips recordsOfLootedShips = new RecordsOfLootedShips();
        Stream<String> stringStream = null;

        try {
            stringStream = Files.lines(PATH);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File not found");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при вводе-выводе данных: " + e.getMessage());
        }

        if (stringStream != null) {
            stringStream.forEach(line -> {
                String[] info = line.split(";");
                LootedShip lootedShip = new LootedShip(LocalDate.parse(info[0]),
                        ShipClass.valueOf(info[1]),
                        Citizenship.valueOf(info[2]),
                        BigDecimal.valueOf(Long.parseLong(info[3])),
                        Integer.parseInt(info[4]),
                        Boolean.parseBoolean(info[5]));
                recordsOfLootedShips.addLootedShip(lootedShip);
            });
        }

        return recordsOfLootedShips;
    }
}
