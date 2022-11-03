import Classes.*;
import Factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enum.FigureType;
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
                    break;
                case 2:
                    figure.add(createFigure(choice));
                    break;

                case 3:
                    printFigure(figure);
                    break;

                case 0:
                    isExit = true;
                    break;

            }
        }
    }

    public static PlaneFigure createFigure(int choice) throws Exception {
        PlaneFigure factory;
        switch (choice) {
            case 1:
                factory = Factory.createFigureType(FigureType.TRIANGLE);
                break;

            case 2:
                factory = Factory.createFigureType(FigureType.CIRCLE);
                break;

            default:
                throw new ClassNotFoundException();

        }
        ;
        return factory;


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
                if (fig instanceof Triangle fig1) {
                    System.out.println("Треугольник: " + fig1.getName() + " количество углов: " + fig1.countOfAngles()
                            + " периметр:" + fig1.getPerimeter() + " тип: " + fig1.getType());

                } else if (fig instanceof Circle fig2) {
                    System.out.println("Окружность: " + fig2.getName() + " Количество углов:" + fig2.countOfAngles()
                            + " периметр " + fig2.getPerimeter() + " радиус:" + fig2.getRadius());
                }
            }
        }
    }
}

