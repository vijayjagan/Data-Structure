package dynamicprogramming.arrays;

public class LeetCode_1223 {

  static int mod = (int) (Math.pow(10, 9) + 7);

  /*
     Intuition :
     Below sum is the combination sum. Idea is to Generate combination of n numbers
     and used to track the consecutive via params
   */

  static long diceSimulator(int prevValue, int length, int depth, int[] rollMax,
      Long[][][] cache) {
    if (depth == 0) {
      return 1;
    }

    if (cache[prevValue][length][depth] != null) {
      return cache[prevValue][length][depth] % mod;
    }

    long combination = 0;

    for (int i = 1; i <= 6; i++) {
      if (prevValue == i && rollMax[i - 1] == length) {
        continue;
      }
      int newLength = i == prevValue ? length + 1 : 1;
      combination += diceSimulator(i, newLength, depth - 1, rollMax, cache);
    }

    return cache[prevValue][length][depth] = combination % mod;
  }

  public static int dieSimulator(int n, int[] rollMax) {
    Long[][][] cache = new Long[16][16][n + 1];
    return (int) diceSimulator(0, 0, n, rollMax, cache);
  }

  public static void main(String[] args) {
    int[] rollMax = {8, 5, 10, 8, 7, 2};
    System.out.println(dieSimulator(20, rollMax));
  }

}
