package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_282 {

  List<String> ans = new ArrayList<>();
  String s;
  int target;

  public List<String> addOperators(String s, int target) {
    this.s = s;
    this.target = target;
    backtrack(0, "", 0, 0);
    System.out.println(ans);
    return ans;
  }

  void backtrack(int index, String path, long resSoFar, long prevNum) {
    if (index == s.length()) {
      ans.add(path);
//      if (resSoFar == target) {
//
//      }
      return;
    }

    for (int i = index; i < s.length(); i++) {
      if (i > index && s.charAt(index) == '0') {
        break;
      }
      long num = Long.parseLong(s.substring(index, i + 1));
      if (index == 0) {
        backtrack(i + 1, path + num, num, num); // First num, pick it without adding any operator!
      } else {
        backtrack(i + 1, path + "+" + num, resSoFar + num, num);
        backtrack(i + 1, path + "-" + num, resSoFar - num, -num);
        backtrack(i + 1, path + "*" + num, resSoFar - prevNum + prevNum * num,
            prevNum * num); // Can imagine with example: 1-2*3
      }
    }
  }

  public static void main(String[] args) {
    new LeetCode_282().addOperators("1234", 15);
  }

}
