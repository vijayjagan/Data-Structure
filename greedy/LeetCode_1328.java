package greedy;

public class LeetCode_1328 {

  public static String breakPalindrome(String palindrome) {
    int n = palindrome.length();
    if (n == 1) {
      return "";
    }
    int m = n >> 1;
    char[] palindromeArray = palindrome.toCharArray();
    for (int i = 0; i < n; i++) {
      if (palindromeArray[i] != 'a' && m != i) {
        palindromeArray[i] = 'a';
        return new String(palindromeArray);
      }
    }
    palindromeArray[n - 1] = 'b';
    return new String(palindromeArray);
  }

  public static void main(String[] args) {
    System.out.println(breakPalindrome("abccba"));
  }

}
