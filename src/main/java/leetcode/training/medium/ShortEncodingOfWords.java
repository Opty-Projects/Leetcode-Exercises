package leetcode.training.medium;

import java.util.Arrays;

// https://leetcode.com/problems/short-encoding-of-words/
public class ShortEncodingOfWords {

  public int minimumLengthEncoding(String[] words) {
    for (int i = 0; i < words.length; i++)
      words[i] = new StringBuilder(words[i]).reverse().toString();
    Arrays.sort(words);

    int length = 0;
    for (int i = 0; i < words.length; i++)
      if (i == words.length - 1 || !words[i + 1].startsWith(words[i]))
        length += words[i].length() + 1;
    return length;
  }
}
