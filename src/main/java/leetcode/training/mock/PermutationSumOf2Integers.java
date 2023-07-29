package leetcode.training.mock;

public class PermutationSumOf2Integers {

  public boolean isPermutationSum(int A, int B, int C) {
    Number numA = new Number(A);
    Number numB = new Number(B);
    // To ensure that the number A is the longest.
    return numA.length() > numB.length() ? f(numA, numB, 0, C) : f(numB, numA, 0, C);
  }

  public boolean f(Number numA, Number numB, int carry, int C) {
    if (C == 0 && carry == 0) {
      // All numbers have been used.
      return numA.length() == 0 && numB.length() == 0;
    }
    int dC = C % 10;
    C /= 10;
    for (int dA = 0; dA < 10; dA++) {
      int dB = dC - dA - carry;
      if (dB < 0) dB = dB % 10 + 10;
      if (!numA.contains(dA) || !numB.contains(dB)) continue;
      numA.remove(dA);
      numB.remove(dB);
      if (f(numA, numB, (dA + dB + carry) / 10, C)) return true;
      numA.add(dA);
      numB.add(dB);
    }
    return false;
  }

  private static class Number {
    private final int[] numberOfDigits = new int[10];
    private int n = 0;

    public Number(int num) {
      while (num != 0) {
        add(num % 10);
        num /= 10;
      }
    }

    private void add(int digit) {
      numberOfDigits[digit]++;
      n++;
    }

    private void remove(int digit) {
      numberOfDigits[digit]--;
      n--;
    }

    private boolean contains(int digit) {
      return numberOfDigits[digit] > 0 || (n == 0 && digit == 0);
    }

    private int length() {
      return n;
    }
  }
}
