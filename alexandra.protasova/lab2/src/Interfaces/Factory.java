package Interfaces;
import Class.KitchenApliance;


public interface Factory {
    KitchenApliance createApliance();
    static boolean intToBool(int n){
        if(n<0 || n>1){
            throw new IllegalArgumentException("Неверное число");
        }
        return n==1;
    }
}
