package bitmanipulation.array;

public class LeetCode_260 {

  public int[] singleNumber(int[] nums) {
    int diffValue = 0;
    for (int num : nums) {
      diffValue ^= num;
    }
    diffValue = diffValue & ~ (diffValue - 1);
    int [] distinctNum = new int[2];

    for (int num : nums) {
      if ((num & diffValue) == 0) {
        distinctNum[0] ^= num;
      } else {
        distinctNum[1] ^= num;
      }
    }
    return distinctNum;
  }

}
