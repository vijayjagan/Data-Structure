package bitmanipulation.integer;

public class LeetCode_1680 {

//  1 + 5

  static int rightMostBit(int n ) {
    int count = 0;
    while (n > 0) {
      n >>= 1;
      count ++;
    }
    return count;
  }

  public static int concatenatedBinary(int n) {
    long sum = 1;
    for (int i = 2; i <= n; i++) {
      sum = (sum << rightMostBit(i)) | i;
      sum %= 1000000007;
    }
    return (int)sum;
  }

  public static void main(String[] args) {
    System.out.println(concatenatedBinary(12));
  }
}
