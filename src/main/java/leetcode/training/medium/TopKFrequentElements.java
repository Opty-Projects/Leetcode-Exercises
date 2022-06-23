package leetcode.training.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    if (k <= 0) return null;
    Map<Integer, Integer> table = new HashMap<>();
    for (int num : nums) table.put(num, table.getOrDefault(num, 0) + 1);

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[1]));
    table.forEach(
        (num, frequency) -> {
          if (minHeap.size() < k) {
            minHeap.add(new int[] {num, frequency});
          } else if (frequency > minHeap.peek()[1]) {
            minHeap.poll();
            minHeap.add(new int[] {num, frequency});
          }
        });

    int[] result = new int[k];
    int index = 0;
    while (!minHeap.isEmpty()) result[index++] = minHeap.poll()[0];
    return result;
  }
}
