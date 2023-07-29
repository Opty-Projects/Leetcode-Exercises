package leetcode.training.medium;

// https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
    boolean positive = (dividend >= 0) == (divisor >= 0);
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    int threshold = 1 << 30;
    int pow2 = 0;
    while ((dividend - (divisor << pow2) >= 0) && ((divisor << pow2) < threshold)) pow2++;
    pow2 = Math.max(0, pow2 - 1);

    int quotient = 0;
    while (dividend - divisor >= 0) {
      while ((dividend - (divisor << pow2) < 0) && (pow2 > 0)) pow2--;
      dividend -= divisor << pow2;
      quotient += 1 << pow2;
    }
    return positive ? quotient : -quotient;
  }
}
