package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_814 {


  static int shrunkTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftChild = shrunkTree(root.left);
    int rightChild = shrunkTree(root.right);

    if (root.val + leftChild + rightChild == 0) {
      root.left = root.right = null;
    } else {
      if (leftChild == 0) {
        root.left = null;
      }
      if (rightChild == 0) {
        root.right = null;
      }
    }
    return leftChild + rightChild + root.val;
  }

  public TreeNode pruneTree(TreeNode root) {
    int rootVal = shrunkTree(root);
    if (rootVal == 0) {
      root = null;
    }

    return root;
  }

}
