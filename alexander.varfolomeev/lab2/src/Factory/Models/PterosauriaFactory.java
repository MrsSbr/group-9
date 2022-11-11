package factory.Models;

import factory.Interfaces.DinosaurFactory;
import models.Dinosaur;
import models.Pterosauria;
import src.Helper;

import java.util.Scanner;

public class PterosauriaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        String name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        double weight = Helper.getPositiveDouble();

        System.out.println("Введите максимальный размах крыльев: ");
        double wingspan = Helper.getPositiveDouble();

        return new Pterosauria(name, weight, wingspan);
    }
}
