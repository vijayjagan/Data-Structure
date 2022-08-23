package tree.binarysearch.problem;

import tree.TreeNode;

public class Floor {

  int findFloor(TreeNode root, int key) {
    int floor = -1;
    while (root != null) {
      if (key == root.val) {
        return key;
      }
      // 9 < 10
      if (key < root.val) {
        root = root.left;
      } else {
        floor = root.val;
        root = root.right;
      }
    }
    return floor;
  }
}
