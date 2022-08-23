package tree.nonstriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_1104 {

  public static List<Integer> pathInZigZagTree(int label) {
    if (label == 1) {
      return new ArrayList<>(Collections.singletonList(1));
    }
    List<Integer> path = new ArrayList<>();
    int labelLevel = 1;
    int levelMaxValue = 1;

    while (label > levelMaxValue) {
      levelMaxValue = (int) Math.pow(2, labelLevel++) - 1;
    }
    labelLevel--;

    int nodeVal = label;

    while (labelLevel != 0) {
      path.add(0, nodeVal);
      int currentLevelMax = (int) Math.pow(2, labelLevel) - 1;
      int currentNodeCount = (int) Math.pow(2, labelLevel - 1);
      labelLevel--;
      int totalNodeCount = (int) Math.pow(2, labelLevel - 1);
      int maxNodeVal = (int) Math.pow(2, labelLevel) - 1;
      if (labelLevel % 2 == 0) {
        int currentStartingNodeVal = (currentLevelMax - currentNodeCount) + 1;
        int parentOrder = Math.abs(nodeVal - currentStartingNodeVal) / 2;
        nodeVal = maxNodeVal - parentOrder;
      } else {
        int parentOrder = (currentLevelMax - nodeVal) / 2; // 0-base Indexing
        nodeVal = maxNodeVal - totalNodeCount + 1 + parentOrder; // +1 due to 0-base Indexing
      }
    }
    return path;
  }


  public static void main(String[] args) {
    System.out.println(pathInZigZagTree(3));
  }

}
