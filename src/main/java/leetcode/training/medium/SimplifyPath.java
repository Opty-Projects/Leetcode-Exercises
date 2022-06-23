package leetcode.training.medium;

// https://leetcode.com/problems/simplify-path/
public class SimplifyPath {

  public String simplifyPath(String path) {
    StringBuilder simplified = new StringBuilder("/");
    int index = skipSlashes(path, 1);
    while (index < path.length()) {
      switch (path.charAt(index)) {
        case '/':
          index = skipSlashes(path, index + 1);
          if (index < path.length()) simplified.append('/');
          break;
        case '.':
          if (path.charAt(index - 1) == '/') {
            if (index == path.length() - 1 || path.charAt(index + 1) == '/') {
              index = skipSlashes(path, index + 2);
              break;
            }
            if (path.charAt(index + 1) == '.'
                && (index == path.length() - 2 || path.charAt(index + 2) == '/')) {
              index = skipSlashes(path, index + 3);
              if (simplified.length() > 1) {
                simplified.deleteCharAt(simplified.length() - 1);
                removeLast(simplified, false);
              }
              break;
            }
          }
        default:
          simplified.append(path.charAt(index++));
      }
    }
    removeLast(simplified, true);
    return simplified.toString();
  }

  private int skipSlashes(String path, int index) {
    while (index < path.length() && path.charAt(index) == '/') index++;
    return index;
  }

  private void removeLast(StringBuilder simplified, boolean slash) {
    while (simplified.length() > 1 && (simplified.charAt(simplified.length() - 1) == '/') == slash)
      simplified.deleteCharAt(simplified.length() - 1);
  }
}
