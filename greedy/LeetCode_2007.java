package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_2007 {

  public static int[] findOriginalArray(int[] changed) {
    if (changed.length % 2 != 0) {
      return new int[]{};
    }

    int arraySize = changed.length / 2;
    int[] originalArray = new int[arraySize];
    Map<Integer, Integer> intCount = new HashMap<>();
    Arrays.sort(changed);
    
    for (int value : changed) {
      int count = intCount.getOrDefault(value, 0) + 1;
      intCount.put(value, count);
    }

    int index = 0;
    for (int value : changed) {
      if (index == arraySize) {
        return originalArray;
      }
      if (intCount.getOrDefault(value, 0) <= 0) {
        continue;
      }
      // Reduce the double Count value
      int multiplyBy2 = value * 2;
      int x = intCount.getOrDefault(multiplyBy2, 0) - 1;
      intCount.put(multiplyBy2, x);
      if (-1 >= x) {
        continue;
      }
      if (intCount.getOrDefault(value, 0) > 0) {
        originalArray[index++] = value;
      }
      // Reduce the processed Value
      intCount.put(value, intCount.get(value) - 1);
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    int value[] = findOriginalArray(new int[]{3, 3, 3, 3});
    System.out.println(Arrays.toString(value));
  }

}
