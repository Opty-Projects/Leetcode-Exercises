package leetcode.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int k) {
    if (points.length <= k) return points;
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(e -> -e[0]));
    for (int index = 0; index < points.length; index++) {
      int[] e = new int[] {distance(points[index]), index};
      if (maxHeap.size() < k) maxHeap.add(e);
      else if (e[0] < maxHeap.peek()[0]) {
        maxHeap.poll();
        maxHeap.add(e);
      }
    }
    int[][] closestKth = new int[k][];
    for (int i = 0; i < k; i++) closestKth[i] = points[maxHeap.poll()[1]];
    return closestKth;
  }

  private int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}
