package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_623 {


  public TreeNode addOneRow(TreeNode root, int val, int depth, boolean isLeftChild) {
    if (depth == 0) {
      return new TreeNode(val, isLeftChild ? root : null, !isLeftChild ? root : null);
    }
    if (root == null) {
      return null;
    }
    root.left = addOneRow(root.left, val, depth - 1, true);
    root.right = addOneRow(root.right, val, depth - 1, false);
    return root;
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    return addOneRow(root, val, depth - 1, true);
  }

}
