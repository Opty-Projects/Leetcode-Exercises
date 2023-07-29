package leetcode.training.medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

  public boolean hasAllCodes(String s, int k) {
    int length = s.length();
    if (length <= k) return false;

    Set<String> codes = new HashSet<>();
    for (int i = 0; i + k <= length; i++) codes.add(s.substring(i, i + k));
    return codes.size() == (1 << k);
  }
}
