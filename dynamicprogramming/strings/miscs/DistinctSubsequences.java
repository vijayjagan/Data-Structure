package dynamicprogramming.strings.miscs;

public class DistinctSubsequences {
    static int numDistinct(int sindex, int tindex, String s, String t) {
        if (tindex ==  0) {
            return 1;
        }
        if (sindex ==  0) {
            return 0;
        }

        if (s.charAt(sindex - 1) == t.charAt(tindex - 1)) {
            return numDistinct(sindex - 1, tindex - 1, s, t)
                    + numDistinct(sindex - 1, tindex, s, t);
        }
        return numDistinct(sindex - 1, tindex, s, t);
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int sindex = 1; sindex <= s.length(); sindex++) {
            for (int tindex = 1; tindex <= t.length(); tindex++) {
                if (s.charAt(sindex - 1) == t.charAt(tindex - 1)) {
                    dp[sindex][tindex] = dp[sindex - 1][tindex - 1] + dp[sindex - 1][tindex];
                } else {
                    dp[sindex][tindex] = dp[sindex - 1][tindex];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
