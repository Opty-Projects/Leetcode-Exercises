package leetcode.training.hard;

public class UniquePathsIII {

  public int uniquePathsIII(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    // Find the starting point!
    int[] initialPos = null;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1) {
          initialPos = new int[] {r, c};
          break;
        }
      }
    }
    if (initialPos == null) return 0;

    int[][] trails = new int[m][n];
    return travel(grid, trails, m, n, initialPos);
  }

  private int travel(int[][] grid, int[][] trails, int m, int n, int[] pos) {
    if (grid[pos[0]][pos[1]] == 2) {
      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          if (trails[r][c] == 0 && grid[r][c] == 0) {
            // The path does not include all squares.
            return 0;
          }
        }
      }
      // Found the ending point!
      return 1;
    }
    // Travel sideways.
    int walks = 0;
    trails[pos[0]][pos[1]] = 1;
    if (pos[0] > 0 && trails[pos[0] - 1][pos[1]] == 0 && grid[pos[0] - 1][pos[1]] != -1) {
      walks += travel(grid, trails, m, n, new int[] {pos[0] - 1, pos[1]});
    }
    if (pos[1] > 0 && trails[pos[0]][pos[1] - 1] == 0 && grid[pos[0]][pos[1] - 1] != -1) {
      walks += travel(grid, trails, m, n, new int[] {pos[0], pos[1] - 1});
    }
    if (pos[0] < m - 1 && trails[pos[0] + 1][pos[1]] == 0 && grid[pos[0] + 1][pos[1]] != -1) {
      walks += travel(grid, trails, m, n, new int[] {pos[0] + 1, pos[1]});
    }
    if (pos[1] < n - 1 && trails[pos[0]][pos[1] + 1] == 0 && grid[pos[0]][pos[1] + 1] != -1) {
      walks += travel(grid, trails, m, n, new int[] {pos[0], pos[1] + 1});
    }
    trails[pos[0]][pos[1]] = 0;
    return walks;
  }
}
