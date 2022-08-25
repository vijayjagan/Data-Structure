package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_1325 {


  static TreeNode removeTargetLeafNode(TreeNode root, int target) {
    if (root == null) {
      return null;
    }

    if (root.left != null) {
      root.left = removeTargetLeafNode(root.left, target);
    }
    if (root.right != null) {
      root.right = removeTargetLeafNode(root.right, target);
    }

    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }

    return root;
  }


  public TreeNode removeLeafNodes(TreeNode root, int target) {
    return removeTargetLeafNode(root, target);
  }

}
