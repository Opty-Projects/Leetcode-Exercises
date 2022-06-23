package leetcode.training.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class PermutationsRecursive {

  public List<List<Integer>> permute(int[] nums) {
    List<Integer> numbers = new ArrayList<>();
    for (int num : nums) numbers.add(num);
    List<List<Integer>> permutations = new ArrayList<>();
    permute(numbers, new ArrayList<>(), permutations);
    return permutations;
  }

  public void permute(List<Integer> numbers, List<Integer> perm, List<List<Integer>> permutations) {
    if (numbers.isEmpty()) {
      permutations.add(new ArrayList<>(perm));
      return;
    }
    for (int numIndex = 0; numIndex < numbers.size(); numIndex++) {
      int num = numbers.get(numIndex);
      numbers.remove(numIndex);
      perm.add(num);
      permute(numbers, perm, permutations);
      perm.remove(perm.size() - 1);
      numbers.add(numIndex, num);
    }
  }
}
