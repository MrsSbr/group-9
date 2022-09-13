import java.util.*;

public class Main {
    static  int findMax(int first,int second){
        if(first>second)
            return  first;
        return second;
    }
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return findMaximumProfit(0,1,prices,dp);
    }
    static int findMaximumProfit( int i, int k,
                                  int[] prices, int[][] dp)
    {
        if(i == prices.length) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int profit = 0;
        if(k == 1){
            int buy = findMaximumProfit(i+1,0,prices,dp)-prices[i];
            int notBuy = findMaximumProfit(i+1,1,prices,dp);
            profit = findMax(buy,notBuy);
        } else if(k == 0) {
            int sell = prices[i] + findMaximumProfit(i+1,1,prices,dp);
            int notSell = findMaximumProfit(i+1,0,prices,dp);
            profit = findMax(sell, notSell);
        }
        return dp[i][k] = profit;
    }
    public static void main(String[] args)
    {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }
}