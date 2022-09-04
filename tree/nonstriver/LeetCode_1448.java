package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_1448 {


  static int goodNodes(TreeNode root, int localMax) {
    if (root == null) {
      return 0;
    }
    int newMax = Math.max(root.val, localMax);
    int count = 0;

    if (localMax <= root.val) {
      count++;
    }

    return count + goodNodes(root.left, newMax) + goodNodes(root.right, newMax);
  }

  public int goodNodes(TreeNode root) {
    return goodNodes(root, Integer.MIN_VALUE);
  }

}
