package Factory.Models;

import Factory.Interfaces.DinosaurFactory;
import Models.Dinosaur;
import Models.Ichthyosauria;
import src.Helper;

import java.util.Scanner;

public class IchthyosauriaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {
        String name;
        double weight;
        int habitatDepth;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        weight = Helper.getPositiveDouble();

        System.out.println("Введите максимальную глубину погружения: ");
        habitatDepth = Helper.getIntInDiapason(0, Integer.MAX_VALUE);

        return new Ichthyosauria(name, weight, habitatDepth);
    }
}
