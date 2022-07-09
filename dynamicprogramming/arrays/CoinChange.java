package dynamicprogramming.arrays;

public class CoinChange {
    static int coinChange(int[] coins, int index, int target, Integer[][]dp) {
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            }
            return 99999;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        int edukathae = coinChange(coins, index - 1, target, dp);
        int edu = 99999;
        if (target >= coins[index]) {
            edu = 1 + coinChange(coins, index, target - coins[index], dp);
        }
        return dp[index][target] = Math.min(edukathae, edu);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = 99999;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int edukathae = dp[i - 1][j];
                int edu = 99999;
                if (j >= coins[i]) {
                    edu = 1 + dp[i][ j - coins[i]];
                }
                dp[i][j] = Math.min(edukathae, edu);
            }
        }
        return dp[coins.length- 1][amount]  == 0 ? -1 :  dp[coins.length- 1][amount] ;
    }
}
