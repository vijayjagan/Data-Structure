package dynamicprogramming.strings.patternmatching;

public class DecodeWays {

  /**
   * Below Problem, it's similar to Unique Paths (LeetCode 62). In which way its is similar to
   * UniquePath sum In Unique Path target is to move from 0,0 index to m X n index , Once we reach
   * the last row and column we count the numberOf Ways to 1. Similar once we decoded the string at
   * the end we count the number of ways to 1
   * <p>
   * <p>
   * In Each Pointer we have two scenario either we can pick single element or else we can pick
   * multiple element(2 in our case) There is no constraint for single element reason is single
   * element range from 0-9 For two element base case is different two element range from 10-99. In
   * our case it's should range from 10-26. So element greater than 26 need to be stopped
   * #BaseCase.
   *
   *
   * EX - 117
   *
   * Possible SplitUp
   *  - (1)(17)
   *  - (11)(7)
   *  - (1)(1)(7)
   *
   *  Recursion Tree -
   *                      117
   *
   *                 1                11
   *
   *          1          17*        7*      X
   *
   *      7*    X       X    X     X           X
   *
   *      In Above Recursion Tree , See the path  of successive one denoted as *
   *      1 1 7*
   *      1 17*
   *      11 7*
   *
   *      total Way is three
   */

  public static int numDecodings(String s) {
    return s.length() == 0 ? 0 : numDecodings(0, s);
  }

  private static int numDecodings(int p, String s) {
    int n = s.length();
    // we decode the all the strings hence we return 1 same as unique path sum we reached the destination.
    // we can't able to add initially 1 and then call the subProblem via recursion like this 1 + numDecodings(P+1, S)
    // The reason is entire string is need to be valid. we are not allowed to break the strings here.
    // If we initially add 1 in future string may or may not be valid
    // Counter Example: 1001.
    // If we add initially 1 and then call the SubProblem(like this 1 + numDecodings(P+1, S)).Output will be 2 But expected output is 0
    // Henceforth, we return 1 at the end of string this means we successfully passed all the condition that we introduced.
    if (p == n) {
      return 1;
    }
    if (s.charAt(p) == '0') {
      return 0;
    }
    int res = numDecodings(p + 1, s);
    if (p < n - 1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7')) {
      res += numDecodings(p + 2, s);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("117"));
  }
}
