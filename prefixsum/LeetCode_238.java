package prefixsum;

public class LeetCode_238 {

  public static int[] productExceptSelf(int[] nums) {
    int totalProduct = 1;
    boolean containMultipleZeros = false;
    boolean containSingleZeros = false;

    for (int value : nums) {
      if (value != 0) {
        totalProduct *= value;
      }
    }
    int count = 0;
    for (int value : nums) {
      if (value == 0) {
        count++;
      }
    }
    containMultipleZeros = count > 1;
    containSingleZeros = count == 1;

    for (int i = 0; i < nums.length; i++) {
      if (containMultipleZeros) {
        nums[i] = 0;
      } else {
        if (nums[i] == 0 && containSingleZeros) {
          nums[i] = totalProduct;
        } else {
          if (containSingleZeros) {
            nums[i] = 0;
          } else {
            nums[i] = totalProduct / nums[i];
          }
        }
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int nums[] = {-1,1,0,-3,3};
    System.out.println(productExceptSelf(nums));
  }
}
