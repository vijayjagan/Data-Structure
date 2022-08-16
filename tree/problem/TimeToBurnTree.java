package tree.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TimeToBurnTree {

  class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  static void storeParentInMap(Map<Node, Node> parentMap, Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> levelOrder = new LinkedList<>();
    levelOrder.offer(root);

    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      for (int i = 0; i < size; i++) {
        Node node = levelOrder.poll();
        if (node.left != null) {
          parentMap.put(node.left, node);
          levelOrder.offer(node.left);
        }
        if (node.right != null) {
          parentMap.put(node.right, node);
          levelOrder.offer(node.right);
        }
      }
    }
  }

  static Node findTargetNode(Node node, int target) {
    if (node == null) {
      return null;
    }
    if (node.data == target) {
      return node;
    }
    Node foundNode = findTargetNode(node.left, target);
    if (foundNode == null) {
      foundNode = findTargetNode(node.right, target);
    }
    return foundNode;
  }

  public static int minTime(Node root, int target) {
    Map<Node, Node> parentMap = new HashMap<>();
    storeParentInMap(parentMap, root);
    Node targetNode = findTargetNode(root, target);
    Set<Node> visitedNode = new HashSet<>();

    Queue<Node> levelOrder = new LinkedList<>();
    levelOrder.offer(targetNode);
    visitedNode.add(targetNode);

    int time = 0;
    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      time++;
      for (int i = 0; i < size; i++) {
        Node node = levelOrder.poll();
        Node parentNode = parentMap.getOrDefault(node, null);

        if (node.left != null && !visitedNode.contains(node.left)) {
          visitedNode.add(node.left);
          levelOrder.offer(node.left);
        }
        if (node.right != null && !visitedNode.contains(node.right)) {
          visitedNode.add(node.right);
          levelOrder.offer(node.right);
        }
        if (parentNode != null && !visitedNode.contains(parentNode)) {
          visitedNode.add(parentNode);
          levelOrder.offer(parentNode);
        }
      }
    }
    return time;
  }
}
