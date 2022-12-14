package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordsOfChronicle {
    private final List<Chronicle> chronicleList = new ArrayList<>();

    public void addChronicle(Chronicle chronicle) {
        chronicleList.add(chronicle);
    }

    public List<Chronicle> getChronicleList() {
        return chronicleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecordsOfChronicle that = (RecordsOfChronicle) o;
        return Objects.equals(chronicleList, that.chronicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chronicleList);
    }
}
