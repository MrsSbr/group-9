package models;

import enums.PartType;

import java.time.LocalDate;
import java.util.Objects;

public class Part {

    private final PartType typeOfPart;

    private final LocalDate dateOfManufacture;

    public Part(PartType typeOfPart, LocalDate dateOfManufacture) {

        this.typeOfPart = typeOfPart;
        this.dateOfManufacture = dateOfManufacture;

    }

    public PartType getTypeOfPart() { return typeOfPart; }

    public LocalDate getDateOfManufacture() { return dateOfManufacture; }

    @Override
    public String toString() {

        return "typeOfPart: " + typeOfPart +
                " dateOfManufacture: " + dateOfManufacture;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;

        }

        if (obj == null || getClass() != obj.getClass()) {

            return false;

        }

        Part part = (Part) obj;
        return typeOfPart.equals(part.typeOfPart) &&
                dateOfManufacture.equals(part.dateOfManufacture);

    }

    @Override
    public int hashCode() { return Objects.hash(typeOfPart, dateOfManufacture); }

}