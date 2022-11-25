package Models;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getNumber().equals(o2.getNumber())) {
            return 0;
        }
        if (o1.getNumber().equals(null)) {
            return -1;
        }
        if (o2.getNumber().equals(null)) {
            return 1;
        }
        return o1.getNumber().compareTo(o2.getNumber());
    }
}
