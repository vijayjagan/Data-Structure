package tree.narray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tree.Node;

public class LeetCode_429 {

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<Node>levelOrder = new LinkedList<>();
    levelOrder.offer(root);
    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      List<Integer> localList = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        Node node = levelOrder.poll();
        localList.add(node.val);
        if (node.children == null) {
          continue;
        }
        for (Node childNode : node.children) {
          if (childNode.children != null) {
            levelOrder.offer(childNode);
          }
        }
      }
      result.add(new ArrayList<>(localList));
    }
    return result;
  }

}
