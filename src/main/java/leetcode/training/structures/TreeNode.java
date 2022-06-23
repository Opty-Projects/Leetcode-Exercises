package leetcode.training.structures;

import java.util.ArrayList;
import java.util.List;

/** Definition for a binary tree node. */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode create(Integer[] vals) {
    if (vals.length == 0) return null;
    int index = 0;
    TreeNode root = new TreeNode(vals[index++]);
    List<TreeNode> level = new ArrayList<>();
    level.add(root);
    do {
      List<TreeNode> nextLevel = new ArrayList<>();
      for (TreeNode node : level) {
        for (int i = 0; i <= 1; i++, index++) {
          if (index >= vals.length) return root;
          if (vals[index] == null) continue;
          TreeNode child = new TreeNode(vals[index]);
          nextLevel.add(i == 0 ? (node.left = child) : (node.right = child));
        }
      }
      level = nextLevel;
    } while (!level.isEmpty());
    return root;
  }

  @Override
  public String toString() {
    List<Integer> vals = new ArrayList<>();
    List<TreeNode> level = new ArrayList<>();
    level.add(this);
    do {
      List<TreeNode> nextLevel = new ArrayList<>();
      for (TreeNode node : level) {
        if (node != null) {
          vals.add(node.val);
          nextLevel.add(node.left);
          nextLevel.add(node.right);
        } else vals.add(null);
      }
      level = nextLevel;
    } while (!level.isEmpty());

    while (!vals.isEmpty() && vals.get(vals.size() - 1) == null) vals.remove(vals.size() - 1);
    return vals.toString();
  }
}
