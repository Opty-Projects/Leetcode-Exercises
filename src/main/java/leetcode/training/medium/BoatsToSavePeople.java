package leetcode.training.medium;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class BoatsToSavePeople {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int l = 0;
    int h = people.length - 1;
    int boats = 0;
    while (l <= h) {
      if (people[l] + people[h] <= limit) l++;
      h--;
      boats++;
    }
    return boats;
  }
}
