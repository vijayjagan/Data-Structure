package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_899 {

  public static String orderlyQueue(String s, int k) {
    char[] arr = s.toCharArray();
    if (k > 1 || arr.length == 1) {
      Arrays.sort(arr);
      return new String(arr);
    }
    String builder = s;
    StringBuilder next = new StringBuilder(s);
    for (int i = 0; i < arr.length; i++) {
      char c = next.charAt(0);
      next.deleteCharAt(0).append(c);
      if (next.toString().compareTo(builder.toString()) < 0) {
        builder = next.toString();
      }
    }
    return builder;
  }


  public static void main(String[] args) {
    System.out.println('g' + 'i' < 'e' + 'o');

    System.out.println(orderlyQueue(
        "sjvcbjxtroukauekjdjeqqalowmcbwuwgqcviymaxqhajeodexqgwqymxrbghegfwmwdoayakuzavnaucpurjalxigdnnbkrzllmfkqkpvzxjapmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhlrgsjdpelkbsruooeffnvjwtsidzwkwxinisxzthwzjynzzvreap",
        1));
  }
}
