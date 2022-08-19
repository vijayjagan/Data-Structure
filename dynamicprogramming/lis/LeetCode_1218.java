package dynamicprogramming.lis;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1218 {


  static int longestSubsequence(int index, int lastIndex, int diff, int[] arr,
      Map<String, Integer> cacheMap) {

    if (index == arr.length) {
      return 0;
    }

    if (cacheMap.containsKey(index + "->" + lastIndex)) {
      return cacheMap.get(index + "->" + lastIndex);
    }

    int pickElement = 0;
    if (lastIndex == -1 || arr[lastIndex] == arr[index] - diff) {
      pickElement = 1 + longestSubsequence(index + 1, index, diff, arr, cacheMap);
    }
    int notPickElement = longestSubsequence(index + 1, lastIndex, diff, arr, cacheMap);

    cacheMap.put(index + "->" + lastIndex, Math.max(pickElement, notPickElement));
    return Math.max(pickElement, notPickElement);
  }


  /**
   * Intuition Consider Below Example Arr = {1,3,5,7,9} Diff = 2
   * <p>
   * Every Time value is decreased by the difference it denotes previous segment which is already
   * present in the array. InCase if it is not present in the array, consider that one has new
   * Possibility. How this works ?
   * <p>
   * Here is a DRY RUN Iterating the above array
   * <p>
   * 1  -> Map{1, 1  - 2 (which is not present in the map else returns 0)  0 + 1} 1 -> 1
   * 3  -> Map{1, 3 - 2 (3-2=1)  1 + 1}  3 -> 2
   * 5  -> Map{1, 5 - 2 (5-2=3)  1 + 1}  5 -> 3
   *
   * same goes for 5 and 9
   *
   * In terms of Array Caching
   * cache[i] =  cache[array[i] - diff] + 1;
   *
   *
   * Idea :-
   * The problem is similar to LIS (The Longest Increasing Subsequence) with extra condition
   * which is difference
   *
   * The extra condition in terms of code  (Refer Above Method)
   * arr[lastIndex] == arr[index] - diff
   *
   * lastIndex in the cache array stores how many count it holds the data in the last element
   *
   * same idea if we found the last element in the map get the value and add + 1 or else consider
   * this is the new possibility and store the possibility
   *
   */
  public static int longestSubsequence(int[] arr, int difference) {
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : arr) {
      int prevCount = 1 + count.getOrDefault(a - difference, 0);
      count.put(a, prevCount);
      ans = Math.max(ans, count.get(a));
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] arr = {7, 5, 3, 2, 1};
    System.out.println(longestSubsequence(arr, -2));
  }
}
