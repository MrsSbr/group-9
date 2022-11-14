package factory.confectionery;

import factory.confectionery.domain.cakes.Cake;
import factory.confectionery.interfaces.Confection;
import factory.confectionery.domain.cakes.HoneyCake;
import factory.confectionery.domain.candies.JellyCandy;
import factory.confectionery.domain.cookies.ShortBread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConfectioneryApp {
    public static void main(String[] args) {
        List<Confection> confections = new ArrayList<>();
        confections.add(new JellyCandy("Пчелка"));
        confections.add(new HoneyCake());
        confections.add(new ShortBread("Юбилейное", "Квадрат"));
        confections.add(new ShortBread("Юбилейное", "Круг"));
        confections.add(new ShortBread("К чаю", "Квадрат"));
        confections.add(new ShortBread("Юбилейное", "Квадрат"));
        confections.add(new Cake("Наполеон", "Заворной кремя", "Бисквитное"));
        confections.add(new JellyCandy("Сьюзи"));
        System.out.println("Приготовление кондитерских изделий на фабрике");
        for (var item : confections) {
            item.cook();
            System.out.println(item+ " приготовлен(а)");
            System.out.println("------------------");
        }
        System.out.println("Посчитаем количество уникальных кондитерских изделий\n");
        Map<Confection, Integer> countUnique = confections.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        countUnique.forEach((k, v) -> System.out.println(k.toString() + ": " + v));
    }
    }




