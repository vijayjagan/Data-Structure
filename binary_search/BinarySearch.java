package binary_search;


import java.util.List;

public class BinarySearch {

  public static int binarySearch(int target, int[] nums) {
    int low = 0, up = nums.length;
    while (low < up) {
      int mid = (low + up) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        up = mid;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static int lowerBound(int target, int[] nums) {
    int low = 0, up = nums.length;
    while (low < up) {
      int mid = (low + up) / 2;
      if (target <= nums[mid]) {
        up = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static int upperBound(int target, int[] nums) {
    int low = 0, up = nums.length;
    while (low < up) {
      int mid = (low + up) / 2;
      if (target < nums[mid]) {
        up = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 23, 23, 23, 23, 23, 34, 35, 36, 37, 38, 44, 44, 53, 63};
    System.out.println(lowerBound(3, new int[]{1, 2, 3, 3}));
  }
}
