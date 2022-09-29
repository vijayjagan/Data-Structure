package bitmanipulation.integer;

import java.util.Arrays;

public class LeetCode_476 {


  public static int findComplement(int num) {
    int leadingZeros = Integer.numberOfLeadingZeros(num);
    int activeBitFromMSB = 32 - leadingZeros;
    int value = 0;
    int count = 0;

    num = ~num;
    while (activeBitFromMSB-- != 0) {
      value = value | ((num & 1) << count);
      count++;
      num >>= 1;
    }
    return value;
  }

  public static void main(String[] args) {

  }
}
