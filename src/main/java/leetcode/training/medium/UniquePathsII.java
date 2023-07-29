package leetcode.training.medium;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] != 0) return 0;

    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (obstacleGrid[r][c] != 0) continue;
        if (r > 0 && obstacleGrid[r - 1][c] == 0) dp[r][c] += dp[r - 1][c];
        if (c > 0 && obstacleGrid[r][c - 1] == 0) dp[r][c] += dp[r][c - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
}
