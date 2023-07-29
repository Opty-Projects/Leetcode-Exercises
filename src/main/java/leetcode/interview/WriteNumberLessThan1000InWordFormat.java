package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class WriteNumberLessThan1000InWordFormat {

  public String convert(int num) {
    if (num <= 0 || num >= 1000) return num == 0 ? numbersUpTo20[0] : null;
    List<String> s = new ArrayList<>();
    int hundreds = num / 100;
    num %= 100;
    if (hundreds > 0) s.add(numbersUpTo20[hundreds] + " " + dozensNumbers[10]);
    if (num >= 20) {
      int dozens = num / 10;
      num %= 10;
      s.add(dozensNumbers[dozens]);
    }
    if (num > 0) s.add(numbersUpTo20[num]);
    return String.join(" ", s);
  }

  private final String[] numbersUpTo20 =
      new String[] {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen"
      };
  private final String[] dozensNumbers =
      new String[] {
        null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
        "hundred"
      };
}
