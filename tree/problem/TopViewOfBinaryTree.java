package tree.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import tree.Node;

public class TopViewOfBinaryTree {

  static class Pair {

    Node node;
    int xAxis;

    public Pair(Node node, int xAxis) {
      this.node = node;
      this.xAxis = xAxis;
    }
  }

  static ArrayList<Integer> topView(Node root) {
    Queue<Pair> levelOrder = new LinkedList<>();
    levelOrder.offer(new Pair(root, 0));
    Map<Integer, Integer> cacheTraversal = new TreeMap<>();
    while (!levelOrder.isEmpty()) {
      Pair pair = levelOrder.poll();
      Node node = pair.node;
      if (node.left != null) {
        int xAxis = pair.xAxis - 1;
        levelOrder.offer(new Pair(node.left, xAxis));
      }
      if (node.right != null) {
        int xAxis = pair.xAxis + 1;
        levelOrder.offer(new Pair(node.right, xAxis));
      }
      if (!cacheTraversal.containsKey(pair.xAxis)) {
        cacheTraversal.put(pair.xAxis, node.val);
      }
    }
    return new ArrayList<>(cacheTraversal.values());
  }
}
