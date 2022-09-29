package bitmanipulation.integer;

public class LeetCode_1342 {


  public static int numberOfSteps(int num) {
    int count = 0;
    while (num != 0) {
      if ((num & 1) == 1 && num != 1) {
        count ++;
      }
      num = num >> 1;
      count ++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numberOfSteps(3));
  }

}
