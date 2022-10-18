package Classes;

import Interfaces.Factory;

import java.util.Scanner;

public class  TriangleFactory implements Factory {
    @Override
    public PlaneFigure createFigure() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название фигуры: ");
        String name = input.nextLine();
        System.out.println("Введите периметр фигуры: ");
        double perimeter = input.nextDouble();
        System.out.println("Введите тип (равнобедренный, равносторонний и др) фигуры: ");
        String type = input.next();
        return new Triangle(name, perimeter, type);
    }
}
