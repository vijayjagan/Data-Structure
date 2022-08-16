package tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import jdk.jfr.Description;
import tree.Node;

public class PostOrder {

  @Description("using two stack")
  public List<Integer> postorderTraversal(Node root) {
    List<Integer> postOrder = new LinkedList<>();
    Stack<Node> firstStack = new Stack<>();
    Stack<Node> secondStack = new Stack<>();
    if (root == null) {
      return postOrder;
    }
    firstStack.add(root);
    while (!firstStack.isEmpty()) {
      Node node = firstStack.pop();
      secondStack.add(node);
      if (node != null) {
        firstStack.add(node.left);
      }
      if (node != null) {
        firstStack.add(node.right);
      }
    }
    while (!secondStack.isEmpty()) {
      Node node = secondStack.pop();
      if (node != null) {
        postOrder.add(node.val);
      }

    }
    return postOrder;
  }

  public List<Integer> postOrderTraversalUsingSingleStack(Node root) {
    List<Integer> postOrder = new LinkedList<>();
    Stack<Node> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node != null) {
        postOrder.add(0, node.val);
        if (node.left != null) {
          stack.add(node.left);
        }
        if (node.right != null) {
          stack.add(node.right);
        }
      }
    }
    return postOrder;
  }

}
