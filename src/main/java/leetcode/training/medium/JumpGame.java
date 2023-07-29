package leetcode.training.medium;

// https://leetcode.com/problems/jump-game/
public class JumpGame {

  public boolean canJump(int[] nums) {
    int canJumpPosition = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= canJumpPosition) canJumpPosition = i;
    }
    return canJumpPosition == 0;
  }
}
