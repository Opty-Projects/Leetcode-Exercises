package leetcode.training.hard;

import java.util.*;
import java.util.function.Function;

// https://leetcode.com/problems/prefix-and-suffix-search/
public class PrefixAndSuffixSearchSorting {
  public static class WordFilter {

    private final WordEntry[] prefixWords;
    private final WordEntry[] suffixWords;

    public WordFilter(String[] words) {
      WordEntry[] nonrepeatedWords = new WordEntry[words.length];
      Map<String, Integer> indexes = new HashMap<>();
      int pointer = 0;
      for (int i = 0; i < words.length; i++) {
        int index = indexes.getOrDefault(words[i], -1);
        if (index < 0) {
          index = pointer++;
          indexes.put(words[i], index);
        }
        nonrepeatedWords[index] = new WordEntry(i, words[i]);
      }

      prefixWords = Arrays.copyOfRange(nonrepeatedWords, 0, pointer);
      suffixWords = prefixWords.clone();

      Arrays.sort(prefixWords, Comparator.comparing(e -> e.word));
      Arrays.sort(suffixWords, Comparator.comparing(e -> e.reversed));
    }

    public int f(String prefix, String suffix) {
      int prefixIndex = fWordEntry(prefixWords, e -> e.word, prefix);
      if (prefixIndex < 0) return -1;
      suffix = new StringBuilder(suffix).reverse().toString();
      int suffixIndex = fWordEntry(suffixWords, e -> e.reversed, suffix);
      if (suffixIndex < 0) return -1;

      Set<Integer> indexes = fIndexes(prefixWords, e -> e.word, prefix, prefixIndex);
      indexes.retainAll(fIndexes(suffixWords, e -> e.reversed, suffix, suffixIndex));
      return !indexes.isEmpty() ? Collections.max(indexes) : -1;
    }

    private Set<Integer> fIndexes(
        WordEntry[] words, Function<WordEntry, String> toString, String prefix, int index) {
      Set<Integer> indexes = new HashSet<>();
      indexes.add(words[index].index);

      for (int i = index + 1; i < words.length && toString.apply(words[i]).startsWith(prefix); i++)
        indexes.add(words[i].index);
      for (int i = index - 1; i >= 0 && toString.apply(words[i]).startsWith(prefix); i--)
        indexes.add(words[i].index);
      return indexes;
    }

    private int fWordEntry(WordEntry[] words, Function<WordEntry, String> toString, String prefix) {
      int l = 0;
      int h = words.length - 1;
      while (l <= h) {
        int mid = (l + h) >>> 1;
        String s = toString.apply(words[mid]);
        int cmp = s.substring(0, Math.min(s.length(), prefix.length())).compareTo(prefix);
        if (cmp < 0) l = mid + 1;
        else if (cmp > 0) h = mid - 1;
        else return mid;
      }
      return -1;
    }

    private static class WordEntry {
      int index;
      String word;
      String reversed;

      WordEntry(int index, String word) {
        this.index = index;
        this.word = word;
        reversed = new StringBuilder(word).reverse().toString();
      }
    }
  }
}
