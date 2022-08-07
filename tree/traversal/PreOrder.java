package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    Stack<TreeNode> explicitStack = new Stack<>();
    if (root != null) {
      explicitStack.add(root);
    }
    while (!explicitStack.isEmpty()) {
      TreeNode node = explicitStack.pop();
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
