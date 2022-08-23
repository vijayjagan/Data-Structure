package tree.problem;

import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

public class SerializeAndDeserialize {

  static final String NULL = "NULL";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> levelOrder = new LinkedList<>();
    if (root == null) {
      return NULL;
    }
    levelOrder.offer(root);
    StringBuilder encodedString = new StringBuilder();

    while (!levelOrder.isEmpty()) {
      TreeNode node = levelOrder.poll();
      if (encodedString.length() > 0) {
        encodedString.append(",");
      }
      if (node == null) {
        encodedString.append(NULL);
        continue;
      }
      encodedString.append(node.val);
      levelOrder.offer(node.left);
      levelOrder.offer(node.right);
    }
    return encodedString.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<TreeNode> levelOrder = new LinkedList<>();
    String[] nodeData = data.split(",");
    if (nodeData.length == 0 || nodeData[0].equals(NULL)) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nodeData[0]));
    levelOrder.offer(root);

    for (int i = 1; i < nodeData.length; i++) {
      TreeNode node = levelOrder.poll();
      String leftValue = nodeData[i++];
      if (!leftValue.equals(NULL)) {
        node.left = new TreeNode(Integer.parseInt(leftValue));
        levelOrder.offer(node.left);
      }
      String rightValue = nodeData[i];
      if (!rightValue.equals(NULL)) {
        node.right = new TreeNode(Integer.parseInt(leftValue));
        levelOrder.offer(node.right);
      }
    }
    return root;
  }

}
