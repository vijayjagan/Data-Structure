package tree.binarysearch.problem;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class ValidBST {

  static void kthSmallestElement(TreeNode root,  List<Integer> inOrderList) {
    if (root == null) {
      return;
    }
    kthSmallestElement(root.left,  inOrderList);
    inOrderList.add(root.val);
    kthSmallestElement(root.right,  inOrderList);
  }


  public boolean isValidBST(TreeNode root) {
    List<Integer> integerList = new ArrayList<>();
    kthSmallestElement(root, integerList);
    if (integerList.size() <= 1) {
      return true;
    }
    int firstValue = integerList.get(0);
    for (int i = 1; i < integerList.size(); i++) {
      if (firstValue > integerList.get(i)) {
        return false;
      }
      firstValue = integerList.get(i);
    }

    return true;
  }

}
