package enums;

public enum GenreOfGame {

    ACTION_ADVENTURE("Action_Adventure"),
    RPG("RPG"),
    STEALTH_ACTION("Stealth_Action"),
    SURVIVAL_HORROR("Survival_Horror"),
    ACTION_RPG("Action_RPG"),
    CARD_RPG("Card_RPG"),
    SHOOTER("Shooter");

    private final String genreOfGame;

    GenreOfGame(String genreOfGame){ this.genreOfGame = genreOfGame; }

    @Override
    public String toString() { return genreOfGame; }

}