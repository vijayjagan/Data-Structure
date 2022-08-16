package dynamicprogramming.frontpartition;

public class LeetCode_1043 {


  static int maxSum(int[] arr, int left, int k, int[] cache) {
    if (left == arr.length) {
      return 0;
    }
    if (cache[left] != -1) {
      return cache[left];
    }
    int length = 0;
    int max = Integer.MIN_VALUE;
    int maxSum = Integer.MIN_VALUE;
    for (int i = left; i < Math.min(arr.length, left + k); i++) {
      length++;
      max = Math.max(arr[i], max);
      int sum = (length * max) + maxSum(arr, i + 1, k, cache);
      maxSum = Math.max(maxSum, sum);
    }
    return cache[left] = maxSum;
  }

  public static int maxSumAfterPartitioning(int[] arr, int k) {
    int[] cache = new int[arr.length + 1];
    for (int left = arr.length - 1; left > -1; left--) {
      int length = 0;
      int max = Integer.MIN_VALUE;
      int maxSum = Integer.MIN_VALUE;
      for (int i = left; i < Math.min(arr.length, left + k); i++) {
        length++;
        max = Math.max(arr[i], max);
        int sum = (length * max) + cache[ i + 1];
        maxSum = Math.max(maxSum, sum);
      }
      cache[left] = maxSum;
    }
    return cache[0];
  }

  public static void main(String[] args) {
    int[] n = {1,4,1,5,7,3,6,1,9,9,3};
    System.out.println(maxSumAfterPartitioning(n, 4));
  }
}
