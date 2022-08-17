package tree.problem;

import tree.TreeNode;

public class DiameterOfBinaryTree {


  /**
   * Intuition : - Find the max height of the binary tree, use variable to track max of left +
   * right
   */
  class WrapInt {

    int value;
  }

  static int diameterOfBinaryTree(TreeNode root, int maxHeight, WrapInt refInt) {
    if (root == null) {
      return 0;
    }
    int left = diameterOfBinaryTree(root.left, maxHeight, refInt);
    int right = diameterOfBinaryTree(root.right, maxHeight, refInt);
    refInt.value = Math.max(refInt.value, left + right);
    return 1 + Math.max(left, right);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    WrapInt wrapInt = new WrapInt();
    diameterOfBinaryTree(root, 0, wrapInt);
    return wrapInt.value;
  }


}
