import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Helper {

    static List<CoffeeType> readFromFile() throws FileNotFoundException {
        File file = new File("/Users/mac/IdeaProjects/group-9/mark.makarenko/lab4/src/file1.txt");
        List<CoffeeType> result = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < Info.getOverall(); i++) {
                String line1 = br.readLine();
                String line2 = br.readLine();
                String line3 = br.readLine();
                String line4 = br.readLine();
                String line5 = br.readLine();
                result.add(new CoffeeType(line1, line2, line3, line4, Integer.parseInt(line5)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

