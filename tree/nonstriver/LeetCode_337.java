package tree.nonstriver;

import java.util.HashMap;
import java.util.Map;
import tree.TreeNode;

public class LeetCode_337 {


  static int robber(TreeNode root, boolean canWePick, Map<TreeNode, Map<Boolean, Integer>> cache) {

    if (root == null) {
      return 0;
    }

    Map<Boolean, Integer> memoization = cache.getOrDefault(root, null);

    if (memoization != null && memoization.containsKey(canWePick)) {
      return memoization.get(canWePick);
    }

    int basedOnPrevState = 0;

    if (canWePick) {
      basedOnPrevState = root.val + robber(root.left, false, cache) + robber(root.right, false, cache);
    }

    int ignoreCurrentState = robber(root.left, true, cache) + robber(root.right, true, cache);

    Map<Boolean, Integer> cacheMap = new HashMap<>();
    cacheMap.put(canWePick,  Math.max(basedOnPrevState, ignoreCurrentState));
    cache.put(root, cacheMap);

    return Math.max(basedOnPrevState, ignoreCurrentState);
  }


  public int rob(TreeNode root) {
    Map<TreeNode, Map<Boolean, Integer>> cache = new HashMap<>();
    return robber(root,true, cache);
  }

}
