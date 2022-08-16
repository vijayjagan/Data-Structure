package dynamicprogramming.knapsack;

public class MinimumSwap {

  /**
   * The Question may arise why not use if-else if, since if condition provides 0 zero swap, else
   * if provides 1 swap (1 + function call)
   *
   * Below is the counter example, trace the counter example with the recursion
   * Counter Example :- [0,4,4,5,9] [0,1,6,8,10]
   * <p>
   * Expected Answer is 1 , but the output is 2 Answer : shift index 1 on the Array it will be in
   * strictly increasing order
   */

  static int minimumSwap(int pointer, int num1Prev, int num2Prev, int[] A, int[] B,
      int swapStatus, Integer[][] cache) {

    if (pointer == A.length) {
      return 0;
    }

    if (cache[pointer][swapStatus] != null) {
      return cache[pointer][swapStatus];
    }

    int minSwap = Integer.MAX_VALUE;

    // Swap doesn't require since its already in increasing order
    // Without swap try all the possibility
    if (A[pointer] > num1Prev && B[pointer] > num2Prev) {
      minSwap = minimumSwap(pointer + 1, A[pointer], B[pointer], A, B, 0, cache);
    }

    // Check whether it is eligible for swap
    // If its is eligible for swap try all the possibilities
    if (A[pointer] > num2Prev && B[pointer] > num1Prev) {
      minSwap = Math.min(minSwap,
          1 + minimumSwap(pointer + 1, B[pointer], A[pointer], A, B, 1, cache));
    }
    return cache[pointer][swapStatus] = minSwap;
  }


  public int minSwap(int[] nums1, int[] nums2) {
    Integer[][] cache = new Integer[nums1.length][2];
    return minimumSwap(0, -1, -1, nums1, nums2, 0, cache);
  }
}
