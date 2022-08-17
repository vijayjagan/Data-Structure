package tree.problem;


import tree.TreeNode;

public class SymmetricTree {

    static boolean isSymmetric (TreeNode var1 , TreeNode var2) {
      if (var1 == null && var2 == null) {
        return true;
      }
      if (var1 == null || var2 == null || var1.val != var2.val) {
        return false;
      }
      boolean left = isSymmetric(var1.left, var2.right);
      boolean right = isSymmetric(var1.right, var2.left);
      return left && right;
    }
    public boolean isSymmetric(TreeNode root) {
      return isSymmetric(root.left, root.right);
    }
}
