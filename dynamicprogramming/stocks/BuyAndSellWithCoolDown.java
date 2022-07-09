package dynamicprogramming.stocks;

import java.util.Arrays;

public class BuyAndSellWithCoolDown {

  public static int maxProfit(int[] prices, int index, int canBuy, int[][] dp) {
    if (index >= prices.length) {
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
      profit = Math.max(prices[index] + maxProfit(prices, index + 2, 1, dp),
          maxProfit(prices, index + 1, 0, dp));
    }
    return dp[index][canBuy] = profit;
  }

  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int[] value : dp) {
      Arrays.fill(value, -1);
    }
    return maxProfit(prices, 0, 1, dp);
  }

}
