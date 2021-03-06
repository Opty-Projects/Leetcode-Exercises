package leetcode.training.easy;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {

  public int search(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;
    while (l < h) {
      int mid = (l + h) / 2;
      if (nums[mid] < target) l = mid + 1;
      else if (nums[mid] > target) h = mid - 1;
      else return mid;
    }
    return nums[l] == target ? l : -1;
  }
}
