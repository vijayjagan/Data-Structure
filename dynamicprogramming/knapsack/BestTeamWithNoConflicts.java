package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestTeamWithNoConflicts {

  class Player {

    int score;
    int age;

    public Player(int score, int age) {
      this.score = score;
      this.age = age;
    }

    public int getScore() {
      return score;
    }

    public int getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Player{" +
          "score=" + score +
          ", age=" + age +
          '}';
    }
  }

  static int bestTeam(int pointer, int lastPlayerScore, int lastPlayerAge,
      List<Player> playerList) {

    if (pointer == playerList.size()) {
      return 0;
    }

    Player player = playerList.get(pointer);

    int highScoreAndAge = 0;

    // Current player has high scorer than previous player and age is equal or above
    if (
        (player.score > lastPlayerScore && player.age >= lastPlayerAge)
            || (player.score < lastPlayerScore && player.age <= lastPlayerAge)
            || (player.score == lastPlayerScore)
    ) {
      highScoreAndAge =
          player.score + bestTeam(pointer + 1, player.score, player.age, playerList);
    }

    int notPick = bestTeam(pointer + 1, lastPlayerScore, lastPlayerAge, playerList);

    return Math.max(highScoreAndAge, notPick);
  }

  static int bestTeam(int pointer, int prevIndex, List<Player> playerList, Integer[][] cache) {

    if (pointer == playerList.size()) {
      return 0;
    }

    if ( cache[pointer][prevIndex + 1] != null) {
      return cache[pointer][prevIndex + 1];
    }

    Player player = playerList.get(pointer);
    Player prevPlayer = prevIndex == -1 ? null : playerList.get(prevIndex);

    int notPick = bestTeam(pointer + 1, prevIndex, playerList, cache);

    int pick = 0;
    if (prevIndex == - 1 || prevPlayer.score <= player.score) {
      pick = player.score + bestTeam(pointer + 1, pointer, playerList, cache);
    }

    return cache[pointer][prevIndex + 1] = Math.max(pick, notPick);
  }

  public int bestTeamScore(int[] scores, int[] ages) {
    List<Player> playerList = new ArrayList<>();
    int maxScore = Integer.MIN_VALUE;
    for (int i = 0; i < scores.length; i++) {
      maxScore = Math.max(scores[i], maxScore);
      playerList.add(new Player(scores[i], ages[i]));
    }

    Integer[][] cache = new Integer[scores.length + 1][scores.length + 1];

    // Sort the Object based on Players age and score
    playerList.sort(Comparator.comparing(Player::getAge));

    return bestTeam(0, -1, playerList, cache);
  }

  public static void main(String[] args) {
    int[] score = {4, 5, 6, 5};
    int[] ages = {2, 1, 2, 1};
    System.out.println(new BestTeamWithNoConflicts().bestTeamScore(score, ages));
  }

}
