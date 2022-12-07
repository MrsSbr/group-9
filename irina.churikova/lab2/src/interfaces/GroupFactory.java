package interfaces;

import enums.GroupTypes;
import models.GroupOfStudent;
import models.Department;
import models.Group;

public interface GroupFactory {
    static GroupFactory createGroupFactoryType(GroupTypes type) throws Exception {
        return switch (type) {
            case STUDENTS-> new GroupOfStudent();
            case TEACHERS -> new Department();
            default -> throw new ClassNotFoundException("Класс переданного типа не существует.");
        };
    }

}
