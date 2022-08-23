package dynamicprogramming.strings.patternmatching;

public class LeetCode_10 {


  static boolean isPatternMatchesEmptyString(int pIndex, String pattern) {
    if (pIndex == pattern.length()) {
      return true;
    }
    if (pattern.charAt(pIndex) == '*') {
      return isPatternMatchesEmptyString(pIndex + 1, pattern);
    }
    if (pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*') {
      return isPatternMatchesEmptyString(pIndex + 2, pattern);
    }
    return false;
  }


  static boolean isMatch(int sIndex, int pIndex, String s, String pattern, Boolean[][] cache) {
    if (sIndex == s.length() && pIndex == pattern.length()) {
      return true;
    }

    if (pIndex == pattern.length() && sIndex < s.length()) {
      return false;
    }

    if (sIndex == s.length() && pIndex < pattern.length()) {
      return isPatternMatchesEmptyString(pIndex, pattern);
    }

    if (cache[sIndex][pIndex] != null) {
      return cache[sIndex][pIndex];
    }

    boolean isNextCharStar = pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*';

    if (s.charAt(sIndex) == pattern.charAt(pIndex) || pattern.charAt(pIndex) == '.') {
      boolean isMatch = isMatch(sIndex + 1, pIndex + 1, s, pattern, cache);
      // If there is Match, try another possibility of ignoring the current Match
      if (isNextCharStar) {
        isMatch = isMatch || isMatch(sIndex, pIndex + 2, s, pattern, cache);
      }
      return cache[sIndex][pIndex] = isMatch;
    }

    if (pattern.charAt(pIndex) == '*') {
      if (s.charAt(sIndex) == pattern.charAt(pIndex - 1) || pattern.charAt(pIndex - 1) == '.') {
        return cache[sIndex][pIndex] =
            isMatch(sIndex + 1, pIndex, s, pattern, cache) // Stay in same index for further Match
                || isMatch(sIndex + 1, pIndex + 1, s, pattern, cache) // consider it is a Match
                || isMatch(sIndex, pIndex + 1, s, pattern, cache); // Star is Ignored
      }
      // Star is Ignored
      return cache[sIndex][pIndex] = isMatch(sIndex, pIndex + 1, s, pattern, cache);
    }

    if (isNextCharStar) {
      return cache[sIndex][pIndex] = isMatch(sIndex, pIndex + 2, s, pattern, cache);
    }

    return cache[sIndex][pIndex] = false;
  }

  public static boolean isMatch(String s, String p) {
    Boolean[][] cache = new Boolean[s.length()][p.length()];
    return isMatch(0, 0, s, p, cache);
  }

  public static void main(String[] args) {
    String[] s = {"ab", "aab", "a", "ab", "aaa", "a", "b", "aaca"};
    String[] pattern = {".*c", "c*a*b", "ab*", ".*c", "ab*a*c*a", "a*a", "aaa.", "ab*a*c*a"};
    boolean[] testCase = {false, true, true, false, true, true, false, true};
    for (int i = 0; i < s.length; i++) {
      if (testCase[i] != isMatch(s[i], pattern[i])) {
        System.out.println(s[i] + "\n" + pattern[i] + "\n");
      }
    }
  }

}
