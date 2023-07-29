package leetcode.training.medium;

// https://leetcode.com/problems/combination-sum-iv/
public class CombinationSumIV {

  public int combinationSum4(int[] nums, int target) {
    if (nums.length == 0) return 0;
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int t = 1; t <= target; t++) for (int num : nums) if (num <= t) dp[t] += dp[t - num];
    return dp[target];
  }
}
