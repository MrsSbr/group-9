import java.util.List;

public class writer extends Thread {
    private final List<String> poem;
    private final StringBuilder napkin;

    public writer(List<String> poem, StringBuilder napkin) {

        this.poem = poem;
        this.napkin = napkin;

    }

    public void run() {

        for (String let : poem) {
            synchronized (napkin) {

                napkin.append(let).append("\n");

            }

            try {

                sleep((long) (Math.random() * 91.0) + 10L);

            } catch (InterruptedException var5) {

                throw new RuntimeException(var5);

            }
        }

    }
}
