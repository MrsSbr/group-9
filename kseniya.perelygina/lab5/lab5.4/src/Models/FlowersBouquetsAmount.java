package Models;

public class FlowersBouquetsAmount {

    private int flowers;
    private int bouquets;

    public FlowersBouquetsAmount() {

        flowers = 0;
        bouquets = 0;

    }

    public int getFlowers() {
        return flowers;
    }

    public int getBouquets() {
        return bouquets;
    }

    public void addBouquet(int flowersAmount) {

        bouquets++;
        flowers += flowersAmount;

    }

    public double countAverage(){

        return bouquets == 0? (double)0 : (double)flowers / bouquets;

    }
}
