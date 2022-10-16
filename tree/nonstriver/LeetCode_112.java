package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_112 {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    int targetValue = targetSum - root.val;
    if (root.left == root.right) {
      return targetValue == 0;
    }
    return hasPathSum(root.left, targetValue) || hasPathSum(root.right,
        targetValue);
  }

}
