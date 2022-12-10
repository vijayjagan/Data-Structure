package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_1657 {


  public static boolean closeStrings(String word1, String word2) {
    char[] arr1 = word1.toCharArray();
    char[] arr2 = word2.toCharArray();

    if (arr1.length != arr2.length) {
      return false;
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    if (new String(arr1).equals(new String(arr2))) {
      return true;
    }
    Map<Character, Integer> word1Map = new HashMap<>();
    Map<Character, Integer> word2Map = new HashMap<>();

    for (char a : arr1) {
      word1Map.put(a, word1Map.getOrDefault(a, 0) + 1);
    }

    for (char a : arr2) {
      word2Map.put(a, word2Map.getOrDefault(a, 0) + 1);
    }

    if (!word1Map.keySet().equals(word2Map.keySet())) {
      return false;
    }

    List<Integer> list1 = new ArrayList<>(word1Map.values());
    List<Integer> list2 = new ArrayList<>(word2Map.values());
    Collections.sort(list1);
    Collections.sort(list2);
    return list1.equals(list2);
  }

  public static void main(String[] args) {
    System.out.println(closeStrings("uau", "ssx"));
  }

}
