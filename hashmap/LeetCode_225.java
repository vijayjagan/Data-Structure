package hashmap;

import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LeetCode_225 {

  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> playerWinCount = new HashMap<>();
    Map<Integer, Integer> playerLooseCount = new HashMap<>();
    for (int[] match : matches) {
      int winner = match[0];
      int loser = match[1];
      int winCount = playerWinCount.getOrDefault(winner, 0) + 1;
      int loseCount = playerLooseCount.getOrDefault(loser, 0) + 1;
      playerWinCount.put(winner, winCount);
      playerLooseCount.put(loser, loseCount);
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : playerWinCount.entrySet()) {
      int player = entry.getKey();
      if (!playerLooseCount.containsKey(player)) {
        list1.add(player);
      }
    }

    for (Map.Entry<Integer, Integer> entry : playerLooseCount.entrySet()) {
      int player = entry.getKey();
      int count = entry.getValue();
      if (count == 1) {
        list2.add(player);
      }
    }

    List<List<Integer>> winnerList = new ArrayList<>();
    Collections.sort(list1);
    Collections.sort(list2);
    winnerList.add(list1);
    winnerList.add(list2);

    return winnerList;

  }


//  public List<List<Integer>> findWinners(int[][] matches) {
//    // 0 - Win
//    // 1 - Loss
//    int[][] resultTracker = new int[100001][2];
//    for (int[] match : matches) {
//      int winner = match[0];
//      int loser = match[1];
//      resultTracker[winner][0]++;
//      resultTracker[loser][1]++;
//    }
//    List<List<Integer>> winnerList = new ArrayList<>();
//    List<Integer> list1 = new ArrayList<>();
//    List<Integer> list2 = new ArrayList<>();
//
//    for (int player = 0; player < resultTracker.length; player++) {
//      int winCount = resultTracker[player][0];
//      int lossCount = resultTracker[player][1];
//
//      if (winCount >= 1 && lossCount == 0) {
//        list1.add(player);
//      } else if (lossCount == 1) {
//        list2.add(player);
//      }
//    }
//    winnerList.add(list1);
//    winnerList.add(list2);
//    return winnerList;
//  }

}
