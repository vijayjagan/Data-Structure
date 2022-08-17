package tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import jdk.jfr.Description;
import tree.TreeNode;

public class PostOrder {

  @Description("using two stack")
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new LinkedList<>();
    Stack<TreeNode> firstStack = new Stack<>();
    Stack<TreeNode> secondStack = new Stack<>();
    if (root == null) {
      return postOrder;
    }
    firstStack.add(root);
    while (!firstStack.isEmpty()) {
      TreeNode node = firstStack.pop();
      secondStack.add(node);
      if (node != null) {
        firstStack.add(node.left);
      }
      if (node != null) {
        firstStack.add(node.right);
      }
    }
    while (!secondStack.isEmpty()) {
      TreeNode node = secondStack.pop();
      if (node != null) {
        postOrder.add(node.val);
      }

    }
    return postOrder;
  }

  public List<Integer> postOrderTraversalUsingSingleStack(TreeNode root) {
    List<Integer> postOrder = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
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
