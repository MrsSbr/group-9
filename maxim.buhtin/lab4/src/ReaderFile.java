import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ReaderFile {
    //private static final String path = "maxim.buhtin/lab4/src/TestFile.txt";
    private static final Logger logger = Logger.getLogger(ReaderFile.class.getName());
    public Сhampionship readFile() {
        Сhampionship championship=new Сhampionship();
       try {
           File file = new File("C:\\Users\\GUA\\IdeaProjects\\group-9\\maxim.buhtin\\lab4\\TestFile.txt");
           FileReader fr=new FileReader(file);
           BufferedReader reader=new BufferedReader(fr);
           String match = reader.readLine();
           championship.parsingMatch(match);
           logger.log(Level.INFO,match);
            while (match != null) {
                match = reader.readLine();
                if(match!=null) {
                    championship.parsingMatch(match);
                    System.out.println(match);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка работы с файлом ", e);
        }
        return championship;
    }
}
