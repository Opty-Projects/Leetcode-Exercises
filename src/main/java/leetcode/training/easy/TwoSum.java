package leetcode.training.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> indexes = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!indexes.containsKey(target - nums[i])) indexes.put(nums[i], i);
      else return new int[] {i, indexes.get(target - nums[i])};
    }
    return null;
  }
}
