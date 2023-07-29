package leetcode.training.medium;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {

  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        int j = i + 1;
        while (j < nums.length - 1 && nums[i] < nums[j + 1]) j++;
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
        return;
      }
    }
    reverse(nums, 0, nums.length - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private void reverse(int[] nums, int l, int h) {
    for (int i = l, mid = (l + h + 1) >> 1, j = h; i < mid; i++, j--) swap(nums, i, j);
  }
}
