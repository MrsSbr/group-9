import java.util.Objects;

public class Fox {
    private final String town;
    private final int amountRespondents;
    private final String sound;

    public Fox(String town, int amountRespondents, String sound) {
        this.town = town;
        this.amountRespondents = amountRespondents;
        this.sound = sound;
    }

    public String getTown() {
        return town;
    }

    public int getAmountRespondents() {
        return amountRespondents;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fox fox = (Fox) o;
        return amountRespondents == fox.amountRespondents && Objects.equals(town, fox.town) && Objects.equals(sound, fox.sound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, amountRespondents, sound);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "town='" + town + '\'' +
                ", amountRespondents='" + amountRespondents + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }
}
