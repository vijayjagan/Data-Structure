package dynamicprogramming.grids;

public class LeetCode174 {
    public static int calculateMinimumHP(int row, int column, int[][] dungeon, int[][] dp) {
        if (row == dungeon.length - 1 && column == dungeon[0].length - 1) {
            int rescueValue = dungeon[row][column];
            if (rescueValue > 0) {
                return 1;
            }
            return (rescueValue * -1) + 1;
        }

        if (row == dungeon.length || column == dungeon[0].length) {
            return (int) Math.pow(10, 9);
        }

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        int rescueValue = dungeon[row][column];
        int minHP = Math.min(
                calculateMinimumHP(row + 1, column, dungeon, dp),
                calculateMinimumHP(row, column + 1, dungeon, dp)
        );

        if (rescueValue > minHP) {
            return dp[row][column] = 1;
        }

        if (rescueValue < 0) {
            return dp[row][column] = minHP + (rescueValue * -1);
        }
        int abs = Math.abs(rescueValue - minHP);
        return dp[row][column] = abs == 0 ? 1 : abs;
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        return calculateMinimumHP(0, 0, dungeon, dp);
    }
}
