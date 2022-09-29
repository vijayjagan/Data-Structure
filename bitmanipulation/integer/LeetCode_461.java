package bitmanipulation.integer;

public class LeetCode_461 {


  static int lsb(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      if ((n & 1) != 0) {
        return count;
      }
      n >>= 1;
    }
    return count;
  }

  public int hammingDistance(int x, int y) {

    return Math.abs(lsb(x) - lsb(y));
  }

  public static void main(String[] args) {
    System.out.println(lsb(3));
  }

}
