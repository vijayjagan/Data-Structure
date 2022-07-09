package dynamicprogramming.grids;

public class CherryPick2 {
    static int cherryPickUp(int row, int column1, int column2, int[][] grid, int[][][] dp) {
        if (column1 < 0 || column2 < 0 || column2 >= grid[0].length || column1 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }
        if (row == grid.length - 1) {
            if (column1 == column2) {
                return grid[row][column1];
            }
            return grid[row][column1] + grid[row][column2];
        }

        if (dp[row][column1][column2] != 0) {
            return dp[row][column1][column2];
        }
        int result = 0;
        for (int i = -1; i <=1 ; i++) {
            for (int j = -1; j<=1; j++) {
                if (column1 == column2) {
                    result = Math.max(grid[row][column1]
                            + cherryPickUp(row + 1, column1 + i, column2 + j, grid, dp) , result);
                } else {
                    result =  Math.max(grid[row][column1]  + grid[row][column2]
                            + cherryPickUp(row + 1, column1 + i, column2 + j, grid, dp) , result);
                }
            }
        }
        return  dp[row][column1][column2] =  result;
    }

    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int column1 = 0; column1 < grid[0].length; column1++) {
            for (int column2 = 0; column2 < grid[0].length; column2++) {
                if (column1 == column2) {
                    dp[grid.length - 1][column1][column2] = grid[grid.length - 1][column1];
                } else {
                    dp[grid.length - 1][column1][column2] = grid[grid.length - 1][column1] + grid[grid.length - 1][column2];
                }
            }
        }

        for (int row = grid.length - 2; row >= 0; row--) {
            for (int column1 = 0; column1 < grid[0].length; column1++) {
                for (int column2 = 0; column2 < grid[0].length; column2++) {
                    int result = Integer.MIN_VALUE;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int currentState ;
                            if (column1 == column2) {
                                currentState = grid[row][column1];
                            } else {
                                currentState = grid[row][column1] + grid[row][column2];
                            }
                            if (column1 + i < 0 || column2 + j < 0 || column2 + j >= grid[0].length || column1 + i >= grid[0].length) {
                                currentState +=  -9999999;
                            } else {
                                currentState += dp[row + 1][column1 + i][column2 + j];
                            }
                            result = Math.max(currentState, result);
                        }
                    }
                    dp[row][column1][column2] = result;
                }
            }
        }
        return  dp[0][0][grid.length - 1];
    }

}
