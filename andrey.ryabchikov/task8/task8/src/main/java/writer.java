import java.util.Iterator;
import java.util.List;

public class writer extends Thread {
    private final List<String> poem;
    private final StringBuffer napkin;

    public writer(List<String> poem, StringBuffer napkin) {

        this.poem = poem;
        this.napkin = napkin;

    }

    public void run() {

        for (String let : this.poem) {
            synchronized (this.napkin) {

                this.napkin.append(let);

            }

            try {

                sleep((long) (Math.random() * 91.0) + 10L);

            } catch (InterruptedException var5) {

                throw new RuntimeException(var5);

            }
        }

    }
}
