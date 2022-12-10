package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LeetCode_433 {

  class Pair {

    String word;
    int count;

    public Pair(String word, int count) {
      this.word = word;
      this.count = count;
    }
  }

  public int minMutation(String start, String end, String[] bank) {
    Queue<Pair> bfs = new ArrayDeque<>();

    Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
    char[] combination = {'A', 'C', 'G', 'T'};
    bfs.offer(new Pair(start, 0));

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      if (end.equals(pair.word)) {
        return pair.count;
      }
      for (int i = 0; i < pair.word.length(); i++) {
        char[] wordArr = pair.word.toCharArray();
        for (char c : combination) {
          wordArr[i] = c;
          String newWord = new String(wordArr);
          if (bankSet.contains(newWord)) {
            bfs.offer(new Pair(newWord, pair.count + 1));
            bankSet.remove(newWord);
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String start = "AACCTTGG";
    String end = "AATTCCGG";
    String[] word = {"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};
    System.out.println(new LeetCode_433().minMutation(start, end, word));
  }

}
