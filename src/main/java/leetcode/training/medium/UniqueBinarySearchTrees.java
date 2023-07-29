package leetcode.training.medium;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTrees {

  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i / 2; j++) dp[i] += dp[j] * dp[i - j - 1] * 2;
      if (i % 2 != 0) dp[i] += dp[(i - 1) / 2] * dp[(i - 1) / 2];
    }
    return dp[n];
  }
}
