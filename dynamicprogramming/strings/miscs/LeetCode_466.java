package dynamicprogramming.strings.miscs;

public class LeetCode_466 {

  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int l1 = s1.length(), l2 = s2.length();
    int[] offsets = new int[l2 + 1], reps = new int[l2 + 1];
    int lo = -1, hi = 0, cnt = 0;

    for (int i = 1, offset = 0; i <= l2 && i <= n1; ++i) {
      for (int j = 0; j < l1; ++j) {
        if (s1.charAt(j) != s2.charAt(offset)) {
          continue;
        }
        offset++;
        if (offset == l2) {
          offset = 0;
          cnt++;
        }
      }
      
      for (int j = 0; j < i; ++j) {
        if (offset == offsets[j]) {
          lo = j; // cycle found [lo, hi)
          hi = i;
          break;
        }
      }

      if (lo >= 0) {
        break;
      }
      offsets[i] = offset;
      reps[i] = cnt;
    }

    if (lo < 0) {
      return cnt / n2;
    }
    return ((n1 - lo) / (hi - lo) * (cnt - reps[lo]) + reps[lo + (n1 - lo) % (hi - lo)]) / n2;
  }

  public static void main(String[] args) {
    String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    int n1 = 1000000;
    String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    int n2 = 1000000;
    int max = new LeetCode_466().getMaxRepetitions(s1, n1, s2, n2);
    System.out.println(max);
  }

}
