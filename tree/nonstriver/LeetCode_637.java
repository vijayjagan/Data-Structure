package tree.nonstriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tree.TreeNode;

public class LeetCode_637 {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> average = new ArrayList<>();
    Queue<TreeNode> levelOrder = new LinkedList<>();
    levelOrder.offer(root);

    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      double value = 0;

      for (int i = 0; i < size; i++) {
        TreeNode node = levelOrder.poll();
        value += node.val;

        if (node.left != null) {
          levelOrder.offer(node.left);
        }
        if (node.right != null) {
          levelOrder.offer(node.right);
        }
      }
      average.add(value / size);
    }
    return average;
  }

}
