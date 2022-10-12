import Classes.*;
import Interfaces.Creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PlaneFigure> figure=new ArrayList<>();
        boolean isExit = false;
        Scanner input=new Scanner(System.in);
        while(!isExit){
            System.out.println("-Выберите пункт меню-\n" +
                    "[1]Треугольник\n"+
                    "[2]Круг\n"+
                    "[3]вывести информацию\n"+
                    "[0]выход");
            int choice = input.nextInt();
            switch (choice){
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
                    isExit=true;
            }
        }
    }
    public static PlaneFigure createFigure(int choice){
        if(choice==1){
            Creator creator=new CreateTriangle();
            return creator.createFigure();
        }
        else if(choice==2){
            Creator creator=new CreateCircle();
            return creator.createFigure();
        }
        else{
            System.out.println("нет такого класса\n");
            return null;
        }
    }
    public static void printFigure(List<PlaneFigure> figures){
        boolean isExit = false;
        Scanner input=new Scanner(System.in);
        while (!isExit) {
            System.out.println("Выберите объект:\n[0] Выход.");
            for(int i=0; i<figures.size();i++){
                System.out.println("[" + (i + 1) + "] " +figures.get(i).getName());
            }
            int choice=input.nextInt();
            PlaneFigure fig;
            if(choice==0){
                isExit=true;
            }
            else{
                fig=figures.get(choice-1);
                if(fig instanceof Triangle){
                    Triangle triangle =(Triangle) fig;
                    System.out.println("Треугольник: "+ triangle.getName()+" количество углов: "+ triangle.countOfAngles()+" периметр:"+triangle.getPerimeter()+" тип: "+triangle.getType());

                }
                else if(fig instanceof Circle){
                    Circle circle=(Circle)  fig;
                    System.out.println("Окружность: "+circle.getName()+" Количество углов:"+circle.countOfAngles()+" периметр "+circle.getPerimeter()+" радиус:"+circle.getRadius());
                }
            }
        }
    }
}

