package leetcode.training.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    Map<Integer, Integer> indexes = new HashMap<>();
    int length = 0;
    int longestLength = 0;

    int index = -1;
    for (char c : s.toCharArray()) {
      Integer previousIndex = indexes.put((int) c, ++index);

      if (previousIndex == null) length++;
      else {
        if (length > longestLength) longestLength = length;
        length = index - previousIndex;
        indexes.entrySet().removeIf(e -> e.getValue() <= previousIndex);
      }
    }

    return Math.max(length, longestLength);
  }
}
