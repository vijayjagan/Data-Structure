package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.Node;

public class PreOrder {

  public List<Integer> preorderTraversal(Node root) {
    List<Integer> preOrder = new ArrayList<>();
    Stack<Node> explicitStack = new Stack<>();
    if (root != null) {
      explicitStack.add(root);
    }
    while (!explicitStack.isEmpty()) {
      Node node = explicitStack.pop();
      preOrder.add(node.val);
      if (node.right != null) {
        explicitStack.add(node.right);
      }
      if (node.left != null) {
        explicitStack.add(node.left);
      }
    }
    return preOrder;
  }
}
