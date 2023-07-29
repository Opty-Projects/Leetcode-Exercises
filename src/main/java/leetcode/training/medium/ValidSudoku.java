package leetcode.training.medium;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    boolean[][] rows = new boolean[board.length][9];
    boolean[][] columns = new boolean[board.length][9];
    boolean[][] boxes = new boolean[board.length][9];

    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c] == '.') continue;
        int val = board[r][c] - '1';
        boolean[] box = boxes[r / 3 * 3 + c / 3];
        if (!rows[r][val] && !columns[c][val] && !box[val]) {
          rows[r][val] = columns[c][val] = box[val] = true;
        } else return false;
      }
    }
    return true;
  }
}
