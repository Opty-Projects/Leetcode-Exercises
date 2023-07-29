package leetcode.training.medium;

import java.util.*;

// https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystemTreeMap {

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    TreeMap<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < products.length; i++) map.put(products[i], i);

    List<String> productsList = Arrays.asList(products);
    List<List<String>> suggestionsList = new ArrayList<>();
    String prefix = "";
    for (char c : searchWord.toCharArray()) {
      prefix += c;
      Map.Entry<String, Integer> ceilingEntry = map.ceilingEntry(prefix);
      if (ceilingEntry == null) break;
      Map.Entry<String, Integer> floorEntry = map.floorEntry(prefix + '{');
      if (floorEntry == null) break;

      int length = Math.min(ceilingEntry.getValue() + 3, floorEntry.getValue() + 1);
      suggestionsList.add(productsList.subList(ceilingEntry.getValue(), length));
    }

    for (int i = suggestionsList.size(); i < searchWord.length(); i++)
      suggestionsList.add(new ArrayList<>());
    return suggestionsList;
  }
}
