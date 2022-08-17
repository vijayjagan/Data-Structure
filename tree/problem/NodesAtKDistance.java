package tree.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import tree.TreeNode;

public class NodesAtKDistance {

  static void storeParentInMap(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> levelOrder = new LinkedList<>();
    levelOrder.offer(root);

    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = levelOrder.poll();
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

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Set<TreeNode> visitedNode = new HashSet<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    storeParentInMap(parentMap, root);
    Queue<TreeNode> levelOrder = new LinkedList<>();
    if (target == null) {
      return Collections.emptyList();
    }
    levelOrder.offer(target);
    visitedNode.add(target);
    int currentLevel = 0;

    while (!levelOrder.isEmpty()) {
      int size = levelOrder.size();

      if (currentLevel++ == k) {
        break;
      }

      for (int i = 0; i < size; i++) {
        TreeNode node = levelOrder.poll();
        TreeNode parent = parentMap.getOrDefault(node, null);

        if (node.left != null && !visitedNode.contains(node.left)) {
          visitedNode.add(node.left);
          levelOrder.offer(node.left);
        }
        if (node.right != null && !visitedNode.contains(node.right)) {
          visitedNode.add(node.right);
          levelOrder.offer(node.right);
        }
        if (parent != null && !visitedNode.contains(parent)) {
          visitedNode.add(parent);
          levelOrder.offer(parent);
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    while (!levelOrder.isEmpty()) {
      list.add(levelOrder.poll().val);
    }
    return list;
  }
}
