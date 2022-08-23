package tree.binarysearch.problem;

import tree.TreeNode;

public class DeleteNode {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      // Here root is the node which we are going to delete
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      TreeNode rightExtreme = root.left;
      // Travel to extreme right subtree of the deleteNode's left child.In order to attach the deletedNode right Subtree.
      while (rightExtreme.right != null) {
        rightExtreme = rightExtreme.right;
      }
      rightExtreme.right = root.right;
      return root.left;
    }
    return root;
  }

}
