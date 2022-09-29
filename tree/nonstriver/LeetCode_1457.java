package tree.nonstriver;

import java.util.HashMap;
import java.util.Map;
import tree.TreeNode;

public class LeetCode_1457 {

  static boolean isPalindromicPath(Map<Integer, Integer> pathCount) {
    int oddCount = 0;
    int evenCount = 0;
    for (Map.Entry<Integer, Integer> entry : pathCount.entrySet()) {
      if (entry.getValue() == 0) {
        continue;
      }
      if (entry.getValue() % 2 == 0) {
        evenCount += entry.getValue();
      } else {
        oddCount++;
      }
    }
    return evenCount % 2 == 0 && oddCount <= 1;
  }

  static int pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> pathCount) {
    int palindromeCount = 0;

    int count = pathCount.getOrDefault(root.val, 0);
    pathCount.put(root.val, count + 1);

    if (root.left == root.right && isPalindromicPath(pathCount)) {
      palindromeCount = 1;
    }

    if (root.left != null) {
      palindromeCount += pseudoPalindromicPaths(root.left, pathCount);
    }

    if (root.right != null) {
      palindromeCount += pseudoPalindromicPaths(root.right, pathCount);
    }

    pathCount.put(root.val, pathCount.get(root.val) - 1);
    return palindromeCount;
  }

  public int pseudoPalindromicPaths(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return pseudoPalindromicPaths(root, new HashMap<>());
  }

}
