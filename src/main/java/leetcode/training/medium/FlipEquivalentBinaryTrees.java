package leetcode.training.medium;

import leetcode.training.structures.TreeNode;

// https://leetcode.com/problems/flip-equivalent-binary-trees/
public class FlipEquivalentBinaryTrees {

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (!equals(root1, root2)) return false;
    if (root1 == null) return true;

    if (!equals(root1.left, root2.left)) {
      TreeNode temp;
      temp = root1.left;
      root1.left = root1.right;
      root1.right = temp;
    }
    return equals(root1.left, root2.left)
        && equals(root1.right, root2.right)
        && flipEquiv(root1.left, root2.left)
        && flipEquiv(root1.right, root2.right);
  }

  private boolean equals(TreeNode a, TreeNode b) {
    return a != null && b != null ? a.val == b.val : a == b;
  }
}
