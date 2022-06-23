package leetcode.training.structures;

import java.util.ArrayList;
import java.util.List;

/** Definition for singly-linked list. */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode create(int[] vals) {
    ListNode head = null;
    for (int i = vals.length - 1; i >= 0; i--) head = new ListNode(vals[i], head);
    return head;
  }

  @Override
  public String toString() {
    List<Integer> vals = new ArrayList<>();
    for (ListNode node = this; node != null; node = node.next) vals.add(node.val);
    return vals.toString();
  }
}
