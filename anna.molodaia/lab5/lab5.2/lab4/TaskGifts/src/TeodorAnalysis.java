import enums.ColorGift;
import enums.SizeGift;
import enums.TypeGift;

import java.util.*;
import java.util.stream.Collectors;

/**
 * вывести
 * года, в которые были подарки всех используемых размеров
 * максимальный вес для подарка каждого цвета
 * суммарный вес для каждого типа подарка
 */
public class TeodorAnalysis {
    private final List<Gift> gifts;
    public TeodorAnalysis(List<Gift> gifts) {
        this.gifts = gifts;
    }
    public boolean isEmpty(){return gifts.isEmpty();}
    public  void add (String gift){
        String[] f = gift.split(";");
        gifts.add(new Gift(Integer.parseInt(f[0]), SizeGift.getSize(f[1].trim()),
                Double.parseDouble(f[2]), TypeGift.getType(f[3].trim()),
                ColorGift.getColor(f[4].trim())));
    }

    //    года, в которые были подарки всех используемых размеров
    public Set<Integer> getYearsWithAllSizeGift() {
        var yearsWithListSize = gifts.stream()
                .collect(Collectors.groupingBy(Gift::year, Collectors.mapping(Gift::size, Collectors.toSet())));
        int count = SizeGift.values().length - 1;
        return yearsWithListSize
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    //    максимальный вес для подарка каждого цвета
    public Map<ColorGift, Double> getMaxWeightForEachColor() {
        return gifts.stream()
                .collect(Collectors.groupingBy(Gift::color,
                        Collectors.maxBy(Comparator.comparingDouble(Gift::weight))
                )).values().stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toMap(Gift::color, Gift::weight));
    }

    //    суммарный вес для каждого типа подарка
    public Map<TypeGift, Double> getSumWeightForEachType() {
        return gifts.stream()
                .collect(Collectors.groupingBy(Gift::type,
                        Collectors.summingDouble(Gift::weight)));

    }
}
