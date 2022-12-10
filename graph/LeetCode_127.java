package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class LeetCode_127 {

  class Pair {

    int count;
    String word;

    public Pair(int count, String word) {
      this.count = count;
      this.word = word;
    }

  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictionary = new HashSet<>(wordList);
    int wordLength = beginWord.length();
    Queue<Pair> bfs = new ArrayDeque<>();
    bfs.add(new Pair(0, beginWord));

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      String word = pair.word;
      if (endWord.equals(word)) {
        return pair.count + 1;
      }
      for (int i = 0; i < wordLength; i++) {
        char[] wordArray = word.toCharArray();
        for (char a = 'a'; a <= 'z'; a++) {
          wordArray[i] = a;
          String newWord = new String(wordArray);
          if (dictionary.contains(newWord)) {
            bfs.add(new Pair(pair.count + 1, newWord));
            dictionary.remove(newWord);
          }
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(new LeetCode_127().ladderLength("hit", "cog",
        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
  }
}
