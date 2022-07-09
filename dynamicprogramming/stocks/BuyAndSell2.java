package dynamicprogramming.stocks;

import java.util.Arrays;

public class BuyAndSell2 {

  public static int maxProfit(int[] prices, int index, int canBuy, int[][] dp) {

    if (index == prices.length) {
      return 0;
    }

    if (dp[index][canBuy] != -1) {
      return dp[index][canBuy];
    }
    int profit;

    if (canBuy == 1) {
      profit = Math.max(-prices[index] + maxProfit(prices, index + 1, 0, dp),
          maxProfit(prices, index + 1, canBuy, dp));
    } else {
      profit = Math.max(prices[index] + maxProfit(prices, index + 1, 1, dp),
          maxProfit(prices, index + 1, 0, dp));
    }
    return dp[index][canBuy] = profit;
  }

  public static int maxProfitTabulation(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int i = prices.length - 2; i >= 0; i--) {
      for (int canBuy = 1; canBuy <= 2; canBuy++) {
        if (canBuy == 1) {
          dp[i][canBuy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][canBuy]);
        } else {
          dp[i][canBuy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }
      }
    }
    return dp[0][0];
  }

  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int[] value : dp) {
      Arrays.fill(value, -1);
    }
    return maxProfit(prices, 0, 1, dp);
  }

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    System.out.println(maxProfitTabulation(prices));
  }

}
