package leetcode.training.medium;

import java.util.Arrays;

// https://leetcode.com/problems/wiggle-sort-ii/
public class WiggleSortII {

  public void wiggleSort(int[] nums) {
    int[] sortedNums = nums.clone();
    Arrays.sort(sortedNums);
    int l = (nums.length - 1) / 2;
    int h = nums.length - 1;
    for (int i = 0; i < nums.length; i++) nums[i] = sortedNums[i % 2 == 0 ? l-- : h--];
  }
}
