package leetcode.training.hard;

// https://leetcode.com/problems/stone-game-v/
public class StoneGameVIterative {

  public int stoneGameV(int[] stoneValue) {
    if (stoneValue.length <= 1) return 0;
    int[][] dp = new int[stoneValue.length][stoneValue.length];
    int[] accSum = new int[stoneValue.length];
    for (int i = 0; i < stoneValue.length; i++) {
      accSum[i] = (i > 0 ? accSum[i - 1] : 0) + stoneValue[i];
    }

    for (int n = 1; n < stoneValue.length; n++) {
      for (int l = 0; l < stoneValue.length - n; l++) {
        int h = l + n;
        for (int p = l; p < h; p++) {
          int sumL = accSum[p] - (l > 0 ? accSum[l - 1] : 0);
          int sumR = accSum[h] - accSum[p];

          int score;
          if (sumL < sumR) score = sumL + dp[l][p];
          else if (sumL > sumR) score = sumR + dp[p + 1][h];
          else score = sumL + Math.max(dp[l][p], dp[p + 1][h]);
          if (score > dp[l][h]) dp[l][h] = score;
        }
      }
    }
    return dp[0][stoneValue.length - 1];
  }
}
