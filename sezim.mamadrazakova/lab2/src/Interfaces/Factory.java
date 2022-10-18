package Interfaces;
import Enum.FigureType;
import Classes.CircleFactory;
import Classes.TriangleFactory;
import Classes.PlaneFigure;



public interface Factory {
    PlaneFigure createFigure();
    static Factory createFigureType(FigureType type) throws Exception{
        Factory factory;
        switch (type){
            case TRIANGLE:
                factory= new TriangleFactory();
                break;

            case CIRCLE:
               factory= new CircleFactory();
               break;

            default:
                throw new ClassNotFoundException("Класс переданного типа не существует.");



        };
        return factory;
    }

}
