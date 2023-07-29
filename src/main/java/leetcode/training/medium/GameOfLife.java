package leetcode.training.medium;

// https://leetcode.com/problems/game-of-life/
public class GameOfLife {

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] count = new int[m][n];

    for (int r = 0; r < m; r++)
      for (int c = 0; c < n; c++)
        visit:
        for (int x = -1; x <= 1; x++)
          for (int y = -1; y <= 1; y++)
            if ((x != 0 || y != 0) && alive(board, r + y, c + x, m, n) && ++count[r][c] > 3)
              break visit;

    for (int r = 0; r < m; r++)
      for (int c = 0; c < n; c++)
        switch (board[r][c]) {
          case 0 -> {
            if (count[r][c] == 3) board[r][c] = 1;
          }
          case 1 -> {
            if (count[r][c] < 2 || count[r][c] > 3) board[r][c] = 0;
          }
        }
  }

  private boolean alive(int[][] board, int r, int c, int m, int n) {
    return r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 1;
  }
}
