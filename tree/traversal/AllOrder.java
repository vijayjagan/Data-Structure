package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.Node;

public class AllOrder {

  public static void printAllOrderTraversal(Node root) {
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> inOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    root.number = 1;
    stack.add(root);

    while (!stack.isEmpty()) {
      Node node = stack.peek();
      if (node.number == 1) {
        preOrder.add(node.val);
        node.number += 1;
        if (node.left != null) {
          stack.add(node.left);
        }
      } else if (node.number == 2) {
        inOrder.add(node.val);
        node.number += 1;
        if (node.right != null) {
          stack.add(node.right);
        }
      } else {
        Node popup = stack.pop();
        postOrder.add(popup.val);
      }
    }
    System.out.println("preorder :::: " + preOrder);
    System.out.println("inOrder :::: " + inOrder);
    System.out.println("postOrder :::: " + postOrder);
  }

}
