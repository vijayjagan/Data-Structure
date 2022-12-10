public class LeetCode_421 {


  class Trie {

    Trie[] links;
    boolean isEnd;

    public Trie() {
      links = new Trie[2];
    }

    public void add(String data) {
      char[] dataArr = data.toCharArray();
      Trie root = this;
      for (int i = 0; i < data.length(); i++) {
        int binary = Integer.parseInt(String.valueOf(dataArr[i]));
        if (root.links[binary] == null) {
          root.links[binary] = new Trie();
        }
        root = root.links[binary];
      }
      root.isEnd = true;
    }
  }


  public int findMaximumXOR(int[] nums) {
    Trie trie = new Trie();
    int maxXor = Integer.MIN_VALUE;
    for (int num : nums) {
      trie.add(Integer.toBinaryString(num));
    }
    for (int num : nums) {
      Trie trie1 = trie;
      StringBuilder binaryVal = new StringBuilder();
      for (int binary = 31; binary >-1 ; binary--) {
        int bin = Integer.parseInt(String.valueOf(binary));
        int oppo = 1 - bin;
        if (trie1.links[oppo] != null) {
          trie1 = trie1.links[oppo];
          binaryVal.append(oppo);
        } else {
          trie1 = trie1.links[bin];
          binaryVal.append(bin);
        }
      }
      maxXor = Math.max(Integer.parseInt(binaryVal.toString(), 2), maxXor);
    }
    return maxXor;
  }


  public static void main(String[] args) {
    System.out.println(new LeetCode_421().findMaximumXOR(
        new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
  }


}
