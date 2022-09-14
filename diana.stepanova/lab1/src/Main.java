public class Main {
    public static void main(String[] args) {
        CheсkingNumForFullSquare num = new CheсkingNumForFullSquare();
        System.out.println("Проверка числа на полный квадрат!");
        num.createValue();
        boolean result = num.returnsFullSquare();
        System.out.println(result);
    }
}
