package tree.problem;

import java.util.LinkedList;
import java.util.Queue;
import tree.Node;

public class MaximumWidth {

  class Pair {

    Node node;
    int order;

    public Pair(Node node, int order) {
      this.node = node;
      this.order = order;
    }
  }

  public int widthOfBinaryTree(Node root) {
    if (root == null) {
      return 0;
    }
    Queue<Pair> levelOrder = new LinkedList<>();
    levelOrder.offer(new Pair(root, 0));
    int maxWidth = Integer.MIN_VALUE;
    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      int firstNodeIndex = 0, lastNodeIndex = 0;
      int minIndex = levelOrder.peek().order;

      for (int i = 0; i < size; i++) {
        Pair pair = levelOrder.poll();
        Node node = pair.node;

        if (i == 0) {
          firstNodeIndex = pair.order;
        } else if (i == size - 1) {
          lastNodeIndex = pair.order;
        }
        if (node.left != null) {
          levelOrder.offer(new Pair(node.left, 2 * (pair.order - minIndex) + 1));
        }

        if (node.right != null) {
          levelOrder.offer(new Pair(node.right, 2 * (pair.order - minIndex) + 2));
        }
      }
      maxWidth = Math.max(maxWidth, lastNodeIndex - firstNodeIndex + 1);
    }
    return maxWidth;
  }

}
