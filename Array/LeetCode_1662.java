package Array;

import java.util.Arrays;

public class LeetCode_1662 {

  public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return String.join("",word1).equals(String.join("",word2));
  }

  public static void main(String[] args) {
    System.out.println(String.join("", new String[]{"ab","c"}));
  }

}
