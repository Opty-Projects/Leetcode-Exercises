package leetcode.training.medium;

import java.util.Arrays;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {

  public String convert(String s, int numRows) {
    if (numRows <= 1) return s;
    String[] matrix = new String[numRows];
    Arrays.fill(matrix, "");

    int index = 0;
    boolean toggle = true;
    for (char c : s.toCharArray()) {
      matrix[index] += c;

      if (toggle) {
        if (++index == numRows - 1) toggle = false;
      } else {
        if (--index == 0) toggle = true;
      }
    }

    StringBuilder result = new StringBuilder(matrix[0]);
    for (int i = 1; i < numRows; i++) result.append(matrix[i]);
    return result.toString();
  }
}
