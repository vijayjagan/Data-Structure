package dynamicprogramming.strings.miscs;

public class EditDistance {
    public static int minDistance(int word1index, int word2index, String word1, String word2) {
        if (word1index  ==  0) {
            return word2index;
        }
        if (word2index ==  0) {
            return word1index;
        }

        if (word1.charAt(word1index - 1) == word2.charAt(word2index - 1)) {
            return minDistance(word1index - 1, word2index - 1, word1, word2);
        }
        int insertion = 1 + minDistance(word1index, word2index -1, word1, word2);
        int deletion = 1 + minDistance(word1index -1, word2index, word1, word2);
        int replace = 1 + minDistance(word1index - 1, word2index -1, word1, word2);
        return Math.min(insertion, Math.min(deletion, replace));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word1.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int word1index = 1; word1index <= word1.length(); word1index++) {
            for (int word2index = 1; word2index <= word2.length(); word2index++) {
                if (word1.charAt(word1index - 1) == word2.charAt(word2index - 1)) {
                    dp[word1index][word2index] = dp[word1index - 1][word2index - 1];
                } else {
                    int insertion = 1 + dp[word1index][word2index - 1];
                    int deletion = 1 + dp[word1index - 1][word2index];
                    int replace = 1 + dp[word1index - 1][word2index - 1];
                    dp[word1index][word2index] =  Math.min(insertion, Math.min(deletion, replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
