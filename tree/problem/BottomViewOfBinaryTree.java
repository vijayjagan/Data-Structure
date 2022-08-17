package tree.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import tree.TreeNode;

public class BottomViewOfBinaryTree {

  class Pair {

    TreeNode node;
    int xAxis;

    public Pair(TreeNode node, int xAxis) {
      this.node = node;
      this.xAxis = xAxis;
    }
  }

  public ArrayList<Integer> bottomView(TreeNode root) {
    Queue<Pair> levelOrder = new LinkedList<>();
    levelOrder.offer(new Pair(root, 0));
    Map<Integer, Integer> cacheTraversal = new TreeMap<>();
    while (!levelOrder.isEmpty()) {
      Pair pair = levelOrder.poll();
      TreeNode node = pair.node;
      if (node.left != null) {
        int xAxis = pair.xAxis - 1;
        levelOrder.offer(new Pair(node.left, xAxis));
      }
      if (node.right != null) {
        int xAxis = pair.xAxis + 1;
        levelOrder.offer(new Pair(node.right, xAxis));
      }
      cacheTraversal.put(pair.xAxis, node.val);

    }
    return new ArrayList<>(cacheTraversal.values());
  }
}
