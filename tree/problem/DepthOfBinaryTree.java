package tree.problem;

import tree.Node;

public class DepthOfBinaryTree {

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 +  Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
