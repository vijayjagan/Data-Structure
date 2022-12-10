import java.util.HashMap;
import java.util.Map;

public class Trie {

  private Map<Character, Trie> characterTrieMap;
  private int endCount;
  private int prefixCount;


  public Trie() {
    characterTrieMap = new HashMap<>();
    endCount = 0;
    prefixCount = 0;
  }

  public void insert(String word) {
    char[] wordArr = word.toCharArray();
    Trie current = this;
    for (char c : wordArr) {
      Trie nextNode = current.characterTrieMap.get(c);
      if (nextNode == null) {
        nextNode = new Trie();
        current.characterTrieMap.put(c, nextNode);
      }
      current = nextNode;
      current.prefixCount++;
    }
    current.endCount++;
  }

  public int countWordsEqualTo(String word) {
    char[] wordArr = word.toCharArray();
    Trie current = this;
    for (char c : wordArr) {
      current = current.characterTrieMap.getOrDefault(c, null);
      if (current == null) {
        return 0;
      }
    }
    return current.endCount;
  }

  public int countWordsStartingWith(String word) {
    char[] wordArr = word.toCharArray();
    Trie current = this;
    for (char c : wordArr) {
      current = current.characterTrieMap.getOrDefault(c, null);
      if (current == null) {
        return 0;
      }
    }
    return current.prefixCount;
  }

  public void erase(String word) {
    if (erase(0, this, word.toCharArray())) {
      characterTrieMap.remove(word.charAt(0));
    }
  }

  private boolean erase(int index, Trie node, char[] wordArr) {
    if (node == null) {
      return false;
    }
    if (index == wordArr.length) {
      return --node.endCount == 0;
    }
    Trie nextNode = node.characterTrieMap.get(wordArr[index]);
    node.prefixCount--;
    node.endCount--;
    if (erase(index + 1, nextNode, wordArr)) {
      node.characterTrieMap.remove(wordArr[index]);
      return node.endCount == 0;
    }
    return false;
  }

  public boolean search(String word) {
    return search(0, word.toCharArray(), this);
  }

  private boolean search(int index, char[] word, Trie node) {
    if (index == word.length) {
      return node.endCount > 0;
    }
    Trie nextNode = node.characterTrieMap.get(word[index]);
    return nextNode != null && search(index + 1, word, nextNode);
  }

  public boolean startsWith(String word) {
    char[] wordArr = word.toCharArray();
    Trie current = this;
    for (char c : wordArr) {
      if (!current.characterTrieMap.containsKey(c)) {
        return false;
      }
      current = current.characterTrieMap.get(c);
    }
    return true;
  }

}
