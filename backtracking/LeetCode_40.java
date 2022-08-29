package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_40 {

  List<List<Integer>> list;

  void combinationSum(int index, int target, int[] candidates, List<Integer> combination) {

    if (target == 0) {
      list.add(new ArrayList<>(combination));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      combination.add(candidates[i]);
      combinationSum(i + 1, target - candidates[i], candidates, combination);
      combination.remove(combination.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    list = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(0, target, candidates, new ArrayList<>());
    return list;
  }

}
