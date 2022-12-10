package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode_947 {


  public static int removeStones(int[][] stones) {

    int maxRow = Integer.MIN_VALUE;
    int maxCol = Integer.MIN_VALUE;

    for (int[] stone : stones) {
      maxRow = Math.max(stone[0], maxRow);
      maxCol = Math.max(stone[1], maxCol);
    }
    // 0 Base Indexing or to avoid + 1 in coordinate shifting
    maxRow++;
    maxCol++;

    DisJoinSet disJoinSet = new DisJoinSet(maxRow + maxCol + 1);
    for (int[] stone : stones) {
      int row = stone[0];
      int col = maxRow + stone[1];
      disJoinSet.union(row, col);
    }

    Map<Integer, Integer> treeMap = new HashMap<>();
    for (int[] stone : stones) {
      int parent = disJoinSet.findUnion(stone[0]);
      int count = treeMap.getOrDefault(parent, 0) + 1;
      treeMap.put(parent, count);
    }

    int count = 0;

    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      count += entry.getValue();
    }
    return count - treeMap.size();
  }


  public static void main(String[] args) {
    System.out.println(removeStones(new int[][]{
        {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}
    ));
  }

}
