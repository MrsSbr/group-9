package Interfaces;
import сlass.KitchenApliance;


public interface Factory {
    KitchenApliance createApliance();

    static boolean intToBool(int n){// TODO: 12.10.2022 сделаать приватным в том месте, где используется
        if(n<0 || n>1){
            throw new IllegalArgumentException("Неверное число");
        }
        return n==1;
    }
}
