package tree.problem;

import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import tree.TreeNode;

public class VerticalTraversal {

  class Triplet {
    TreeNode node;
    int level;
    int xAxis;

    public Triplet(TreeNode node, int level, int xAxis) {
      this.node = node;
      this.level = level;
      this.xAxis = xAxis;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {

    // Map Contains X-axis -> LevelOrder -> Value
    Map<Integer, Map<Integer, Queue<Integer>>> cacheTraversal = new TreeMap<>();
    List<List<Integer>> verticalTraversal = new ArrayList<>();

    Queue<Triplet> levelOrder = new LinkedList<>();
    levelOrder.offer(new Triplet(root, 0, 0));

    while (!levelOrder.isEmpty()) {
      Triplet triplet = levelOrder.poll();
      TreeNode node = triplet.node;
      int nextLevel = triplet.level + 1;

      if (!cacheTraversal.containsKey(triplet.xAxis)) {
        cacheTraversal.put(triplet.xAxis, new TreeMap<>());
      }

      if (!cacheTraversal.get(triplet.xAxis).containsKey(triplet.level)) {
        cacheTraversal.get(triplet.xAxis).put(triplet.level, new PriorityQueue<>());
      }

      cacheTraversal.get(triplet.xAxis).get(triplet.level).offer(node.val);

      if (node.left != null) {
        int xAxis = triplet.xAxis - 1;
        levelOrder.offer(new Triplet(node.left, nextLevel, xAxis));
      }

      if (node.right != null) {
        int xAxis = triplet.xAxis + 1;
        levelOrder.offer(new Triplet(node.right, nextLevel, xAxis));
      }
    }

    for( Map<Integer, Queue<Integer>> levelAndValueMap : cacheTraversal.values()) {
      List<Integer> innerList = new ArrayList<>();
      for (Queue<Integer> queue : levelAndValueMap.values()) {
        while (!queue.isEmpty()) {
          innerList.add(queue.poll());
        }
      }
      if (!innerList.isEmpty()) {
        verticalTraversal.add(new ArrayList<>(innerList));
      }
    }

    return verticalTraversal;
  }
}
