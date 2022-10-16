package dynamicprogramming.strings.miscs;

public class LeetCode_1531 {


  public int getLengthOfOptimalCompression(String s, int k) {
    int len = s.length();
    Integer[][][][] cache = new Integer[len + 1][27][len + 1][k + 1];
    return getMinimumLength(s.toCharArray(), 0, (char) ('a' + 26), 0, k, cache);
  }

  int getMinimumLength(char[] s, int pointer, char previousCharacter, int encodingCount, int k,
      Integer[][][][] cache) {
    if (k < 0) {
      return Integer.MAX_VALUE;
    }
    if (pointer >= s.length) {
      return 0;
    }
    if (cache[pointer][previousCharacter - 'a'][encodingCount][k] != null) {
      return cache[pointer][previousCharacter - 'a'][encodingCount][k];
    }
    int minLength;
    if (s[pointer] == previousCharacter) {
      int length = encodingCount == 1 || encodingCount == 9 || encodingCount == 99 ? 1 : 0;
      minLength =
          getMinimumLength(s, pointer + 1, previousCharacter, encodingCount + 1, k, cache) + length;
    } else {
      int deleteTheCharacter = getMinimumLength(s, pointer + 1, previousCharacter, encodingCount,
          k - 1, cache);
      int skipDelete = getMinimumLength(s, pointer + 1, s[pointer], 1, k, cache) + 1;
      minLength = Math.min(deleteTheCharacter, skipDelete);
    }
    return cache[pointer][previousCharacter - 'a'][encodingCount][k] = minLength;
  }


  public static void main(String[] args) {
    LeetCode_1531 leetCode_1531 = new LeetCode_1531();
    System.out.println(leetCode_1531.getLengthOfOptimalCompression("aaabcccd", 2));
  }
}
