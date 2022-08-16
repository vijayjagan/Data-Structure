package tree.problem;

import tree.Node;

public class ChildSumProperty {

  public Node changeToChildSum(Node root) {
    if (root.left == null && root.right == null) {
      return root;
    }

    if (root.val > root.left.val + root.right.val) {
      root.left.val = root.val;
      root.right.val = root.val;
    } else {
      root.val = root.left.val + root.right.val;
    }

    Node leftChild = changeToChildSum(root.left);
    Node rightChild = changeToChildSum(root.right);

    if (leftChild != null && rightChild != null) {
      root.val = leftChild.val + rightChild.val;
    }

    return root;
  }
}
