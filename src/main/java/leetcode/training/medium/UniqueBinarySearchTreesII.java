package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    return bloom(1, n);
  }

  public List<TreeNode> bloom(int start, int end) {
    List<TreeNode> allNodes = new ArrayList<>();
    if (end < start) {
      allNodes.add(null);
      return allNodes;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> allL = bloom(start, i - 1);
      List<TreeNode> allR = bloom(i + 1, end);
      for (TreeNode L : allL) for (TreeNode R : allR) allNodes.add(new TreeNode(i, L, R));
    }
    return allNodes;
  }
}
