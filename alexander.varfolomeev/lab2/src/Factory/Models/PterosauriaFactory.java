package Factory.Models;

import Factory.Interfaces.DinosaurFactory;
import Models.Dinosaur;
import Models.Pterosauria;
import src.Helper;

import java.util.Scanner;

public class PterosauriaFactory implements DinosaurFactory {
    @Override
    public Dinosaur createDinosaur() {
        String name;
        double weight;
        double wingspan;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя динозавра: ");
        name = in.nextLine();

        System.out.println("Введите вес динозавра: ");
        weight = Helper.getPositiveDouble();

        System.out.println("Введите максимальный размах крыльев: ");
        wingspan = Helper.getPositiveDouble();

        return new Pterosauria(name, weight, wingspan);
    }
}
