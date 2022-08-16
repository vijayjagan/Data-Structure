package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.Node;

public class InOrder {

  public List<Integer> inorderTraversal(Node root) {
    List<Integer> inOrder = new ArrayList<>();
    Stack<Node> implicitStack = new Stack<>();
    Node currentNode = root;
    while (currentNode != null || !implicitStack.isEmpty()) {
      while (currentNode != null) {
        implicitStack.add(currentNode);
        currentNode = currentNode.left;
      }
      currentNode = implicitStack.pop();
      inOrder.add(currentNode.val);
      currentNode = currentNode.right;
    }
    return inOrder;
  }
}
