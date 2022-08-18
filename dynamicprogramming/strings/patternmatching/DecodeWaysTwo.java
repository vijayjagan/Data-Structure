package dynamicprogramming.strings.patternmatching;

import java.util.Arrays;

public class DecodeWaysTwo {


  static int mod = (int) Math.pow(10, 9) + 7;

  static long decodeString(int index, String s, long[] cache) {
    if (index == s.length()) {
      return 1;
    }

    if (index > s.length() || s.charAt(index) == '0') {
      return 0;
    }

    if (cache[index] != -1) {
      return cache[index];
    }

    long result = 0;

    if (s.charAt(index) == '*') {
      for (int i = 1; i <= 9; i++) {
        result += (decodeString(index + 1, s, cache) % mod);
      }
    } else {
      result += (decodeString(index + 1, s, cache) % mod);
    }

    if (index + 1 < s.length()) {
      if (s.charAt(index) == '1' && s.charAt(index + 1) == '*') {
        for (int i = 1; i <= 9; i++) {
          result += (decodeString(index + 2, s, cache) % mod);
        }
      } else if (s.charAt(index) == '2' && s.charAt(index + 1) == '*') {
        for (int i = 1; i <= 6; i++) {
          result += (decodeString(index + 2, s, cache) % mod);
        }
      } else if ((s.charAt(index) == '*' && s.charAt(index + 1) == '*')) {
        for (int i = 11; i <= 26; i++) {
          if (i == 20) {
            continue;
          }
          result += (decodeString(index + 2, s, cache) % mod);
        }
      } else if ((s.charAt(index) == '*' && s.charAt(index + 1) < '7')) {
        for (int i = 1; i <= 2; i++) {
          result += (decodeString(index + 2, s, cache) % mod);
        }
      } else if ((s.charAt(index) == '*' && s.charAt(index + 1) >= '7') || (
          (s.charAt(index) == '2' && s.charAt(index + 1) < '7')
              || s.charAt(index) == '1')) {
        result += (decodeString(index + 2, s, cache) % mod);
      }
    }
    return cache[index] = result % mod;
  }

  public int numDecodings(String s) {
    long[] cache = new long[s.length()];
    Arrays.fill(cache, -1);

    long result = decodeString(0, s, cache);
    return (int) result;
  }

  public static void main(String[] args) {
    System.out.println(new DecodeWaysTwo().numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
  }
}
