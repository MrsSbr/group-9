package Models;

public class Bus extends Vehicle implements Interfaces.Bus {
    private int countOfTrips;

    Bus(String model, int power, int countOfTrips) {
        super(model, power);
        this.countOfTrips = countOfTrips;
    }
    public int getCountOfTrips(){
        return countOfTrips;
    }
    @Override
    public void makeTrip() {
        System.out.println("Trip is completed");
        countOfTrips++;
    }

    @Override
    public void driveTo(String place) {
        System.out.println("Bus is driving to " + place);
    }

}
