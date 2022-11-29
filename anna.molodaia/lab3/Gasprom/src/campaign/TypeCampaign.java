package campaign;

import java.util.Random;

public enum TypeCampaign {
    SMS, MAIL, CALL, TV, RADIO;
    private static final TypeCampaign[] types = values();
    private static final Random PRNG = new Random();

    public static TypeCampaign randomTypeCampaign() {
        return types[PRNG.nextInt(types.length)];
    }
}
