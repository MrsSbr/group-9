import Classes.*;
import Interfaces.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enum.FigureType;
import Classes.*;
import Classes.PlaneFigure;

public class Main {
    public static void main(String[] args) throws Exception {
        List<PlaneFigure> figure = new ArrayList<>();
        boolean isExit = false;
        Scanner input = new Scanner(System.in);
        while (!isExit) {
            System.out.println("-Выберите пункт меню\n" +
                    "[1]Треугольник\n" +
                    "[2]Круг\n" +
                    "[3]вывести информацию\n" +
                    "[0]выход");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    figure.add(createFigure(choice));
                case 2:
                    figure.add(createFigure(choice));

                case 3:
                    printFigure(figure);

                case 0:
                    isExit = true;

            }
        }
    }

    public static PlaneFigure createFigure(int choice) throws Exception {
        Factory factory;
        switch (choice) {
            case 1:
                factory=Factory.createFigureType(FigureType.TRIANGLE);
                break;
            case 2:
                factory=Factory.createFigureType(FigureType.CIRCLE);
                break;
            default:
                throw new ClassNotFoundException();

        }
        return factory.createFigure();

    }

    public static void printFigure(List<PlaneFigure> figures) {
        boolean isExit = false;
        Scanner input = new Scanner(System.in);
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");
            for (int i = 0; i < figures.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + figures.get(i).getName());
            }
            int choice = input.nextInt();
            PlaneFigure fig;
            if (choice == 0) {
                isExit = true;
            } else {
                fig = figures.get(choice - 1);
                if (fig instanceof Triangle) {
                    Triangle triangle = (Triangle) fig;
                    System.out.println("Треугольник: " + triangle.getName() + " количество углов: " + triangle.countOfAngles() + " периметр:" + triangle.getPerimeter() + " тип: " + triangle.getType());

                } else if (fig instanceof Circle) {
                    Circle circle = (Circle) fig;
                    System.out.println("Окружность: " + circle.getName() + " Количество углов:" + circle.countOfAngles() + " периметр " + circle.getPerimeter() + " радиус:" + circle.getRadius());
                }
            }
        }
    }
}

