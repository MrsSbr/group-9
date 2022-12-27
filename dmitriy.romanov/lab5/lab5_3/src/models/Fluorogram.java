package models;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fluorogram {
    private String name;
    private boolean hasPathology;
    private LocalDate date;

    public Fluorogram(String name, boolean hasPathology, LocalDate date) {
        this.name = name;
        this.hasPathology = hasPathology;
        this.date = date;
    }

    public Fluorogram() {
    }

    public boolean getPathology() {
        return hasPathology;
    }

    public LocalDate getDate() {
        return date;
    }

    private static final List<String> names = new ArrayList<>(Arrays.asList("Даниил", "Евгений", "Максим", "Владислав", "Николай", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"));
    private static final List<String> patronymic = new ArrayList<>(Arrays.asList("Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич", "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"));
    private static final List<String> surname = new ArrayList<>(Arrays.asList("Иванов", "Романов", "Протасов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"));

    public String randFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(surname, names, patronymic)
                .forEach(Collections::shuffle);
        Random rand = new Random();
        int indexName = rand.nextInt(names.size());
        int indexSurname = rand.nextInt(surname.size());
        int indexPatronymic = rand.nextInt(patronymic.size());
        stringBuilder.append(String.format("%s %s %s%n", surname.get(indexSurname), names.get(indexName), patronymic.get(indexPatronymic)));
        return stringBuilder.toString();
    }

    public boolean randPathology() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public Fluorogram randomFluorogram() {
        Fluorogram fluorogram = new Fluorogram();
        Random random = new Random();
        int minDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        fluorogram.name = randFullName();
        fluorogram.hasPathology = randPathology();
        fluorogram.date = randomDate;
        return fluorogram;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fluorogram{" +
                "name='" + name + '\'' +
                ", hasPathology=" + hasPathology +
                ", date=" + date +
                '}';
    }
}
