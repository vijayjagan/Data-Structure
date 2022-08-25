package tree.nonstriver;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class LeetCode_113 {

  void pathSum(TreeNode root, int target, int sum, List<Integer> rootToCurrent,
      List<List<Integer>> path) {
    if (root == null) {
      return;
    }

    if (target == sum + root.val && root.left == null && root.right == null) {
      rootToCurrent.add(root.val);
      path.add(new ArrayList<>(rootToCurrent));
      rootToCurrent.remove(rootToCurrent.size() - 1);
      return;
    }

    if (target - root.val < 0) {
      return;
    }

    rootToCurrent.add(root.val);
    pathSum(root.left, target, sum + root.val, rootToCurrent, path);
    pathSum(root.right, target, sum + root.val, rootToCurrent, path);
    rootToCurrent.remove(rootToCurrent.size() - 1);
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> path = new ArrayList<>();
    pathSum(root, targetSum, 0, new ArrayList<>(), path);
    return path;
  }
}
