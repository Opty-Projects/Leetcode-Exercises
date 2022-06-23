package leetcode.training.hard;

// https://leetcode.com/problems/stone-game-v/
public class StoneGameVRecursive {

  public int stoneGameV(int[] stoneValue) {
    if (stoneValue.length <= 1) return 0;
    int sum = 0;
    for (int value : stoneValue) sum += value;
    int[][] dp = new int[stoneValue.length][stoneValue.length];
    return play(stoneValue, 0, stoneValue.length - 1, sum, dp);
  }

  private int play(int[] stoneValue, int l, int h, int sum, int[][] dp) {
    if (l >= h) return 0;
    if (dp[l][h] != 0) return dp[l][h];

    int maxScore = 0;
    int sumL = 0;
    for (int p = l; p < h; p++) {
      sumL += stoneValue[p];
      int score;
      if (sumL < sum - sumL) {
        score = sumL;
        score += play(stoneValue, l, p, sumL, dp);
      } else if (sumL > sum - sumL) {
        score = sum - sumL;
        score += play(stoneValue, p + 1, h, sum - sumL, dp);
      } else {
        score = sumL;
        score += Math.max(play(stoneValue, l, p, sumL, dp), play(stoneValue, p + 1, h, sumL, dp));
      }
      if (score > maxScore) maxScore = score;
    }
    dp[l][h] = maxScore;
    return maxScore;
  }
}
