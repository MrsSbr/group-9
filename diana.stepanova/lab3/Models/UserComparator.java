package Models;
import Models.User;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1.Number==o2.Number)
            return 0;
        if (o1.Number==null)
            return -1;
        if(o2.Number==null)
            return 1;
        return o1.Number.compareTo(o2.Number);
    }
}
