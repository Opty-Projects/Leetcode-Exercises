package leetcode.training.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class CombinationsIterative {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    combinations.add(new ArrayList<>());

    for (; k > 0; k--) {
      for (int combIndex = combinations.size() - 1; combIndex >= 0; combIndex--) {
        List<Integer> comb = combinations.get(combIndex);

        for (int num = !comb.isEmpty() ? comb.get(comb.size() - 1) + 1 : 1; num <= n - k; num++) {
          List<Integer> c = new ArrayList<>(comb);
          c.add(num);
          combinations.add(c);
        }
        comb.add(n - k + 1);
      }
    }
    return combinations;
  }
}
