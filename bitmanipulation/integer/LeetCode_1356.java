package bitmanipulation.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode_1356 {

  public int[] sortByBits(int[] arr) {
    Arrays.sort(arr);
    Map<Integer, List<Integer>> bitMap = new TreeMap<>();
    int[] sortedByBit = new int[arr.length];
    for (int value : arr) {
      int bitCount = Integer.bitCount(value);
      List<Integer> result = bitMap.getOrDefault(bitCount, new ArrayList<>());
      result.add(value);
      bitMap.put(bitCount, result);
    }
    int count = 0;
    for (Map.Entry<Integer, List<Integer>> entry : bitMap.entrySet()) {
      List<Integer> list = entry.getValue();
      if (list.isEmpty()) {
        continue;
      }
      for (Integer integer : list) {
        sortedByBit[count] = integer;
        count++;
      }
    }
    return sortedByBit;
  }


}
