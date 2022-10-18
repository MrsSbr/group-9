package models;

import interfaces.PortFactory;

import java.util.Scanner;

public class CargoFactory implements PortFactory {
    @Override
    public Port createPort() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название порта: ");
        String name = input.nextLine();
        //S
        System.out.println("Введите площадь порта: ");
        double S = input.nextDouble();
        //vesselCpct
        System.out.println("Введите вместимость судов: ");
        int vesselCapacity = Input.userInput(0, Integer.MAX_VALUE);

        return new CargoPort(name, S, vesselCapacity);
    }

}
