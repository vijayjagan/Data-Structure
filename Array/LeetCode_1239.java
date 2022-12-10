package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode_1239 {

  static int maxLength(int index, String word, List<String> arr) {
    if (index == arr.size()) {
      return 0;
    }
    String newWord = word + arr.get(index);
    char[] newWordArray = newWord.toCharArray();
    Set<Character> uniqueChar = new HashSet<>();
    for (char c : newWordArray) {
      uniqueChar.add(c);
    }
    int currentWord = uniqueChar.size() == newWord.length()
        ? Math.max(newWord.length(), maxLength(index + 1, newWord, arr)) : -1;
    return Math.max(currentWord, maxLength(index + 1, word, arr));
  }

  public int maxLength(List<String> arr) {
    return maxLength(0, "", arr);
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode_1239().maxLength(Arrays.asList("un", "iq", "ue")));
  }

}
