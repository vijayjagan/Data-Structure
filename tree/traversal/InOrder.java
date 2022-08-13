package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.TreeNode;

public class InOrder {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();
    Stack<TreeNode> implicitStack = new Stack<>();
    TreeNode currentNode = root;
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
