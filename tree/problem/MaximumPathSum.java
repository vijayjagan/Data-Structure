package tree.problem;

import tree.TreeNode;

public class MaximumPathSum {

  int maxPath = Integer.MIN_VALUE;

  int maximumPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(0, maximumPathSum(root.left));
    int right = Math.max(0,maximumPathSum(root.right));
    maxPath = Math.max(maxPath,  root.val + left + right);
    return  root.val + Math.max(left, right);
  }

  public int maxPathSum(TreeNode root) {
    maximumPathSum(root);
    return maxPath;
  }
}
