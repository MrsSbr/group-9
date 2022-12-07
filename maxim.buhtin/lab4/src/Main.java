public class Main {
    public static void main(String[] args) {
        Сhampionship championship = new Сhampionship();
        ReaderFile readerFile = new ReaderFile();
        championship=readerFile.readFile();
        championship.printHashMap();
    }
}