package bitmanipulation.integer;

public class LeetCode_868 {

  public int binaryGap(int n) {
    int globalMax = -1;
    int count = 0;
    int setBitCount = 0;

    while (n != 0) {
      if ((n & 1) != 0) {
        setBitCount++;
        count = 1;
      } else if (count != 0) {
        count++;
      }
      globalMax = Math.max(globalMax, count);
      n >>= 1;
    }
    return setBitCount > 1 ? globalMax : 0;
  }

}
