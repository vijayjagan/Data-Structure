package LinkedList;

public class LeetCode_24 {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode temp = head.next;
    temp.next = head;
    temp.next.next = swapPairs(head.next.next);
    return temp;
  }

}
