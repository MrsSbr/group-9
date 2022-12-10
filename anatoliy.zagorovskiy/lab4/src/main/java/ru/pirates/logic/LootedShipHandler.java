package ru.pirates.logic;

import ru.pirates.entity.Citizenship;
import ru.pirates.entity.LootedShip;
import ru.pirates.entity.RecordsOfLootedShips;
import ru.pirates.service.HelpFunctions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class LootedShipHandler {
    private final RecordsOfLootedShips recordsOfLootedShips;

    public LootedShipHandler(RecordsOfLootedShips recordsOfLootedShips) {
        this.recordsOfLootedShips = recordsOfLootedShips;
    }

    public Map<Citizenship, List<LootedShip>> getStatsForCitizens() {
        // для каждой страны найти статистику по кораблям, взятым на абордаж

        Map<Citizenship, List<LootedShip>> citizenshipLootedShipMap = new HashMap<>();

        for (LootedShip record : recordsOfLootedShips.getLootedShipList()) {
            if (record.isWasBoarded()) {
                List<LootedShip> lootedShips;
                if (citizenshipLootedShipMap.get(record.getCitizenship()) != null) {
                    lootedShips = citizenshipLootedShipMap.get(record.getCitizenship());
                } else {
                    lootedShips = new ArrayList<>();
                }
                lootedShips.add(record);

                citizenshipLootedShipMap.put(record.getCitizenship(), lootedShips);
            }
        }

        return citizenshipLootedShipMap;
    }

    public Month LeastProfitableMonth() {
        // найти наименее доходный месяц по золоту

        Map<Month, BigDecimal> goldByMonth = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            goldByMonth.put(Month.of(i), BigDecimal.ZERO);
        }
        for (LootedShip record : recordsOfLootedShips.getLootedShipList()) {
            BigDecimal sum = goldByMonth.get(record.getDate().getMonth())
                    .add(record.getGoldReceived());

            goldByMonth.put(record.getDate().getMonth(), sum);
        }
        return HelpFunctions.min(goldByMonth, BigDecimal::compareTo).getKey(); // TODO: 10.12.2022 добавить проверку на налл
    }

    public List<LootedShip> shipsCarryingTheLargestStocksOfRumForLast3Years() {
        // корабли, на которых возят самые большие запасы рома (за последние 3 года)

        List<LootedShip> result = new LinkedList<>();
        int maxBarrelsOfRum = 0;
        for (LootedShip record : recordsOfLootedShips.getLootedShipList()) {
            if (record.getDate().isAfter(LocalDate.now().minusYears(3))
                    && maxBarrelsOfRum < record.getBarrelsOfRumReceived()) {
                maxBarrelsOfRum = record.getBarrelsOfRumReceived();
            }
        }
        for (LootedShip record : recordsOfLootedShips.getLootedShipList()) {
            if (record.getDate().isAfter(LocalDate.now().minusYears(3))
                    && maxBarrelsOfRum == record.getBarrelsOfRumReceived()) {
                result.add(record);
            }
        }
        return result;
    }

}