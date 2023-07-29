package leetcode.training.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class CombinationsRecursive {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    combine(n, k, new ArrayList<>(), combinations);
    return combinations;
  }

  public void combine(int n, int k, List<Integer> comb, List<List<Integer>> combinations) {
    if (k == 0) {
      combinations.add(new ArrayList<>(comb));
      return;
    }
    for (int num = !comb.isEmpty() ? comb.get(comb.size() - 1) + 1 : 1; num <= n - k + 1; num++) {
      comb.add(num);
      combine(n, k - 1, comb, combinations);
      comb.remove(comb.size() - 1);
    }
  }
}
