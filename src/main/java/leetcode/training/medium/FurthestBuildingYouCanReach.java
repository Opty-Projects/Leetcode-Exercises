package leetcode.training.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/furthest-building-you-can-reach/
public class FurthestBuildingYouCanReach {

  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> laddersMinHeap = ladders > 0 ? new PriorityQueue<>(ladders) : null;

    for (int index = 1; index < heights.length; index++) {
      int heightDifference = heights[index] - heights[index - 1];
      if (heightDifference <= 0
          || (laddersMinHeap != null
              && laddersMinHeap.size() < ladders
              && laddersMinHeap.add(heightDifference))) continue;

      if (laddersMinHeap == null || laddersMinHeap.peek() >= heightDifference) {
        bricks -= heightDifference;
      } else {
        bricks -= laddersMinHeap.poll();
        laddersMinHeap.add(heightDifference);
      }
      if (bricks < 0) return index - 1;
    }
    return heights.length - 1;
  }
}
