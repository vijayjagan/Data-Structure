package tree.nonstriver;

import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

public class LeetCode_1302 {


  public int deepestLeavesSum(TreeNode root) {
    Queue<TreeNode> levelOrder = new LinkedList<>();
    if (root == null) {
      return 0;
    }
    levelOrder.offer(root);
    int sum = 0;
    while (!levelOrder.isEmpty()) {
      sum = 0;
      int size = levelOrder.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = levelOrder.poll();
        if (node.left != null) {
          levelOrder.offer(node.left);
        }
        if (node.right != null) {
          levelOrder.offer(node.right);
        }
        sum += node.val;
      }
    }
    return sum;
  }

}
