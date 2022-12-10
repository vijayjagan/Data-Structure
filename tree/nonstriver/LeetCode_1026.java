package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_1026 {

  public int maxAncestorDiff(TreeNode root) {
    return maxAncestorDiff(root, root.val, root.val);
  }

  static int maxAncestorDiff(TreeNode root, int max, int min) {
    if (root == null) {
      return Math.abs(max - min);
    }
    int currentMax = Math.max(root.val, max);
    int currentMin = Math.min(root.val, min);
    return Math.max(maxAncestorDiff(root.left, currentMax, currentMin),
        maxAncestorDiff(root.right, currentMax, currentMin));
  }

}
