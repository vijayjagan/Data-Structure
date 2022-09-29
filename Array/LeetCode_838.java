package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_838 {

  class Pair {

    char domPosition;
    int index;

    public Pair(char domPosition, int index) {
      this.domPosition = domPosition;
      this.index = index;
    }
  }

  public String pushDominoes(String dominoes) {
    char[] dominoesArray = dominoes.toCharArray();
    Queue<Pair> perSecondOrder = new LinkedList<>();

    for (int i = 0; i < dominoesArray.length; i++) {
      if (dominoesArray[i] != '.') {
        perSecondOrder.offer(new Pair(dominoesArray[i], i));
      }
    }

    while (!perSecondOrder.isEmpty()) {
      Pair pair = perSecondOrder.poll();
      char domPos = pair.domPosition;
      int domIndex = pair.index;

      if (domPos == 'L' && domIndex > 0 && dominoesArray[domIndex - 1] == '.') {
        dominoesArray[domIndex - 1] = 'L';
        perSecondOrder.offer(new Pair('L', domIndex - 1));
      } else if (domPos == 'R' && domIndex + 1 < dominoesArray.length
          && dominoesArray[domIndex + 1] == '.') {
        if (domIndex + 2 < dominoesArray.length && dominoesArray[domIndex + 2] == 'L') {
          perSecondOrder.poll();
          continue;
        }
        dominoesArray[domIndex + 1] = 'R';
        perSecondOrder.offer(new Pair('R', domIndex + 1));
      }
    }
    return new String(dominoesArray);
  }

  public static void main(String[] args) {
    String s = ".L.R...LR..L..";
    System.out.println(new LeetCode_838().pushDominoes(s));
  }
}
