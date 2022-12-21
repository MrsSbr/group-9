import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final File Pushkin = new File("src/Data/Pushkin.txt");
    private static final File Esenin = new File("src/Data/Esenin.txt");
    private static final File Shnur = new File("src/Data/Shnur.txt");
    private static final File Cvetaeva = new File("src/Data/Cvetaeva.txt");

    public static void main(String[] args) throws InterruptedException {
        StringBuilder napkin = new StringBuilder();

        List<Writer> writers = new ArrayList<>();

        writers.add(new Writer(readFile(Pushkin), napkin));
        writers.add(new Writer(readFile(Esenin), napkin));
        writers.add(new Writer(readFile(Shnur), napkin));
        writers.add(new Writer(readFile(Cvetaeva), napkin));

        for (int i = 0; i < 4; i++) {

            writers.get(i).start();

        }
        for (int i = 0; i < 4; i++) {

            writers.get(i).join();
        }

        System.out.println(napkin);

    }

    public static List<String> readFile(File FILE) {

        List<String> result = new ArrayList<>();

        try (FileReader fr = new FileReader(FILE);
             BufferedReader reader = new BufferedReader(fr)) {

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