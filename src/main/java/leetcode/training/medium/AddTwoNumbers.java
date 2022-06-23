package leetcode.training.medium;

import leetcode.training.structures.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode previous = null;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      ListNode node = new ListNode();
      if (head == null) head = node;
      else previous.next = node;

      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      node.val = sum % 10;
      carry = sum / 10;

      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
      previous = node;
    }
    return head;
  }
}
