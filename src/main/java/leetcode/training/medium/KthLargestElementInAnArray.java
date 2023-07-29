package leetcode.training.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {
    if (k > nums.length) return Integer.MIN_VALUE;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

    int index = 0;
    for (; index < k; index++) minHeap.add(nums[index]);
    for (; index < nums.length; index++) {
      if (nums[index] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[index]);
      }
    }
    return minHeap.peek();
  }
}
