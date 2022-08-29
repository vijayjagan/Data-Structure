package tree.nonstriver;

import java.util.HashMap;
import java.util.Map;
import tree.TreeNode;

public class LeetCode_1367 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  boolean isSame(ListNode head, TreeNode root) {

    if (head == null) {
      return true;
    }

    if (root == null) {
      return false;
    }
    return root.val == head.val &&( isSame(head.next, root.left) || isSame(head.next, root.right));
  }

  public boolean isSubPath(ListNode head, TreeNode root) {
    return isSame(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }

}
