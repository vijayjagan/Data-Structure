package LinkedList;

import java.util.ArrayList;

public class LeetCode_328 {

  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }



    ListNode oddPointer = head, oddTail = head;
    ListNode evenPointer = head.next, linker = head.next;

    while (oddPointer != null || evenPointer != null) {

      if (oddPointer != null ) {
        oddPointer.next = oddPointer.next != null ? oddPointer.next.next : null;
        oddTail = oddPointer;
        oddPointer = oddPointer.next;
      }

      if (evenPointer != null) {
        evenPointer.next = evenPointer.next != null ? evenPointer.next.next : null;
        evenPointer = evenPointer.next;
      }
    }
    oddTail.next = linker;
    return head;
  }

}
