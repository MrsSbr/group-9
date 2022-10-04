package Model;

import Interface.ICreation;

import java.util.Scanner;

public class MilitaryCreation implements ICreation {
    @Override
    public Port createPort() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название порта: ");
        String name = input.nextLine();
        //S
        System.out.println("Введите площадь порта: ");
        double S = input.nextDouble();
        //personnel
        System.out.println("Введите количество военных: ");
        int numberOfMilitaryPersonnel = input.nextInt();

        return new CargoPort(name, S, numberOfMilitaryPersonnel);
    }
}
