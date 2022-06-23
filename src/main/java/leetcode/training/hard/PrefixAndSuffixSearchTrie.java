package leetcode.training.hard;

// https://leetcode.com/problems/prefix-and-suffix-search/
public class PrefixAndSuffixSearchTrie {
  public static class WordFilter {

    private final TrieNode head = new TrieNode();

    public WordFilter(String[] words) {
      for (int i = 0; i < words.length; i++)
        for (int p = 0; p <= words[i].length(); p++)
          insert(words[i].substring(p) + '{' + words[i], i);
    }

    private void insert(String s, int index) {
      TrieNode node = head;
      for (char c : s.toCharArray()) {
        if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
        node = node.children[c - 'a'];
        node.index = index;
      }
    }

    public int f(String prefix, String suffix) {
      String s = suffix + '{' + prefix;
      TrieNode node = head;
      for (char c : s.toCharArray()) {
        if (node.children[c - 'a'] == null) return -1;
        node = node.children[c - 'a'];
      }
      return node.index;
    }

    private static class TrieNode {
      TrieNode[] children = new TrieNode[27];
      int index = -1;
    }
  }
}
