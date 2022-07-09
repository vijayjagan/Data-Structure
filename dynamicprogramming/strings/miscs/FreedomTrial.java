package dynamicprogramming.strings.miscs;

import java.util.Arrays;

public class FreedomTrial {

    public static int findRotateSteps(int ringPosition, int keyIndex, String ring, String key, int position, int [][] dp) {
        if (key.length() == keyIndex ) {
            return 0;
        }

        if (ring.length() == ringPosition) {
            ringPosition = 0;
        }

        if (ringPosition == -1) {
            ringPosition = ring.length() - 1;
        }

        if (dp[ringPosition][keyIndex] != -1) {
            return dp[ringPosition][keyIndex];
        }

        if (ring.charAt(ringPosition) == key.charAt(keyIndex)) {
            int nextState = keyIndex + 1 == key.length() ? 0 : 1;
            int stay = findRotateSteps(ringPosition, keyIndex + 1, ring, key, position, dp);
            int clock = nextState + findRotateSteps(ringPosition + 1, keyIndex + 1, ring, key, 1, dp);
            int antiClock = nextState + findRotateSteps(ringPosition - 1, keyIndex + 1, ring, key, -1, dp);
            return dp[ringPosition][keyIndex] = Math.min(stay, Math.min(clock, antiClock));
        }

        if (position == -1) {
            return dp[ringPosition][keyIndex] = 1 + findRotateSteps(ringPosition - 1, keyIndex, ring, key, -1, dp);
        }
        return dp[ringPosition][keyIndex] = 1 + findRotateSteps(ringPosition + 1, keyIndex, ring, key, 1, dp);
    }


    public static int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length()];
        for (int[] value : dp) {
            Arrays.fill(value, -1);
        }
        return key.length()
                + Math.min(findRotateSteps(0, 0, ring, key, 1, dp)
                , findRotateSteps(0, 0, ring, key, -1, dp));
    }
}
