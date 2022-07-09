package dynamicprogramming.stocks;

import java.util.Arrays;

public class BuyAndSell3 {

  public static int maxProfit(int[] prices, int index, int canBuy, int limitation,
      Integer[][][] dp) {
    if (limitation == 0 || index == prices.length) {
      return 0;
    }
    int profit;
    if (dp[index][canBuy][limitation] != null) {
      return dp[index][canBuy][limitation];
    }

    if (canBuy == 1) {
      profit = Math.max(-prices[index] + maxProfit(prices, index + 1, 0, limitation, dp),
          maxProfit(prices, index + 1, canBuy, limitation, dp));
    } else {
      profit = Math.max(prices[index] + maxProfit(prices, index + 1, 1, limitation - 1, dp),
          maxProfit(prices, index + 1, canBuy, limitation, dp));
    }
    return dp[index][canBuy][limitation] = profit;
  }

  public static int maxProfitTabulation(int[] prices) {
    int[][][] dp = new int[prices.length + 1][2][3];
    for (int index = prices.length - 1; index >= 0; index--) {
      for (int canBuy = 0; canBuy <= 1; canBuy++) {
        for (int limitation = 1; limitation <= 2; limitation++) {
          // 0 - Buy
          // 1- sell The stocks
          if (canBuy == 0) {
            dp[index][canBuy][limitation] = Math.max(
                -prices[index] + dp[index + 1][1][limitation], dp[index + 1][0][limitation]);
          } else {
            dp[index][canBuy][limitation] = Math.max(
                prices[index] + dp[index + 1][0][limitation - 1],
                dp[index + 1][1][limitation]);
          }
        }
      }
    }
    return dp[0][0][2];
  }

  public static int maxProfit(int[] prices) {
    Integer[][][] dp = new Integer[prices.length][2][3];
    return maxProfit(prices, 0, 1, 2, dp);
  }

  public static void main(String[] args) {
    int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
    System.out.println(maxProfitTabulation(prices));
  }
}
