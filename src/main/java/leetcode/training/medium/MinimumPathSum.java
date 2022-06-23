package leetcode.training.medium;

// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    if (grid.length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (r > 0 && c > 0) grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
        else if (r > 0) grid[r][c] += grid[r - 1][c];
        else if (c > 0) grid[r][c] += grid[r][c - 1];
      }
    }
    return grid[m - 1][n - 1];
  }
}
