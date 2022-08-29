package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_22 {

  List<String> possibleCombination = new ArrayList<>();

  void generateParenthesis(int n, int open, int close, String s) {
    if (s.length() ==  2 * n) {
      possibleCombination.add(s);
      return;
    }


    if (close + 1 <= open) {
      String newString = s + ")";
      generateParenthesis(n, open, close + 1, newString);
    }

    // 0 Base Indexing
    if (open < n) {
      String newString = s + "(";
      generateParenthesis(n, open + 1, close, newString);
    }
  }


  public List<String> generateParenthesis(int n) {
    generateParenthesis(n, 0, 0, "");
    return possibleCombination;
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode_22().generateParenthesis(8));
  }
}
