package dynamicprogramming.stocks;

public class BuyAndSell4 {


  public static int maxprofit(int k, int[] prices, int index, int transaction, Integer[][] dp) {
    if (index == prices.length || transaction == 2 * k) {
      return 0;
    }

    int profit;
    if (transaction % 2 == 0) {
      profit = Math.max(-prices[index] + maxprofit(k, prices, index + 1, transaction + 1, dp),
          maxprofit(k, prices, index + 1, transaction, dp));
    } else {
      profit = Math.max(prices[index] + maxprofit(k, prices, index + 1, transaction + 1, dp),
          maxprofit(k, prices, index + 1, transaction, dp));
    }
    return dp[index][transaction] = profit;
  }

  public static int maxProfit(int k, int[] prices) {
    int[][][] dp = new int[prices.length + 1][2][k + 1];
    for (int index = prices.length - 1; index >= 0; index--) {
      for (int canBuy = 0; canBuy <= 1; canBuy++) {
        for (int limitation = 1; limitation <= k; limitation++) {
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
    return dp[0][0][k - 1];
  }
}
