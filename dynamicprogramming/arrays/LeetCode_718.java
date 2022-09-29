package dynamicprogramming.arrays;

public class LeetCode_718 {

  int globalMax = 0;

  int findMaxLength(int n1Index, int n2Index, int[] nums1, int[] nums2, Integer[][] cache) {
    if (n1Index == nums1.length || n2Index == nums2.length) {
      return 0;
    }

    int localMax = 0;

    if (cache[n1Index][n2Index] != null) {
      return cache[n1Index][n2Index];
    }

    if (nums1[n1Index] == nums2[n2Index]) {
      localMax = 1 + findMaxLength(n1Index + 1, n2Index + 1, nums1, nums2, cache);
      globalMax = Math.max(globalMax, localMax);
    }

    findMaxLength(n1Index + 1, n2Index, nums1, nums2, cache);
    findMaxLength(n1Index, n2Index + 1, nums1, nums2, cache);

    return cache[n1Index][n2Index] = localMax;
  }


  public int findLength(int[] nums1, int[] nums2) {
    Integer[][] cache = new Integer[nums1.length][nums2.length];
    findMaxLength(0, 0, nums1, nums2, cache);
    return globalMax;
  }

  public static void main(String[] args) {
    int[] nums1 = {0, 1, 1, 1, 1};
    int[] nums2 = {1, 0, 1, 0, 1};
    System.out.println(new LeetCode_718().findLength(nums1, nums2));
  }

}
