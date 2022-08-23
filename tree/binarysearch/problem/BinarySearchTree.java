package tree.binarysearch.problem;

import tree.TreeNode;

public class BinarySearchTree {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root.val == val) {
      return root;
    }
    if (root.left != null && val < root.val) {
      return searchBST(root.left, val);
    } else if (root.right != null && val > root.val) {
      return searchBST(root.right, val);
    }
    return null;
  }
}
