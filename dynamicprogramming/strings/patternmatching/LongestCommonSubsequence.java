package dynamicprogramming.strings.patternmatching;

public class LongestCommonSubsequence {


    static int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index, int[][] dp) {
        if (text1Index == 0 || text2Index == 0) {
            return 0;
        }

        if (dp[text1Index - 1][text2Index - 1] != -1) {
            return dp[text1Index - 1][text2Index - 1];
        }

        if (text1.charAt(text1Index - 1) == text2.charAt(text2Index - 1)) {
            return dp[text1Index - 1][text2Index - 1] = 1 + longestCommonSubsequence(text1, text2, text1Index - 1, text2Index - 1, dp);
        }
        return dp[text1Index - 1][text2Index - 1] = Math.max(longestCommonSubsequence(text1, text2, text1Index - 1, text2Index, dp)
                , longestCommonSubsequence(text1, text2, text1Index, text2Index - 1, dp));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    static String getLongestCommonSubSequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int text1Row = text1.length();
        int text2Column = text2.length();

        StringBuilder ans = new StringBuilder();

        while (text1Row > 0 && text2Column > 0) {
            if (text1.charAt(text1Row - 1) == text2.charAt(text2Column - 1)) {
                ans.append(text1.charAt(text1Row - 1));
                text1Row--;
                text2Column--;
            } else if (dp[text1Row - 1][text2Column] > dp[text1Row][text2Column - 1]) {
                ans.append(text1.charAt(text1Row - 1));
                text1Row--;
            } else {
                ans.append(text2.charAt(text2Column - 1));
                text2Column--;
            }
        }

        while (text1Row > 0) {
            ans.append(text1.charAt(text1Row - 1));
            text1Row--;
        }
        while (text2Column > 0) {
            ans.append(text2.charAt(text2Column - 1));
            text2Column--;
        }
        return ans.reverse().toString();
    }

    public static int canYouMake(String str, String ptr) {
        int common = longestCommonSubsequence(str, ptr);
        int deletion = ptr.length() - common;
        return Math.min(deletion + (str.length() - common), str.length() + ptr.length());
    }

}
