package greedy;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode_2142 {

  static int calculateMin(int a, int b, int existMin) {
    if (a > 0 || b > 0) {
      return Math.min(existMin, a + b);
    }
    return existMin;
  }

  static int minimumSum(int num) {
    char[] array = (num + "").toCharArray();
    Arrays.sort(array);
    String newString = new String(array);
    int min = Integer.MAX_VALUE;
    int firstPair = Integer.parseInt(newString.charAt(0) + "" + newString.charAt(1) + "");
    int secondPair = Integer.parseInt(newString.charAt(2) + "" + newString.charAt(3) + "");
    min = calculateMin(firstPair, secondPair, min);

    firstPair = Integer.parseInt(newString.charAt(0) + "" + newString.charAt(2) + "");
    secondPair = Integer.parseInt(newString.charAt(1) + "" + newString.charAt(3) + "");
    min = calculateMin(firstPair, secondPair, min);

    firstPair = Integer.parseInt(newString.charAt(0) + "" + newString.charAt(3) + "");
    secondPair = Integer.parseInt(newString.charAt(1) + "" + newString.charAt(2) + "");
    min = calculateMin(firstPair, secondPair, min);

    return min;
  }

  public static void main(String[] args) {
    System.out.println(minimumSum(1000));
  }

}
