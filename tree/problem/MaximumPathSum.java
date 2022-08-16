package tree.problem;

import tree.Node;

public class MaximumPathSum {

  int maxPath = Integer.MIN_VALUE;

  int maximumPathSum(Node root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(0, maximumPathSum(root.left));
    int right = Math.max(0,maximumPathSum(root.right));
    maxPath = Math.max(maxPath,  root.val + left + right);
    return  root.val + Math.max(left, right);
  }

  public int maxPathSum(Node root) {
    maximumPathSum(root);
    return maxPath;
  }
}
