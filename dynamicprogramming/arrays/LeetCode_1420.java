package dynamicprogramming.arrays;

public class LeetCode_1420 {


  static int maxIndex(int[] arr) {
    int maxValue = -1;
    int maxIndex = -1;
    int searchCost = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (maxValue < arr[i]) {
        maxValue = arr[i];
        maxIndex = i;
        searchCost++;
      }
    }
    System.out.println(searchCost);
    return maxIndex;
  }

//  public int numOfArrays(int n, int m, int k) {
//
//  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 2, 1};
    maxIndex(arr);
  }

}
