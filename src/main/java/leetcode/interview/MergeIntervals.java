package leetcode.interview;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
    int index = 0;
    for (int pointer = 0; pointer < intervals.length; pointer++, index++) {
      intervals[index] = intervals[pointer];
      while (pointer + 1 < intervals.length && intervals[pointer + 1][0] < intervals[index][1]) {
        pointer++;
        if (intervals[pointer][1] > intervals[index][1]) {
          intervals[index][1] = intervals[pointer][1];
        }
      }
    }
    return Arrays.copyOf(intervals, index);
  }
}
