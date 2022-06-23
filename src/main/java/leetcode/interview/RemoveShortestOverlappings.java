package leetcode.interview;

import java.util.*;

public class RemoveShortestOverlappings {

  public int[][] removeShortestOverlappings(int[][] intervals) {
    Arrays.sort(
        intervals, Comparator.comparingInt((int[] i) -> i[1]).thenComparingInt((int[] i) -> i[0]));
    TreeMap<Integer, Map.Entry<Integer, List<int[]>>> longestCombinationsEnd = new TreeMap<>();

    for (int pointer = 0; pointer < intervals.length; pointer++) {
      Map.Entry<Integer, List<int[]>> longest = null;
      // Let's record the longest length combination that ends at a lower end.
      Map.Entry<Integer, Map.Entry<Integer, List<int[]>>> e =
          longestCombinationsEnd.lowerEntry(intervals[pointer][1]);
      if (e != null) longest = e.getValue();

      do {
        int[] interval = intervals[pointer];
        int length = interval[1] - interval[0];
        List<int[]> combination = null;

        // Let's combine the longest combination that ends in an end <= start of this interval.
        e = longestCombinationsEnd.floorEntry(interval[0]);
        if (e != null) {
          length += e.getValue().getKey();
          combination = e.getValue().getValue();
        }
        if (longest == null || length > longest.getKey()) {
          combination = combination != null ? new ArrayList<>(combination) : new ArrayList<>();
          combination.add(interval);
          longest = Map.entry(length, combination);
        }

        pointer++;
      } while (pointer < intervals.length && intervals[pointer - 1][1] == intervals[pointer][1]);
      pointer--;

      longestCombinationsEnd.put(intervals[pointer][1], longest);
    }
    return longestCombinationsEnd.lastEntry().getValue().getValue().toArray(new int[0][0]);
  }
}
