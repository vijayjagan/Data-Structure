package LinkedList;

public class LeetCode_2095  {
  int fCount = 0;

  public ListNode deleteMiddleNode(ListNode head, int count) {
    if (head == null) {
      return null;
    }
    fCount ++;
    head.next = deleteMiddleNode(head.next, count + 1);
    return count == fCount >> 1 ? head.next : head;
  }

  public ListNode deleteMiddle(ListNode head) {
    return deleteMiddleNode(head, 0);
  }


}
