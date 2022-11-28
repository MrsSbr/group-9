package ru.pirates.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordsOfLootedShips {
    private final List<LootedShip> lootedShipList = new ArrayList<>();

    public void addLootedShip(LootedShip lootedShip) {
        lootedShipList.add(lootedShip);
    }

    public List<LootedShip> getLootedShipList() {
        return lootedShipList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecordsOfLootedShips that = (RecordsOfLootedShips) o;
        return Objects.equals(lootedShipList, that.lootedShipList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lootedShipList);
    }
}
