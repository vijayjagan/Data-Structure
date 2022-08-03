package dynamicprogramming.grids;

import java.util.Arrays;

public class DungeonGame {

  /*
  *  Type of traversal : preorder
  *  Concept :-
  *  Ex ::
  *      1,  2
  *      6, -7
  *
  *   Cache or DP Array
  *
  *      0,0  *  0,1
  *      -----*-------
  *      1,0  *  1,1
  *           *
  *
  *   Consider above 2Dimensional Matrix is DP(cache or two state) which we are going to fill in a preorder traversal
  *   Since it's a preorder traversal we will end up hitting the last row and column in a matrix (In the above case
  *   last row and column is 1,1)
  *
  *   Last Row and Column aka where the prince is here. Value is -7 In order to survey in the column Positive 8HP
  *   is needed. If the value is negative simply multiply with - 1 and add +1 to the value. (-7 * -1) + 1 = 8
  *   Hence the last value #Base case is 8 for (1 x 1) matrix
  *
  *   Updated Cache or DP Array
  *
  *      0,0  *  0,1
  *      -----*-------
  *      1,0  *  8
  *           *
  *
  *   Now we are 0 x 1 From 0 x 1 we have two possibilities either we go down (which is already calculated) or else
  *   we go towards right side. In Our Case Right Side will lead us to OutOfBounds, so we need to ignore that value
  *   Yes, we found one more base case.Since it's a minimum we return max value in ignoring the base case
  *
  *   Minimum of down , Right = (8, Infinity) => 8. Here 8 Value Denotes the down Matrix (1 x 1)
  *   In order to Survey Current ( 0 x 1) Matrix and pass on the Resulted Value to the Next Matrix
  *
  *   8(this value will be required In order to Survey (1 x 1) matrix) = x + 2;
  *   x = 8 - 2 => 6;
  *   where x is the current survey value
  *
  *  Updated Cache or DP Array
  *
  *      0,0  *  6
  *      -----*-------
  *      1,0  *  8
  *           *
  *
  *    On next Step (1 x 0) matrix
  *    Math.min(value[2][0],value[1][1]) => (Infinity , 8) => 8
  *    8 = x + 6 -- > x = 8 - 6 = 2 which is filled Below
  *
  *      0,0  *  6
  *      -----*-------
  *       2   *  8
  *           *
  *    On next Step (0 x 0) matrix
  *    Math.min(value[1][0],value[0][1]) => (2 , 6) => 2
  *    2 = x + 1 -- > x = 2 - 1 = 1 which is filled Below
  *
  *       1   *  6
  *      -----*-------
  *       2   *  8
  *           *
  * */

  public static int calculateMinimumHP(int row, int column, int[][] dungeon, int[][] dp) {
    int n = dungeon.length;
    int m = dungeon[0].length;
    // Base case : we have crossed the matrix, ie. out of bound
    /// if current row crosses then my row is below the princess or
    /// if current column crosses then my column is ahead the column of princess
    /// and because we can go only down and right, so we won't be able to reach princess
    if (row == n || column == m) {
      return (int) Math.pow(10, 9);
    }

    if (dp[row][column] != -1) {
      return dp[row][column];
    }

    // In Order to Survey in Last cell Find the value ex:: If last cell Contain -5, 6 Is the Hp
    // For Negative Value -5 => (-5 * -1 )+ 1 = 6
    // For Positive Value 20 => minimum positive value of 1 is enough
    if (row == n - 1 && column == m - 1) {
      return dp[row] [column] =  (dungeon[row][column] <= 0) ? -dungeon[row][column] + 1 : 1;
    }

    /// now we must try all possible paths , we ask our right or down cell
    int IfWeGoRight = calculateMinimumHP(row, column + 1, dungeon, dp);
    int IfWeGoDown = calculateMinimumHP(row + 1, column, dungeon, dp);

    /// Based on the minimum value we need to decide which cell we to consider for the current cell
    // For eg : if Right value contains max value , current cell value will be based on downCell and current cell
    // For eg : if down value contains max value , current cell value will be based on RightCell and current cell
    // Reason for Subtracting if the current row and column is 1 x 1 on a 2 x 2 matrix
    // From 1 x 1 we have two possibilities either we can go right or else down
    // since this is Preorder traversal Right and down value are already calculated and stored in 2 dimensional DP array
    // Again In order to survey in right cell => *RightCell* = x + current[row][column]
    // *RightCell* - current[row][column] = x, this is what we're done in below
    int minHealthRequired = Math.min(IfWeGoRight, IfWeGoDown) - dungeon[row][column];

    /// If this is a powerUp cell aka value is positive minimum value of 1 is enougth in order to survey in this cell
    // and gain the powerup to perform next set of row either
    return dp[row][column] = (minHealthRequired <= 0) ? 1 : minHealthRequired;
  }


  public static int calculateMinimumHP(int[][] dungeon) {
    int[][] dp = new int[dungeon.length][dungeon[0].length];
    for (int[] value : dp) {
      Arrays.fill(value, -1);
    }
    int ming = calculateMinimumHP(0, 0, dungeon, dp);
    for (int[] ints : dp) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(ints[j] + " ");
      }
      System.out.println();
    }
    return ming;
  }

  public static void main(String[] args) {
    int[][] dungeon = {
        {1, 2},
        {6, -7}
    };
    System.out.println(calculateMinimumHP(dungeon));
  }
}
