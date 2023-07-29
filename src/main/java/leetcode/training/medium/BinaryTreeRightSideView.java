package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    if (root == null) return values;

    List<TreeNode> level = new ArrayList<>();
    level.add(root);
    do {
      values.add(level.get(0).val);
      List<TreeNode> newLevel = new ArrayList<>();
      for (TreeNode node : level) {
        if (node.right != null) newLevel.add(node.right);
        if (node.left != null) newLevel.add(node.left);
      }
      level = newLevel;
    } while (!level.isEmpty());
    return values;
  }
}
