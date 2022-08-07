package tree.traversal;

public class BalancedBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftChild = maxDepth(root.left);
    int rightChild = maxDepth(root.right);
    if (Math.abs(leftChild - rightChild) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

}
