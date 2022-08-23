package tree;

public class TreeNode {

  /**
   * Definition for a binary tree node.
   **/

  public int val;
  public TreeNode left;
  public TreeNode right;

  public int number;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
