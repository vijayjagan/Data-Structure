package tree.problem;


import tree.TreeNode;

public class ChildSumProperty {

  public TreeNode changeToChildSum(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root;
    }

    if (root.val > root.left.val + root.right.val) {
      root.left.val = root.val;
      root.right.val = root.val;
    } else {
      root.val = root.left.val + root.right.val;
    }

    TreeNode leftChild = changeToChildSum(root.left);
    TreeNode rightChild = changeToChildSum(root.right);

    if (leftChild != null && rightChild != null) {
      root.val = leftChild.val + rightChild.val;
    }

    return root;
  }
}
