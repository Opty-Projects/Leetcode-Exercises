package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

import java.util.*;

// https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleFullBinaryTrees {

  public List<TreeNode> allPossibleFBT(int n) {
    if (n < 1 || n % 2 == 0) return new ArrayList<>();
    Map<Integer, List<TreeNode>> allTrees = new HashMap<>();
    allTrees.put(1, List.of(new TreeNode(0)));
    for (int i = 3; i <= n; i += 2) {
      List<TreeNode> allTreesForN = new ArrayList<>();
      for (int lN = 1, rN = i - 2; lN <= i - 2; lN += 2, rN -= 2)
        for (TreeNode lTree : allTrees.get(lN))
          for (TreeNode rTree : allTrees.get(rN)) allTreesForN.add(new TreeNode(0, lTree, rTree));
      allTrees.put(i, allTreesForN);
    }
    return allTrees.get(n);
  }
}
