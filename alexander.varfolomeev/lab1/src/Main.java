import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static int coinChangeDynamicProg(int[] coins, int amount){
        if(amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++){
            if(coins[i] <= amount)
                dp[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++){
            if(dp[i] != Integer.MAX_VALUE)
            {
                for (int j  = 0; j < coins.length; j++){
                    if (coins[j] <= amount && i + coins[j] <= amount)
                        dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

    public static void menu(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Введите количество номиналов монет: ");
            int coinsCount = getIntInDiapason(1, 12);

            int[] coins = getCoins(coinsCount);

            System.out.println("Введите необходимую сумму: ");
            int amount = getIntInDiapason(0, 104); // Тут кажется опечатка в условии, иначе зачем нам монеты > 104?

            int result = coinChangeDynamicProg(coins, amount);
            if(result == -1)
                System.out.println("Данную сумму невозможно собрать монетами с таким номиналом.");
            else
                System.out.println("Минимально возможное количество монет для данной суммы: " + result);

            System.out.println("Выйти из программы? (1)");
            if(in.nextInt() == 1)
                break;
        }
    }

    public static int getInt(){
        Scanner in = new Scanner(System.in);
        int result;
        while(true)
        {
            try {
                result = Integer.parseInt(in.next());
                return result;
            } catch (Exception e){
                System.out.println("Некорректный ввод. Повторите.");
            }
        }
    }
    public static int getIntInDiapason(int start, int end){
        int result;
        while (true){
            result = getInt();
            if(!inDiapason(result, start, end))
                System.out.println("Число должно находится в диапазоне от " + start +  " до " + end);
            else
                break;
        }
        return result;
    }
    public static int[] getCoins(int length){
        System.out.println("Введите монеты: ");
        int[] result = new int[length];
        for (int i = 0; i < length; i++){
            while(true){
                result[i] = getInt();
                if(!inDiapason(result[i], 1, 230)){
                    System.out.println("Номинал монеты должен находится в диапазоне от 1 до 230");
                }
                else
                    break;
            }
        }
        return result;
    }
    public static boolean inDiapason(int num, int start, int end){
        return num >= start && num <= end;
    }
}
