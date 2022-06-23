package leetcode.training.medium;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    int[] pal = new int[] {0, 0};

    int l = (s.length() - 1) / 2;
    int h = l + 1;
    boolean toggle = true;
    do {
      int index = toggle ? l-- : h++;
      toggle = !toggle;

      pal = max(pal, max(expand(s, index, index), expand(s, index, index + 1)));
    } while (toggle || h + (pal[1] - pal[0]) / 2 < s.length());

    return s.substring(pal[0], pal[1]);
  }

  private int[] expand(String s, int l, int h) {
    while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
      l--;
      h++;
    }
    return new int[] {l + 1, h};
  }

  private int[] max(int[] palA, int[] palB) {
    return palA[1] - palA[0] > palB[1] - palB[0] ? palA : palB;
  }
}
