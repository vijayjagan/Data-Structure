package bitmanipulation.integer;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1863 {

  public int subsetXORSum(int[] nums) {

    int totalSum = 0;

    for (int i = 0; i < 1 << nums.length; i++) {
      int sum = 0;
      int value = i;
      int count = 0;
      while (value != 0) {
        if ((value & 1) != 0) {
          sum ^= nums[count];
        }
        count++;
        value >>= 1;
      }
      totalSum += sum;
    }
    return totalSum;
  }


  public static void main(String[] args) {
    System.out.println(new LeetCode_1863().subsetXORSum(new int[]{5, 1, 6}));

  }

}
