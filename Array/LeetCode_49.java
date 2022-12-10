package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anaGramMap = new HashMap<>();
    for (String word : strs) {
      char [] wordArr = word.toCharArray();
      Arrays.sort(wordArr);
      String key = new String(wordArr);
      List<String> wordList = anaGramMap.getOrDefault(key, new ArrayList<>());
      wordList.add(word);
      anaGramMap.put(key, wordList);
    }
    List<List<String>> groupedList = new ArrayList<>();
    for (Map.Entry<String,List<String>> entry : anaGramMap.entrySet()) {
      groupedList.add(entry.getValue());
    }
    return groupedList;
  }

}
