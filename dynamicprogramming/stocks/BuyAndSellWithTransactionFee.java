package dynamicprogramming.stocks;

import java.util.Arrays;

public class BuyAndSellWithTransactionFee {

  public static int maxProfit(int[] prices, int fee, int index, int canBuy, int[][] dp) {
    if (index >= prices.length) {
      return 0;
    }
    if (dp[index][canBuy] != -1) {
      return dp[index][canBuy];
    }
    int profit;

    if (canBuy == 1) {
      profit = Math.max(-prices[index] + maxProfit(prices, fee, index + 1, 0, dp),
          maxProfit(prices, fee, index + 1, canBuy, dp));
    } else {
      profit = Math.max(prices[index] + maxProfit(prices, fee, index + 1, 1, dp) - fee,
          maxProfit(prices, fee, index + 1, 0, dp));
    }
    return dp[index][canBuy] = profit;
  }



  public int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length][2];
    for (int[] value : dp) {
      Arrays.fill(value, -1);
    }
    return maxProfit(prices, fee, 0, 1, dp);
  }

}
