package tree.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import tree.Node;

public class RightViewOfBinaryTree {

  class Pair {

    Node node;
    int level;

    public Pair(Node node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public List<Integer> rightSideView(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<Pair> levelOrder = new LinkedList<>();
    Map<Integer, Integer> cacheTraversal = new TreeMap<>();
    levelOrder.offer(new Pair(root, 0));

    while (!levelOrder.isEmpty()) {
      Pair pair = levelOrder.poll();
      Node node = pair.node;

      int nextLevel = pair.level + 1;

      if (node.left != null) {
        levelOrder.offer(new Pair(node.left, nextLevel));
      }
      if (node.right != null) {
        levelOrder.offer(new Pair(node.right, nextLevel));
      }

      cacheTraversal.put(pair.level, node.val);
    }
    return new ArrayList<>(cacheTraversal.values());
  }
}
