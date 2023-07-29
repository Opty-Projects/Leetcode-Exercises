package leetcode.training.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int iN1 = 0; iN1 < nums.length - 2; iN1 = nextIndex(nums, iN1, true, nums.length - 2)) {
      int iN2 = iN1 + 1;
      int iN3 = nums.length - 1;

      while (iN2 < iN3) {
        int sum = nums[iN1] + nums[iN2] + nums[iN3];
        if (sum < 0) {
          iN2 = nextIndex(nums, iN2, true, iN3);
        } else if (sum > 0) {
          iN3 = nextIndex(nums, iN3, false, iN2);
        } else {
          result.add(List.of(nums[iN1], nums[iN2], nums[iN3]));
          iN2 = nextIndex(nums, iN2, true, iN3);
          iN3 = nextIndex(nums, iN3, false, iN2);
        }
      }
    }
    return result;
  }

  private int nextIndex(int[] nums, int index, boolean right, int boundary) {
    if (right) {
      do index++;
      while (nums[index - 1] == nums[index] && index < boundary);
    } else {
      do index--;
      while (nums[index] == nums[index + 1] && index > boundary);
    }
    return index;
  }
}
