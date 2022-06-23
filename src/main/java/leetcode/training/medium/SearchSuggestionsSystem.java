package leetcode.training.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystem {

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    List<List<String>> suggestions = new ArrayList<>();
    String prefix = "";
    for (char c : searchWord.toCharArray()) {
      prefix += c;
      suggestions.add(suggest(products, prefix, f(products, prefix)));
    }
    return suggestions;
  }

  private List<String> suggest(String[] products, String prefix, int index) {
    LinkedList<String> suggestions = new LinkedList<>();
    if (index < 0) return suggestions;
    suggestions.add(products[index]);

    for (int i = index - 1; i >= 0 && products[i].startsWith(prefix); i--) {
      if (suggestions.size() == 3) suggestions.pollLast();
      suggestions.add(0, products[i]);
    }
    for (int i = index + 1;
        suggestions.size() < 3 && i < products.length && products[i].startsWith(prefix);
        i++) {
      suggestions.add(products[i]);
    }
    return suggestions;
  }

  private int f(String[] products, String prefix) {
    int l = 0;
    int h = products.length - 1;
    while (l <= h) {
      int mid = (l + h) >>> 1;
      int cmp =
          products[mid]
              .substring(0, Math.min(products[mid].length(), prefix.length()))
              .compareTo(prefix);
      if (cmp < 0) l = mid + 1;
      else if (cmp > 0) h = mid - 1;
      else return mid;
    }
    return -1;
  }
}
