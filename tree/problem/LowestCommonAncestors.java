package tree.problem;

import tree.Node;

public class LowestCommonAncestors {


  public Node lowestCommonAncestor(Node root, Node p, Node q) {
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }
    Node left = lowestCommonAncestor(root.left, p, q);
    Node right = lowestCommonAncestor(root.right, p, q);

    if (left == null ) {
      return right;
    } else if (right == null) {
      return left;
    }
    return root;
  }
}
