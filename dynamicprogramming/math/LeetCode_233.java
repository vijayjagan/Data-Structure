package dynamicprogramming.math;

public class LeetCode_233 {


  static int countOne(int n ) {
    int count = 0;
    while (n != 0) {
      if (n % 10 == 1) {
        count ++;
      }
      n/=10;
    }
    return count;
  }
  public static int countDigitOne(int n) {
    int count = 0;
    while (n != 0) {
      count += countOne(n);
      n--;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countDigitOne(824883294));
  }
}
