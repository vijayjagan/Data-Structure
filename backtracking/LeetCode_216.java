package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_216 {

  List<List<Integer>> list;

  void combinationSum(int index, int target, int targetSize, List<Integer> combination) {

    if (target == 0 && combination.size() == targetSize) {
      list.add(new ArrayList<>(combination));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = index; i <= 9; i++) {
      combination.add(i);
      combinationSum(i + 1, target - i, targetSize, combination);
      combination.remove(combination.size() - 1);
    }
  }

  void combinationSumWithOutLoop(int index, int target, int targetSize, List<Integer> combination) {

    if (target == 0 && combination.size() == targetSize) {
      list.add(new ArrayList<>(combination));
      return;
    }

    if (target < 0 || index >= 10) {
      return;
    }

    combination.add(index);
    combinationSumWithOutLoop(index + 1, target - index, targetSize, combination);
    combination.remove(combination.size() - 1);
    combinationSumWithOutLoop(index + 1, target, targetSize, combination);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    list = new ArrayList<>();
    combinationSumWithOutLoop(1, n, k, new ArrayList<>());
    return list;
  }

  public static void main(String[] args) {
    new LeetCode_216().combinationSum3(3, 7);
  }

}
