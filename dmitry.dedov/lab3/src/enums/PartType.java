package enums;

public enum PartType {

    BOLT("Bolt"),
    PIPE("Pipe"),
    BEARING("Bearing"),
    SPRING("Spring");

    private final String typeOfPart;

    PartType(String typeOfPart) { this.typeOfPart = typeOfPart; }

    @Override
    public String toString() { return typeOfPart; }

}