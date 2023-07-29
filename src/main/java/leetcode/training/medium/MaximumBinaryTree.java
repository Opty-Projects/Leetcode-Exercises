package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

// https://leetcode.com/problems/maximum-binary-tree/
public class MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return bloom(nums, 0, nums.length - 1);
  }

  private TreeNode bloom(int[] nums, int l, int h) {
    if (l > h) return null;
    if (l == h) return new TreeNode(nums[l]);
    int maxIndex = maxIndex(nums, l, h);
    return new TreeNode(nums[maxIndex], bloom(nums, l, maxIndex - 1), bloom(nums, maxIndex + 1, h));
  }

  private int maxIndex(int[] nums, int l, int h) {
    int maxNum = Integer.MIN_VALUE;
    int maxIndex = l;
    for (int i = l; i <= h; i++) {
      if (nums[i] > maxNum) {
        maxNum = nums[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}
