package Strings;

public class LeetCode_38 {

  public String countAndSay(int n) {
    if (n == 1) {
      return 1 + "";
    }
    StringBuilder countAndSay = new StringBuilder("1");
    while (--n != 0) {
      int length = countAndSay.length();
      int repeatCount = 0;
      StringBuilder nextString = new StringBuilder();
      for (int i = 0; i < length; i++) {
        if (i + 1 < length && countAndSay.charAt(i) == countAndSay.charAt(i + 1)) {
          repeatCount++;
        } else {
          nextString.append(++repeatCount).append(countAndSay.charAt(i));
          repeatCount = 0;
        }
      }
      countAndSay = nextString;
    }
    return countAndSay.toString();
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode_38().countAndSay(6));
  }

}
