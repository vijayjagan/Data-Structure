package tree.problem;

import tree.TreeNode;

public class FlatternBinaryTree {


  TreeNode prev = null;
  public void flatten(TreeNode root) {

    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
