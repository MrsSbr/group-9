package factory.Interfaces;

import enums.DinosaurType;
import factory.Models.IchthyosauriaFactory;
import factory.Models.PterosauriaFactory;
import factory.Models.SaurischiaFactory;
import models.Dinosaur;

public interface DinosaurFactory {
    static DinosaurFactory createDinosaurFactoryByType(DinosaurType type) throws Exception {
        return switch (type) {
            case ICHTHYOSAURIA -> new IchthyosauriaFactory();
            case SAURISCHIA -> new SaurischiaFactory();
            case PTEROSAURIA -> new PterosauriaFactory();
            default -> throw new ClassNotFoundException("Класс переданного типа не существует.");
        };
    }

    Dinosaur createDinosaur();

}
