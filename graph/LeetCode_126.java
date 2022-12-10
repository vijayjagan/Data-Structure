package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode_126 {


  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictionary = new HashSet<>(wordList);
    List<List<String>> ladders = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return ladders;
    }
    Queue<List<String>> bfs = new ArrayDeque<>();
    bfs.add(new ArrayList<>(Collections.singleton(beginWord)));
    int lengthOfWord = beginWord.length();

    while (!bfs.isEmpty()) {
      int size = bfs.size();
      List<String> visitedWords = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        List<String> words = bfs.poll();
        String lastWord = words.get(words.size() - 1);
        if (lastWord.equals(endWord)) {
          ladders.add(new ArrayList<>(words));
          continue;
        }
        for (int index = 0; index < lengthOfWord; index++) {
          char[] lastWordArray = lastWord.toCharArray();
          for (char a = 'a'; a <= 'z'; a++) {
            lastWordArray[index] = a;
            String newWord = new String(lastWordArray);
            if (dictionary.contains(newWord)) {
              List<String> nextSet = new ArrayList<>(words);
              nextSet.add(newWord);
              visitedWords.add(newWord);
              bfs.add(nextSet);
            }
          }
        }
      }
      for (String remove : visitedWords) {
        dictionary.remove(remove);
      }
    }
    return ladders;
  }

  public static void main(String[] args) {
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    System.out.println(new LeetCode_126().findLadders("hit", "cog", wordList));
  }

}
