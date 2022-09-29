package LinkedList;

public class LeetCode_2 {




  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode finalNode = result;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = l1 != null ? l1.val : 0;
      int y = l2 != null ? l2.val : 0;
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
      int sum = x + y + carry;
      result.next = new ListNode(sum % 10);
      result = result.next;
      carry =  sum / 10;
    }

    return finalNode;
  }


}
