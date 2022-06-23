package leetcode.training.hard;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {

  public void solveSudoku(char[][] board) {
    boolean[][] rows = new boolean[board.length][9];
    boolean[][] columns = new boolean[board.length][9];
    boolean[][] boxes = new boolean[board.length][9];
    List<int[]> unfilled = new ArrayList<>();

    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (board[r][c] == '.') unfilled.add(new int[] {r, c});
        else {
          int val = board[r][c] - '1';
          boolean[] box = boxes[r / 3 * 3 + c / 3];
          rows[r][val] = columns[c][val] = box[val] = true;
        }
      }
    }
    solver(board, unfilled, rows, columns, boxes, 0);
  }

  private boolean solver(
      char[][] board,
      List<int[]> unfilled,
      boolean[][] rows,
      boolean[][] columns,
      boolean[][] boxes,
      int index) {
    if (index == unfilled.size()) return true;
    int[] coord = unfilled.get(index);
    int r = coord[0];
    int c = coord[1];
    boolean[] box = boxes[r / 3 * 3 + c / 3];

    for (int val = 0; val < 9; val++) {
      if (!rows[r][val] && !columns[c][val] && !box[val]) {
        rows[r][val] = columns[c][val] = box[val] = true;
        if (!solver(board, unfilled, rows, columns, boxes, index + 1)) {
          rows[r][val] = columns[c][val] = box[val] = false;
        } else {
          board[r][c] = (char) (val + '1');
          return true;
        }
      }
    }
    return false;
  }
}
