package leetcode.training.easy;

import leetcode.training.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> traversal = new ArrayList<>();
    if (root == null) return traversal;

    LinkedList<TreeNode> nodeStack = new LinkedList<>();
    while (true) {
      // All the way down to the left.
      for (; root != null; root = root.left) nodeStack.add(root);

      do {
        root = nodeStack.pollLast();
        if (root != null) traversal.add(root.val);
        else return traversal; // The stack got empty.
      } while (root.right == null);
      root = root.right;
    }
  }
}
