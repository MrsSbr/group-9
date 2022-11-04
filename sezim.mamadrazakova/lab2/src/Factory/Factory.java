package Factory;

import Classes.Circle;
import Classes.Triangle;
import Enum.FigureType;
import Classes.PlaneFigure;


import java.util.Scanner;

public class Factory {
    public static PlaneFigure createFigureType(FigureType type) throws Exception {
        PlaneFigure factory;
        switch (type) {
            case TRIANGLE:
                factory = createTriangle();
                break;
            case CIRCLE:
                factory = createCircle();
                break;
            default:
                throw new ClassNotFoundException("Класс переданного типа не существует.");
        }
        ;
        return factory;

    }

    private static PlaneFigure createTriangle() {
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

    private static PlaneFigure createCircle() {
        Scanner input = new Scanner(System.in);
        //name
        System.out.println("Введите название фигуры: ");
        String name = input.nextLine();
        System.out.println("Введите периметр фигуры: ");
        double perimeter = input.nextDouble();
        System.out.println("Введите радиус фигуры: ");
        double radius = input.nextDouble();
        return new Circle(name, perimeter, radius);
    }
}
