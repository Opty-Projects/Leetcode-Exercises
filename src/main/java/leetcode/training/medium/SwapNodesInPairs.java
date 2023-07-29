package leetcode.training.medium;

import leetcode.training.structures.ListNode;

// https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    boolean headSet = false;
    ListNode node = head;
    ListNode previous = null;

    while (node != null && node.next != null) {
      ListNode newHead = node.next;
      node.next = newHead.next;
      newHead.next = node;

      if (!headSet) {
        head = newHead;
        headSet = true;
      } else {
        previous.next = newHead;
      }
      previous = node;
      node = node.next;
    }
    return head;
  }
}
