package leetcode.training.medium;

import java.util.Arrays;

// https://leetcode.com/problems/heaters/
public class Heaters {

  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int radius = Integer.MIN_VALUE;
    for (int house : houses) radius = Math.max(radius, findDistance(heaters, house));
    return radius;
  }

  public int findDistance(int[] heaters, int house) {
    int l = 0;
    int h = heaters.length - 1;
    while (l < h) {
      int mid = (l + h) / 2;
      if (heaters[mid] < house) l = mid + 1;
      else if (heaters[mid] > house) h = mid - 1;
      else return Math.abs(house - heaters[mid]);
    }
    int distance = Math.abs(house - heaters[l]);
    if (l > 0) distance = Math.min(distance, Math.abs(house - heaters[l - 1]));
    if (l < heaters.length - 1) distance = Math.min(distance, Math.abs(house - heaters[l + 1]));
    return distance;
  }
}
