package tree.binarysearch.problem;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class KthSmallestElement {


  static void kthSmallestElement(TreeNode root,  List<Integer> inOrderList) {
    if (root == null) {
      return;
    }
    kthSmallestElement(root.left,  inOrderList);
    inOrderList.add(root.val);
    kthSmallestElement(root.right,  inOrderList);
  }

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> integerList = new ArrayList<>();
    kthSmallestElement(root, integerList);
    return integerList.get(k - 1);
  }

}
