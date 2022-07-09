package dynamicprogramming.strings.patternmatching;

public class WildCard {
    public static boolean isMatch(int sindex, int pindex, String s, String p, Boolean[][] dp) {
        if (sindex == 0 && pindex == 0) {
            return true;
        }

        if (pindex == 0 && sindex > 0) {
            return false;
        }

        if (sindex == 0 && pindex > 0) {
            for (int i = 1; i <= pindex; i++) {
                if (p.charAt(i - 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[sindex][pindex] != null) {
            return dp[sindex][pindex];
        }

        if (s.charAt(sindex - 1) == p.charAt(pindex - 1) || p.charAt(pindex - 1) == '?') {
            return dp[sindex][pindex] = isMatch(sindex - 1, pindex - 1, s, p, dp);
        }
        if (p.charAt(pindex - 1) == '*') {
            return dp[sindex][pindex] = isMatch(sindex, pindex - 1, s, p, dp) || isMatch(sindex - 1, pindex, s, p, dp);
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s.length(), p.length(), s, p, dp);
    }

}
