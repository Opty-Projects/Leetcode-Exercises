package leetcode.training.medium;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int maxArea = 0;
    int l = 0;
    int h = height.length - 1;
    while (l < h) {
      int area = (h - l) * Math.min(height[l], height[h]);
      if (area > maxArea) maxArea = area;

      if (height[l] > height[h]) {
        do h--;
        while (l < h && maxArea > (h - l) * height[h]);
      } else {
        do l++;
        while (l < h && maxArea > (h - l) * height[l]);
      }
    }
    return maxArea;
  }
}
