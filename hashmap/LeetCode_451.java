package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_451 {

  public String frequencySort(String s) {
    Map<Character, Integer> frequencyCount = new HashMap<>();
    char[] arr = s.toCharArray();
    for (char a : arr) {
      frequencyCount.put(a, frequencyCount.getOrDefault(a, 0) + 1);
    }
    StringBuilder frequencySort = new StringBuilder();
    List<int[]> sortedList = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : frequencyCount.entrySet()) {
      sortedList.add(new int[]{entry.getKey(), entry.getValue()});
    }
    sortedList.sort((a, b) -> b[1] - a[1]);
    for (int[] sorted : sortedList) {
      char a = (char) sorted[0];
      int length = sorted[1];
      while (length-- >= 0) {
        frequencySort.append(a);
      }
    }
    return frequencySort.toString();
  }
}
