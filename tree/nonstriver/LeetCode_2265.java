package tree.nonstriver;

import java.util.HashMap;
import java.util.Map;
import tree.TreeNode;

public class LeetCode_2265 {

  int updateMapWithTotal(Map<TreeNode, Integer> averageOfNode, TreeNode root) {
    if (root == null) {
      return 0;
    }
    int total =
        root.val + updateMapWithTotal(averageOfNode, root.left) + updateMapWithTotal(averageOfNode,
            root.right);
    averageOfNode.put(root, total);
    return total;
  }

  int updateMapWithAverage(Map<TreeNode, Integer> averageOfNode, TreeNode root) {
    if (root == null) {
      return 0;
    }
    int total = averageOfNode.get(root);
    int count =
        1 + updateMapWithAverage(averageOfNode, root.left) + updateMapWithAverage(averageOfNode,
            root.right);
    averageOfNode.put(root, total / count);
    return count;
  }

  int countOfAverage(Map<TreeNode, Integer> averageOfNode, TreeNode root) {
    if (root == null) {
      return 0;
    }

    int value = averageOfNode.get(root);
    int count = root.val == value ? 1 : 0;
    return  count + countOfAverage(averageOfNode, root.left) + countOfAverage(
        averageOfNode, root.right);
  }

  public int averageOfSubtree(TreeNode root) {
    Map<TreeNode, Integer> map = new HashMap<>();
    updateMapWithTotal(map, root);
    updateMapWithAverage(map, root);
    System.out.println(map);
    return countOfAverage(map, root);
  }

}
