package Strings;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_1544 {


  public static String makeGood(String s) {
    StringBuilder good = new StringBuilder();
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char val : arr) {
      if (stack.isEmpty()) {
        stack.push(val);
      } else {
        char prev = stack.peek();
        if (Math.abs(prev - val) == 32) {
          stack.pop();
        } else {
          stack.push(val);
        }
      }
    }
    while (!stack.isEmpty()) {
      good.append(stack.pop());
    }
    return good.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(makeGood("abBAcC"));
  }

}
