package leetcode.training.medium;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {

  public int myAtoi(String s) {
    char[] chars = s.toCharArray();
    if (chars.length == 0) return 0;
    int index = 0;

    while (chars[index] == ' ') if (++index >= chars.length) return 0;

    boolean negative = chars[index] == '-';
    if (negative) {
      if (++index >= chars.length) return 0;
    } else if (chars[index] == '+') {
      if (++index >= chars.length) return 0;
    }

    int result = 0;
    for (; index < chars.length; index++) {
      int digit = chars[index] - '0';
      if (digit < 0 || digit > 9) break;

      int newResult = result * 10 + digit;
      if (newResult < 0 || (newResult - digit) / 10 != result) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result = newResult;
    }
    return negative ? -result : result;
  }
}
