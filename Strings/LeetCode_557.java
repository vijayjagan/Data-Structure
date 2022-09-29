package Strings;

public class LeetCode_557 {

  public String reverseWords(String s) {
    String[] s1 = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String value : s1) {
      stringBuilder.append(new StringBuilder(value).reverse());
    }
    return stringBuilder.toString();
  }

}
