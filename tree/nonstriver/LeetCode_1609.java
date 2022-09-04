package tree.nonstriver;

import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

public class LeetCode_1609 {

  public boolean isEvenOddTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    int level = 0;
    Queue<TreeNode> levelOrder = new LinkedList<>();
    levelOrder.offer(root);

    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      for (int i = 0; i < size; i++) {
        TreeNode node = levelOrder.poll();
        if (level % 2 == 0) {
          if (node.val % 2 == 0 || prev >= node.val) {
            return false;
          }
        } else {
          if (node.val % 2 != 0 || prev <= node.val) {
            return false;
          }
        }
        prev = node.val;
        if (node.left != null) {
          levelOrder.offer(node.left);
        }
        if (node.right != null) {
          levelOrder.offer(node.right);
        }
      }

      level++;
    }
    return true;
  }

}
