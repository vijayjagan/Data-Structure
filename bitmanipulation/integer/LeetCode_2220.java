package bitmanipulation.integer;

public class LeetCode_2220 {

  public static int minBitFlips(int start, int goal) {
    int bit = start ^ goal;
    int count = 0;
    while (bit != 0) {
      count += (bit & 1);
      bit >>= 1;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minBitFlips(3, 4));
  }


}
