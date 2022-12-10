package lab4.src.main.java.ru.pirates.logic;

import lab4.src.main.java.ru.pirates.entity.Citizenship;
import lab4.src.main.java.ru.pirates.entity.LootedShip;
import lab4.src.main.java.ru.pirates.entity.RecordsOfLootedShips;
import lab4.src.main.java.ru.pirates.service.HelpFunctions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LootedShipHandler {
    private final RecordsOfLootedShips recordsOfLootedShips;

    public LootedShipHandler(RecordsOfLootedShips recordsOfLootedShips) {
        this.recordsOfLootedShips = recordsOfLootedShips;
    }

    public Map<Citizenship, List<LootedShip>> getStatsForCitizens() {
        // для каждой страны найти статистику по кораблям, взятым на абордаж

        Map<Citizenship, List<LootedShip>> citizenshipLootedShipMap = new HashMap<>();

        recordsOfLootedShips.getLootedShipList()
                .stream()
                .filter(LootedShip::isWasBoarded)
                .forEach(record -> {
                    List<LootedShip> lootedShips = new ArrayList<>();
                    if (citizenshipLootedShipMap.get(record.getCitizenship()) != null) {
                        lootedShips = citizenshipLootedShipMap.get(record.getCitizenship());
                    }
                    lootedShips.add(record);
                    citizenshipLootedShipMap.put(record.getCitizenship(), lootedShips);
                });

        return citizenshipLootedShipMap;
    }

    public Month LeastProfitableMonth() {
        // найти наименее доходный месяц по золоту

        Map<Month, BigDecimal> goldByMonth = new HashMap<>();
        IntStream.range(1, 13)
                .forEach(i -> goldByMonth.put(Month.of(i), BigDecimal.ZERO));

        recordsOfLootedShips.getLootedShipList()
                .forEach(record -> goldByMonth.put(
                        record.getDate().getMonth(),
                        goldByMonth.get(record.getDate().getMonth()).add(record.getGoldReceived())
                ));

        return Objects.requireNonNull(HelpFunctions.min(goldByMonth, BigDecimal::compareTo)).getKey();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public List<LootedShip> shipsCarryingTheLargestStocksOfRumForLast3Years() {
        // корабли, на которых возят самые большие запасы рома (за последние 3 года)

        Optional<LootedShip> max = Optional.ofNullable(recordsOfLootedShips.getLootedShipList()
                .stream()
                .filter(record -> record.getDate().isAfter(LocalDate.now().minusYears(3)))
                .max(Comparator.comparing(LootedShip::getBarrelsOfRumReceived))
                .orElseThrow(NoSuchElementException::new));

        return recordsOfLootedShips.getLootedShipList()
                .stream()
                .filter(record -> record.getDate().isAfter(LocalDate.now().minusYears(3))
                        && record.getBarrelsOfRumReceived() == max.get().getBarrelsOfRumReceived())
                .collect(Collectors.toList());
    }

}