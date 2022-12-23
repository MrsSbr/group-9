import enums.ColorGift;
import enums.SizeGift;
import enums.TypeGift;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * вывести
 * года, в которые были подарки всех используемых размеров
 * максимальный вес для подарка каждого цвета
 * суммарный вес для каждого типа подарка
 */
public class TeodorAnalysis {
    private final Logger logger = Logger.getLogger(TeodorAnalysis.class.getName());
    private final List<Gift> gifts;

    public TeodorAnalysis(List<Gift> gifts) {
        this.gifts = gifts;
    }

    //    года, в которые были подарки всех используемых размеров
    public Set<Integer> getYearsWithAllSizeGift() {
        logger.log(Level.INFO, "Старт метода getYearsWithAllSizeGift");
        Map<Integer, Set<SizeGift>> yearsWithListSize = new HashMap<>();
        Set<Integer> yearsWithAllSizeGift = new HashSet<>();
        int year;
        for (var gift : gifts) {
            year = gift.year();
            if (yearsWithListSize.containsKey(year)) {
                var coll = yearsWithListSize.get(year);
                coll.add(gift.size());
            } else {
                Set<SizeGift> coll = new HashSet<>();
                coll.add(gift.size());
                yearsWithListSize.put(year, coll);
            }
        }
        int count = SizeGift.values().length - 1;

        yearsWithListSize.forEach((k, v) -> {
            if (v.size() == count) {
                yearsWithAllSizeGift.add(k);
            }
        });
        logger.log(Level.INFO, "Конец метод getYearsWithAllSizeGift");
        return yearsWithAllSizeGift;
    }


    //    максимальный вес для подарка каждого цвета
    public Map<ColorGift, Double> getMaxWeightForEachColor() {
        logger.log(Level.INFO, "Старт метода getMaxWeightForEachColor");
       var maxWeightForEachColor = new HashMap<ColorGift, Double>();
        double currWeight = 0;
        for (var gift : gifts) {
            maxWeightForEachColor.putIfAbsent(gift.color(), gift.weight());
            maxWeightForEachColor.computeIfPresent(gift.color(), (k,v) -> (v < gift.weight()) ? gift.weight(): v);
/*            if (maxWeightForEachColor.containsKey(gift.color())) {
                maxWeight = maxWeightForEachColor.get(gift.color());
                if (maxWeight < gift.weight())
                    maxWeightForEachColor.replace(gift.color(), gift.weight());
            } else {
                maxWeightForEachColor.put(gift.color(), gift.weight());
            }*/
        }
        logger.log(Level.INFO, "Конец метод getMaxWeightForEachColor");
        return maxWeightForEachColor;
    }


    //    суммарный вес для каждого типа подарка
    public Map<TypeGift, Double> getSumWeightForEachType() {
        logger.log(Level.INFO, "Старт метода getSumWeightForEachType");
        Map<TypeGift, Double> sumWeightForEachType = new HashMap<>();
        double sumWeight = 0;
        for (var gift : gifts) {
            if (sumWeightForEachType.containsKey(gift.type())) {
                sumWeight = sumWeightForEachType.get(gift.type());
                sumWeightForEachType.replace(gift.type(), sumWeight + gift.weight());
            } else {
                sumWeightForEachType.put(gift.type(), gift.weight());
            }
        }
        logger.log(Level.INFO, "Конец метод getSumWeightForEachType");
        return sumWeightForEachType;
    }

}
