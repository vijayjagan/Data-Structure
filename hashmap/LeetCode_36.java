package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_36 {

  static <T> boolean checkData(Map<T, Set<Character>> map, T key, char data) {
    Set<Character> set = map.getOrDefault(key, new HashSet<>());
    if (set.contains(data)) {
      return false;
    }
    set.add(data);
    map.put(key, set);
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    Map<String, Set<Character>> interiorMap = new HashMap<>();
    Map<Integer, Set<Character>> rowMap = new HashMap<>();
    Map<Integer, Set<Character>> columnMap = new HashMap<>();
    int n = board.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        char val = board[i][j];
        // in-terms of row
        if (!checkData(rowMap, i, val)) {
          return false;
        }
        if (!checkData(columnMap, j , val)) {
          return false;
        }
        String key = i/3 + "x" + j/3;
        if (!checkData(interiorMap, key, val)) {
          return false;
        }
      }
    }
    return true;
  }

}
