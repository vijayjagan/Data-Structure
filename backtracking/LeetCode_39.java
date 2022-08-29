package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_39 {

  List<List<Integer>> list;

  void combinationSum(int index, int target, int[] candidates, List<Integer> combination) {
    if (target == 0) {
      list.add(new ArrayList<>(combination));
      return;
    }

    if (target < 0 || index >= candidates.length) {
      return;
    }

    combination.add(candidates[index]);
    combinationSum(index, target - candidates[index], candidates, combination);
    combination.remove(combination.size() - 1);
    combinationSum(index + 1, target, candidates, combination);
  }

  void combinationUsingLoop(int index, int target, int[] candidates, List<Integer> combination) {
    if (index == candidates.length) {
      list.add(new ArrayList<>(combination));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      combination.add(candidates[i]);
      combinationUsingLoop(i , target - candidates[i], candidates, combination);
      combination.remove(combination.size() - 1);
    }
  }


  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    list = new LinkedList<>();
    combinationUsingLoop(0, target, candidates, new ArrayList<>());
    return list;
  }



}
