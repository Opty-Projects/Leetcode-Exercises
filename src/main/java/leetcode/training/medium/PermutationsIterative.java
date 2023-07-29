package leetcode.training.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class PermutationsIterative {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    permutations.add(new ArrayList<>());

    for (int numIndex = 0; numIndex < nums.length; numIndex++) {
      int num = nums[numIndex];
      for (int permIndex = permutations.size() - 1; permIndex >= 0; permIndex--) {
        List<Integer> perm = permutations.get(permIndex);

        for (int insertionIndex = 1; insertionIndex <= numIndex; insertionIndex++) {
          List<Integer> p = new ArrayList<>(perm);
          p.add(insertionIndex, num);
          permutations.add(p);
        }
        perm.add(0, num);
      }
    }
    return permutations;
  }
}
