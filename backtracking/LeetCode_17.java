package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17 {


  void fillTheCombination(int index, String digits, StringBuilder localDigits,
      Map<Character, String> phoneMap, List<String> list) {

    if (index == digits.length()) {
      list.add(localDigits.toString());
      return;
    }

    char[] alphabet = phoneMap.get(digits.charAt(index)).toCharArray();

    for (char c : alphabet) {
      localDigits.append(c);
      fillTheCombination(index + 1, digits, localDigits, phoneMap, list);
      localDigits.deleteCharAt(localDigits.length() - 1);
    }
  }


  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    if (digits.length() == 0) {
      return list;
    }
    Map<Character, String> phoneNumberMap = new HashMap<>();
    phoneNumberMap.put('2', "abc");
    phoneNumberMap.put('3', "def");
    phoneNumberMap.put('4', "ghi");
    phoneNumberMap.put('5', "jkl");
    phoneNumberMap.put('6', "mno");
    phoneNumberMap.put('7', "pqrs");
    phoneNumberMap.put('8', "tuv");
    phoneNumberMap.put('9', "wxyz");
    fillTheCombination(0, digits, new StringBuilder(), phoneNumberMap, list);
    return list;
  }

  public static void main(String[] args) {
    new LeetCode_17().letterCombinations("23");
  }

}
