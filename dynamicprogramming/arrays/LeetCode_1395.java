package dynamicprogramming.arrays;

public class LeetCode_1395 {


  static int totalCount(int index, int prevIndex, int soldierCount, int[] rating,
      Integer[][][] cache) {

    if (soldierCount == 3) {
      return 1;
    }

    if (index == rating.length) {
      return 0;
    }

    if (cache[index][prevIndex + 1][soldierCount] != null) {
      return cache[index][prevIndex + 1][soldierCount];
    }

    int increasingOrder = 0;
    int notPickUp = totalCount(index + 1, prevIndex, soldierCount, rating, cache);

    if (prevIndex == -1 || rating[prevIndex] < rating[index]) {
      increasingOrder = totalCount(index + 1, index, soldierCount + 1, rating,
          cache);
    }
    return cache[index][prevIndex + 1][soldierCount] = increasingOrder + notPickUp;
  }

  public static int numberOfTeams(int[] rating) {
    int[] reverseRating = new int[rating.length];
    Integer[][][] cache = new Integer[rating.length][rating.length + 1][3];
    Integer[][][] cacheTwo = new Integer[rating.length][rating.length + 1][3];
    for (int i = reverseRating.length - 1, j = 0; i > -1 && j < reverseRating.length; i--, j++) {
      reverseRating[i] = rating[j];
    }
    int increaseCount = totalCount(0, -1, 0, rating, cache);
    int decreaseCount = totalCount(0, -1, 0, reverseRating, cacheTwo);
    return increaseCount + decreaseCount;
  }


  public static void main(String[] args) {
    int[] rating = {2, 5, 3, 4, 1};
    System.out.println(numberOfTeams(rating));
  }
}
