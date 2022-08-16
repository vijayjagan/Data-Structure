package tree.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tree.Node;

public class ZigZagTraversal {

  public List<List<Integer>> zigzagLevelOrder(Node root) {
    List<List<Integer>> zigZag = new ArrayList<>();
    if (root == null) {
      return zigZag;
    }

    Queue<Node> levelOrder = new LinkedList<>();
    levelOrder.offer(root);
    boolean counterWise = false;
    while (!levelOrder.isEmpty()) {
      List<Integer> innerList = new ArrayList<>();
      int queueSize = levelOrder.size();
      for (int i = 0; i < queueSize; i++) {
        Node node = levelOrder.poll();
        if (counterWise) {
          innerList.add(0, node.val);
        } else {
          innerList.add(node.val);
        }
        if (node.left != null) {
          levelOrder.offer(node.left);
        }
        if (node.right != null) {
          levelOrder.offer(node.right);
        }
      }
      zigZag.add(innerList);
      counterWise = !counterWise;
    }
    return zigZag;
  }
}
