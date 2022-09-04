package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_90 {

  List<List<Integer>> list;

  void subSet(int index, int[] nums, List<Integer> localList) {
    list.add(new ArrayList<>(localList));

    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i - 1] == nums[i]) {
        continue;
      }
      localList.add(nums[i]);
      subSet(i + 1, nums, localList);
      localList.remove(localList.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    list = new ArrayList<>();
    Arrays.sort(nums);
    subSet(0, nums, new ArrayList<>());
    return list;
  }

}
