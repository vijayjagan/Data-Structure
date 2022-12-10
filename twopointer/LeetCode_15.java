package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_15 {


  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> threeSumList = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int a = nums[i];
        int left = i + 1;
        int right = n - 1;

        while (left < right && right < n && left > -1) {
          int b = nums[left];
          int c = nums[right];
          if (b + c == -a) {
            threeSumList.add(new ArrayList<>(Arrays.asList(a, b, c)));
             while (nums[left--] == b && left < n) {

            }
            while (nums[right--] == c && right > 0) {

            }
          } else {
            if (b + c < -a) {
              left++;
            } else {
              right--;
            }
          }
        }
      }
    }
    return threeSumList;
  }


  public static void main(String[] args) {
    int[] nums = {1, -1, -1, 0};
    System.out.println(threeSum(nums));
  }

}
