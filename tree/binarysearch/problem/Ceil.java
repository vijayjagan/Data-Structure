package tree.binarysearch.problem;

import tree.TreeNode;

public class Ceil {

  int findCeil(TreeNode root, int key) {

    int ceil = -1;
    while (root != null) {
      if (root.val == key) {
        return root.val;
      }
      if (key > root.val) {
        root = root.right;
      } else {
        ceil = root.val;
        root = root.left;
      }
    }
    return ceil;
  }
}
