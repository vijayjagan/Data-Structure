package bitmanipulation.array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_90 {


  public List<List<Integer>> subsetsWithDup(int[] nums) {

    List<List<Integer>> subsetsWithDup = new ArrayList<>();
    for (int i = 0; i < (1 << nums.length) ; i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0; j < nums.length ; j++) {
        if ((i & (1 << j)) != 0) {
          subset.add(nums[j]);
        }
      }
      subsetsWithDup.add(subset);
    }
    return subsetsWithDup;
  }

}
