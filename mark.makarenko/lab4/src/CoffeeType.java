public class CoffeeType {
    private final String type;
    private final String country;
    private final String farm;
    private final String processing;
    private final int growthHight;

    public CoffeeType(String type, String country, String farm, String processing, int growthHight) {
        this.type = type;
         this.country = country;
        this.farm = farm;
        this.processing = processing;
        this.growthHight = growthHight;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getFarm() {
        return farm;
    }

    public String getProcessing() {
        return processing;
    }

    public int getGrowthHight() {
        return growthHight;
    }

}

