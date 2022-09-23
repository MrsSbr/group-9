package Factory.Interfaces;

import Factory.Enum.DinosaurType;
import Factory.Models.IchthyosauriaFactory;
import Factory.Models.PterosauriaFactory;
import Factory.Models.SaurischiaFactory;
import Models.Dinosaur;

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
