import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final File Pushkin = new File("src/Data/Pushkin.txt");
    private static final File Esenin = new File("src/Data/Esenin.txt");
    private static final File Shnur = new File("src/Data/Shnur.txt");
    private static final File Cvetaeva = new File("src/Data/Cvetaeva.txt");

    public static void main(String[] args) throws InterruptedException {
        StringBuffer napkin = new StringBuffer();
        List<List<String>> poems = new ArrayList<>();

        poems.add(readFile(Pushkin));
        poems.add(readFile(Esenin));
        poems.add(readFile(Shnur));
        poems.add(readFile(Cvetaeva));


        List<writer> writers = new ArrayList<>();
        for (int i = 0; i < 4; i++){

            writers.add(new writer(poems.get(i),napkin));
            writers.get(i).start();
        }
        for (int i = 0; i < 4; i++){

            writers.get(i).join();
        }

        System.out.println(napkin);

    }

    public static List<String> readFile(File FILE) {

        List<String> result = new ArrayList<>();

        try (FileReader fr = new FileReader(FILE); BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();

            while (line != null) {

                result.add(line);
                line = reader.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

}