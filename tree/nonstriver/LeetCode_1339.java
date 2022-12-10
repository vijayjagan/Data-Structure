package tree.nonstriver;

import tree.TreeNode;

public class LeetCode_1339 {

  private long max = Integer.MIN_VALUE;

  long getTotal(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getTotal(root.left) + getTotal(root.right) + root.val;
  }

  long maxProduct(TreeNode root, long total) {
    if (root == null) {
      return 0;
    }
    long left = maxProduct(root.left, total);
    long right = maxProduct(root.right, total);
    long currTotal = left + right + root.val;
    max = Math.max(currTotal * (total - currTotal), max);
    return currTotal;
  }

  public int maxProduct(TreeNode root) {
    long total = getTotal(root);
    maxProduct(root, total);
    return (int) max % 1000000007;
  }

}
