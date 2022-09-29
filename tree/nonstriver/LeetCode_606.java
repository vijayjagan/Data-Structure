package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_606 {


  public String tree2str(TreeNode root) {
    if (root == null) {
      return "";
    }

    String value = root.val + "";

    if (root.left != root.right) {
      value += "(" + tree2str(root.left) + ")";
    }

    if (root.right != null) {
      value += "(" + tree2str(root.right) + ")";
    }
    return value;
  }

}
