package backtracking;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode_46 {

  List<List<Integer>> list;

  void fillThePermutation(int[] nums, List<Integer> localList, Set<Integer> visitedIndex) {
    if (localList.size() == nums.length) {
      list.add(new ArrayList<>(localList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visitedIndex.contains(i)) {
        continue;
      }
      localList.add(nums[i]);
      visitedIndex.add(i);
      fillThePermutation(nums, localList, visitedIndex);
      localList.remove(localList.size() - 1);
      visitedIndex.remove(i);
    }
  }


  void fillThePermutation(int index, List<Integer> localList) {
    if (index == localList.size()) {
      list.add(new ArrayList<>(localList));
      return;
    }

    for (int i = index; i < localList.size(); i++) {
      Collections.swap(localList, index, i);
      fillThePermutation(index + 1, localList);
      Collections.swap(localList, i, index);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    list = new ArrayList<>();
    List<Integer> arrayList = new ArrayList<>();
    for (int value : nums) {
      arrayList.add(value);
    }
    fillThePermutation(0, arrayList);
    return list;
  }

  public static void main(String[] args) {
    new LeetCode_46().permute(new int[]{1, 2, 3});
  }
}
