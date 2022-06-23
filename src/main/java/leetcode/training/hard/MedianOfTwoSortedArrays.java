package leetcode.training.hard;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Index = (nums1.length - 1) / 2;
    int nums2Index = (nums1.length + nums2.length - 1) / 2 - Math.min(nums1Index + 1, nums1.length);

    while (greaterThan(get(nums2, nums2Index), get(nums1, nums1Index + 1))) {
      nums1Index++;
      nums2Index--;
    }
    while (greaterThan(get(nums1, nums1Index), get(nums2, nums2Index + 1))) {
      nums1Index--;
      nums2Index++;
    }

    double result = max(get(nums1, nums1Index), get(nums2, nums2Index));
    if ((nums1.length + nums2.length) % 2 != 0) return result;
    return (result + min(get(nums1, nums1Index + 1), get(nums2, nums2Index + 1))) / 2;
  }

  private Integer get(int[] nums, int index) {
    return (index >= 0 && index < nums.length) ? nums[index] : null;
  }

  private boolean greaterThan(Integer a, Integer b) {
    return a != null && b != null && a > b;
  }

  private int max(Integer a, Integer b) {
    return a != null && b != null
        ? Math.max(a, b)
        : a != null ? a : b != null ? b : Integer.MIN_VALUE;
  }

  private int min(Integer a, Integer b) {
    return a != null && b != null
        ? Math.min(a, b)
        : a != null ? a : b != null ? b : Integer.MAX_VALUE;
  }
}
