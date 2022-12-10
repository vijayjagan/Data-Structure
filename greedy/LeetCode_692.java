package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LeetCode_692 {

  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordCountMap = new TreeMap<>();
    List<String> frequent = new ArrayList<>();
    for (String word : words) {
      wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
    }
    wordCountMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> {
          if (frequent.size() < k) {
            frequent.add(x.getKey());
          }
        });
    return frequent;
  }

  public static void main(String[] args) {
    String[] words = {"i","love","leetcode","i","love","coding"};
    System.out.println(topKFrequent(words, 3));
  }

}
