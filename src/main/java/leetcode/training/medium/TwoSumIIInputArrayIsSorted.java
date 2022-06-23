package leetcode.training.medium;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted {

  public int[] twoSum(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;
    while (l < h) {
      int sum = nums[l] + nums[h];
      if (sum < target) l++;
      else if (sum > target) h--;
      else return new int[] {l + 1, h + 1};
    }
    return null;
  }
}
