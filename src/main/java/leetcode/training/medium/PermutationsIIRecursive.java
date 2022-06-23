package leetcode.training.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsIIRecursive {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<Integer> numbers = new ArrayList<>();
    Arrays.sort(nums);
    for (int num : nums) numbers.add(num);
    List<List<Integer>> permutations = new ArrayList<>();
    permuteUnique(numbers, new ArrayList<>(), permutations);
    return permutations;
  }

  public void permuteUnique(
      List<Integer> numbers, List<Integer> perm, List<List<Integer>> permutations) {
    if (numbers.isEmpty()) {
      permutations.add(new ArrayList<>(perm));
      return;
    }
    int numIndex = 0;
    while (true) {
      int num = numbers.get(numIndex);
      numbers.remove(numIndex);
      perm.add(num);
      permuteUnique(numbers, perm, permutations);
      perm.remove(perm.size() - 1);
      numbers.add(numIndex, num);
      do if (++numIndex == numbers.size()) return;
      while (numbers.get(numIndex - 1).equals(numbers.get(numIndex)));
    }
  }
}
