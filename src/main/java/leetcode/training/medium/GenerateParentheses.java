package leetcode.training.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    joinParenthesis("", 0, 0, n, result);
    return result;
  }

  public void joinParenthesis(
      String parenthesis, int opened, int closed, int n, List<String> result) {
    if (closed == n) result.add(parenthesis);
    else {
      if (opened > closed) joinParenthesis(parenthesis + ')', opened, closed + 1, n, result);
      if (opened < n) joinParenthesis(parenthesis + '(', opened + 1, closed, n, result);
    }
  }
}
