package leetcode.training.medium;

import leetcode.training.structures.ListNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;
    List<ListNode> nodeStack = new ArrayList<>();
    for (ListNode node = head; node != null; node = node.next) nodeStack.add(node);

    int length = nodeStack.size();
    if (n == length) return head.next;

    nodeStack.get(length - n - 1).next = nodeStack.get(length - n).next;
    return head;
  }
}
