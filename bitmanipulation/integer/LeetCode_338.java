package bitmanipulation.integer;

public class LeetCode_338 {

  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    result[0] = 0;
    for (int i = 1; i <= n; i++) {
      int temp = i;
      int count = 0;
      while (temp != 0) {
        count += temp & 1;
        temp >>= 1;
      }
      result[i] = count;
    }
    return result;
  }

}
