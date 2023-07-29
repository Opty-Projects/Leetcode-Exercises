package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/print-binary-tree/
public class PrintBinaryTree {

  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> matrix = new ArrayList<>();
    if (root == null) return matrix;

    int height = height(root);
    int m = height + 1;
    int n = (1 << (height + 1)) - 1;

    for (int r = 0; r < m; r++) {
      List<String> row = new ArrayList<>();
      for (int c = 0; c < n; c++) row.add("");
      matrix.add(row);
    }
    fill(root, 0, (n - 1) / 2, 1 << (height - 1), matrix);
    return matrix;
  }

  private int height(TreeNode root) {
    return Math.max(
        root.left != null ? height(root.left) + 1 : 0,
        root.right != null ? height(root.right) + 1 : 0);
  }

  private void fill(TreeNode root, int r, int c, int hpadding, List<List<String>> matrix) {
    matrix.get(r).set(c, Integer.toString(root.val));
    if (root.left != null) fill(root.left, r + 1, c - hpadding, hpadding >>> 1, matrix);
    if (root.right != null) fill(root.right, r + 1, c + hpadding, hpadding >>> 1, matrix);
  }
}
