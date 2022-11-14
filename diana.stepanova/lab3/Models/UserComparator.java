package Models;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.number.equals(o2.number))
            return 0;
        if (o1.number.equals(null))
            return -1;
        if (o2.number.equals(null))
            return 1;
        return o1.number.compareTo(o2.number);
    }
}
