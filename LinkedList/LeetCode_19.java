package LinkedList;

public class LeetCode_19 {

  int count = 0;

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    head.next = removeNthFromEnd(head.next, n);
    return ++count == n ? head.next : head;
  }

}
