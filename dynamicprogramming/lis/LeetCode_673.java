package dynamicprogramming.lis;

import java.util.Arrays;

public class LeetCode_673 {

  public static int findNumberOfLIS(int[] nums) {
    int[] indexLISCount = new int[nums.length];
    Arrays.fill(indexLISCount, 1);
    int[] countTracker = new int[nums.length];
    Arrays.fill(countTracker, 1);
    int max = -1;


    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if ( indexLISCount[i] < indexLISCount[j] + 1) {
            indexLISCount[i] = indexLISCount[j] + 1;
            countTracker[i] = countTracker[j];
          } else if (indexLISCount[i] == indexLISCount[j] + 1) {
            countTracker[i] += countTracker[j];
          }
        }
      }
    }


    for (int value : indexLISCount) {
      max = Math.max(value, max);
    }

    int result = 0;
    for (int i = 0; i < indexLISCount.length; i++) {
      if (indexLISCount[i] == max) {
        result += countTracker[i];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findNumberOfLIS(new int[] {100,90,80,70,60,50,60,70,80,90,100}));
  }
}
