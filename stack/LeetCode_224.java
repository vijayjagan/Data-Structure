package stack;

public class LeetCode_224 {


  static int calculate(int exitingSum, int val, boolean isPlus) {
    if (isPlus) {
      return exitingSum + val;
    }
    return exitingSum - val;
  }

  static int calculate(int[] index, char[] arr) {
    if (index[0] == arr.length) {
      return 0;
    }
    int sum = 0;
    boolean isPlus = true;
    for (int i = index[0]; i < arr.length; i++) {
      char a = arr[i];
      if (a == ' ') {
        continue;
      }
      if (Character.isDigit(a)) {
        int val = a - '0';
        while (i + 1 < arr.length && Character.isDigit(arr[i + 1])) {
          val = (val * 10) + (arr[i + 1] - '0');
          i++;
        }
        sum = calculate(sum, val, isPlus);
      } else if (a == '+') {
        isPlus = true;
      } else if (a == '-') {
        isPlus = false;
      } else if (a == '(') {
        int[] nextIndex = {i + 1};
        int val = calculate(nextIndex, arr);
        sum = calculate(sum, val, isPlus);
        i = nextIndex[0];
      } else {
        index[0] = i;
        return sum;
      }
    }
    return sum;
  }


  public int calculate(String s) {
    return (calculate(new int[]{0}, s.trim().toCharArray()));
  }

  public static void main(String[] args) {
    String s = "200 + 400";
    System.out.println(new LeetCode_224().calculate(s));
  }

}
