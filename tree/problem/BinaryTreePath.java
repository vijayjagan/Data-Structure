package tree.problem;

import java.util.ArrayList;
import java.util.List;
import tree.Node;

public class BinaryTreePath {

  static void binaryTreePaths(Node root, List<String> list, String s) {
    if (root.left == null && root.right == null) {
      list.add(s + root.val);
    }
    if (root.left != null) {
      binaryTreePaths(root.left, list, s + root.val + "->");
    }
    if (root.right != null) {
      binaryTreePaths(root.right, list, s + root.val + "->");
    }
  }

  public List<String> binaryTreePaths(Node root) {
    List<String> list = new ArrayList<>();
    binaryTreePaths(root, list, "");
    return list;
  }
}
