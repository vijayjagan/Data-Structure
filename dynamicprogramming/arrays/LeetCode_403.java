package dynamicprogramming.arrays;

import backtracking.LeetCode_40;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_403 {


  static int findStone(int sIndex, int value, int[] array) {
    for (int i = sIndex; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  static boolean canFrogCross(int index, int k, int[] stones, int length,
      Map<String, Boolean> cacheMap) {
    if (index == length - 1) {
      return true;
    }

    if (cacheMap.containsKey(index + "#" + k)) {
      return cacheMap.get(index + "#" + k);
    }

    boolean canJump = false;
    int[] possibleJumps = {k - 1, k, k + 1};
    for (int jumps : possibleJumps) {
      int nextJump = stones[index] + jumps;
      int nextIndex = findStone(index + 1, nextJump, stones);
      if (nextIndex != -1) {
        canJump = canJump || canFrogCross(nextIndex, jumps, stones, length, cacheMap);
      }
    }
    cacheMap.put(index + "#" + k, canJump);
    return canJump;
  }

  public boolean canCross(int[] stones) {
    Map<String, Boolean> cacheMap = new HashMap<>();
    return canFrogCross(0, 0, stones, stones.length, cacheMap);
  }
  

  public static void main(String[] args) {
    int[] stones = {0, 2};
    System.out.println(new LeetCode_403().canCross(stones));
  }

}
