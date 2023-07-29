package leetcode.training.medium;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {

  public int jump(int[] nums) {
    int jumps = 0;
    int positionJumpedTo = 0;
    int maxAttainablePosition = 0;
    int position = 0;

    while (positionJumpedTo < nums.length - 1) {
      if (position + nums[position] > maxAttainablePosition) {
        maxAttainablePosition = position + nums[position];
      }
      if (position++ == positionJumpedTo) {
        positionJumpedTo = maxAttainablePosition;
        jumps++;
      }
    }
    return jumps;
  }
}
