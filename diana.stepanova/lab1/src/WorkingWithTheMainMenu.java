public class WorkingWithTheMainMenu {
    public static void Menu() {
        cheсkingNumForFullSquare num = new cheсkingNumForFullSquare();
        System.out.println("Проверка числа на полный квадрат!");
        num.createValue();
        boolean result = num.returnsFullSquare();
        System.out.println(result);

    }
}

