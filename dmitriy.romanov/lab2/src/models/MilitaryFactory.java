package models;

import interfaces.PortFactory;

import java.util.Scanner;

public class MilitaryFactory implements PortFactory {
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
        int numberOfMilitaryPersonnel = Input.userInput(0,Integer.MAX_VALUE);

        return new MilitaryPort(name, S, numberOfMilitaryPersonnel);
    }
}
