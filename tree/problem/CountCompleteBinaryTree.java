package tree.problem;


import tree.TreeNode;

public class CountCompleteBinaryTree {

  static int leftHeight(TreeNode root ) {
    if (root == null) {
      return 0;
    }
    return 1 + leftHeight(root.left);
  }

  static int rightHeight(TreeNode root ) {
    if (root == null) {
      return 0;
    }
    return 1 + rightHeight(root.right);
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = leftHeight(root);
    int right = rightHeight(root);

    if (left == right) {
      return (int) (Math.pow(2, left) - 1);
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

}
