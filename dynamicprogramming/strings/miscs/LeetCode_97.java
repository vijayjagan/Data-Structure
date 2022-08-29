package dynamicprogramming.strings.miscs;

public class LeetCode_97 {


  boolean isInterLeave(int s1Index, int s2Index, String s1, String s2, String s3,
      Boolean[][] cache) {

    if (s1Index + s2Index == s3.length()) {
      return true;
    }

    if (s1Index >= s1.length() && s2Index >= s2.length()) {
      return false;
    }

    if (s1Index >= s1.length()) {
      return s2.charAt(s2Index) == s3.charAt(s1Index + s2Index) && isInterLeave(s1Index,
          s2Index + 1, s1, s2, s3, cache);
    }

    if (s2Index >= s2.length()) {
      return s1.charAt(s1Index) == s3.charAt(s1Index + s2Index) && isInterLeave(s1Index + 1,
          s2Index, s1, s2, s3, cache);
    }

    if (cache[s1Index][s2Index] != null) {
      return cache[s1Index][s2Index];
    }

    boolean isStringS1Equal = s1.charAt(s1Index) == s3.charAt(s1Index + s2Index);
    boolean isStringS2Equal = s2.charAt(s2Index) == s3.charAt(s1Index + s2Index);

    if (isStringS1Equal && isStringS2Equal) {
      return cache[s1Index][s2Index] = isInterLeave(s1Index + 1, s2Index, s1, s2, s3, cache) ||
          isInterLeave(s1Index, s2Index + 1, s1, s2, s3, cache);
    }

    if (isStringS1Equal) {
      return cache[s1Index][s2Index] = isInterLeave(s1Index + 1, s2Index, s1, s2, s3, cache);
    }

    if (isStringS2Equal) {
      return cache[s1Index][s2Index] = isInterLeave(s1Index, s2Index + 1, s1, s2, s3, cache);
    }

    return cache[s1Index][s2Index] = false;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    Boolean[][] cache = new Boolean[s1.length()][s2.length()];
    return isInterLeave(0, 0, s1, s2, s3, cache);
  }

  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";
    System.out.println(new LeetCode_97().isInterleave(s1, s2, s3));
  }

}
