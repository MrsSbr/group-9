package Models;

public class Cake {
    // private Menu kindOfCake;
    private String name;
    private double weightG;
    //private double costForCake;

    public Cake(String name) {
        this.name = name;
        // this.costForCake = 0;
        this.weightG = 0;
        // this.kindOfCake = kindOfCake;
    }

    public double getWeightG() {
        return weightG;
    }

    public void setWeightG(double weightG) {
        this.weightG = weightG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public double getCostForCake() {
//        return costForCake;
//    }
//
//    public void setCostForCake(double costForCake) {
//        this.costForCake = costForCake;
//    }
}
