package greedy;

public class LeetCode_1221 {

  public int balancedStringSplit(String s) {
    int left = 0, right = 0, count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'L') {
        left ++;
      } else {
        right ++;
      }
      count += left == right ? 1 : 0;
    }
    return count;
  }

}
