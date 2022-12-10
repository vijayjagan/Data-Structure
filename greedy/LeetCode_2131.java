package greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_2131 {

  static  int longestPalindrome(String[] words) {
    Map<String, Integer> wordMap = new HashMap<>();
    int count = 0;
    for (String word : words) {
      String reverse = word.charAt(1) + "" + word.charAt(0);
      if (wordMap.containsKey(reverse)) {
        count += 4;
        wordMap.put(reverse, wordMap.get(reverse) - 1);
        if (wordMap.get(reverse) == 0) {
          wordMap.remove(reverse);
        }
      } else {
        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
      }
    }
    for (String word : wordMap.keySet()) {
      if (word.charAt(0) == word.charAt(1)) {
        return count + 2;
      }
    }
    return count;
  }

  public static void main(String[] args) {

    System.out.println(longestPalindrome(new String[]{"fo", "fo", "qf", "of", "of"}));
  }

}
