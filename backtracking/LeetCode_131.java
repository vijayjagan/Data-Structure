package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_131 {

  List<List<String>> partitionList;

  boolean isPalindrome(String s) {
    if (s.length() == 1) {
      return true;
    }

    char[] sArray = s.toCharArray();

    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (sArray[i] != sArray[j]) {
        return false;
      }
    }
    return true;
  }


  void fillThePartitionListArray(int index, String s, List<String> localList) {
    if (index == s.length()) {
      partitionList.add(new ArrayList<>(localList));
      return;
    }

    for (int i = index; i < s.length(); i++) {
      String newString = s.substring(index, i + 1);
      if (isPalindrome(newString)) {
        localList.add(newString);
        fillThePartitionListArray(i + 1, s, localList);
        localList.remove(localList.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    partitionList = new ArrayList<>();
    fillThePartitionListArray(0, s, new ArrayList<>());
    System.out.println(partitionList);
    return partitionList;
  }


  public static void main(String[] args) {
    new LeetCode_131().partition("abba");
  }

}
