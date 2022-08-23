package tree.nonstriver;

;
import tree.TreeNode;

public class LeetCode_1315 {


  static int sumEvenGrandParent(TreeNode root, TreeNode parent, TreeNode grandParent) {
    int sum = 0;
    if (root == null) {
      return 0;
    }
    if (grandParent != null && grandParent.val % 2 == 0) {
      sum += root.val;
    }
    return sum + sumEvenGrandParent(root.left, root, parent) + sumEvenGrandParent(root.right, root, parent);
  }


  public int sumEvenGrandparent(TreeNode root) {
    return sumEvenGrandParent(root, null, null);
  }

}
