import java.util.List;

public class writer extends Thread  {

    private final List<String> poem;
    private final StringBuffer  napkin;

    public writer(List<String> poem, StringBuffer napkin) {

        this.poem = poem;
        this.napkin = napkin;

    }

    @Override
    public void run() {

        for (String let: poem) {
            synchronized(napkin) {

                napkin.append(let);

            }
            try {
                sleep((long) (Math.random() * ((100 - 10) + 1)) + 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }


}
