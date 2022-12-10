package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode_1235 {

  class Tuple {

    int startTime;
    int endTime;
    int profit;

    public Tuple(int startTime, int endTime, int profit) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.profit = profit;
    }
  }

  public static int lowerBound(int target, List<Tuple> dataList) {
    int low = 0, up = dataList.size();
    while (low < up) {
      int mid = (low + up) / 2;
      if (target <= dataList.get(mid).startTime) {
        up = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }


  static int jobScheduling(int index, List<Tuple> dataList, Integer[] cache) {
    if (index >= dataList.size()) {
      return 0;
    }

    if (cache[index] != null) {
      return cache[index];
    }
    Tuple currentJob = dataList.get(index);
    int pickTheJob = currentJob.profit;
    int nextJobIndex = lowerBound(currentJob.endTime, dataList);
    if (nextJobIndex < dataList.size()) {
      pickTheJob += jobScheduling(nextJobIndex, dataList, cache);
    }
    int notPickTheJob = jobScheduling(index + 1, dataList, cache);
    return cache[index] = Math.max(pickTheJob, notPickTheJob);
  }


  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int len = profit.length;
    List<Tuple> dataList = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      dataList.add(new Tuple(startTime[i], endTime[i], profit[i]));
    }
    dataList.sort(Comparator.comparingInt(data -> data.startTime));
    int[] cache = new int[len + 1];
    for (int index = len - 1; index > -1; index--) {
      Tuple currentJob = dataList.get(index);
      int pickTheJob = currentJob.profit;
      int nextJobIndex = lowerBound(currentJob.endTime, dataList);
      if (nextJobIndex < dataList.size()) {
        pickTheJob += cache[nextJobIndex];
      }
      int notPickTheJob = cache[index + 1];
      cache[index] = Math.max(pickTheJob, notPickTheJob);
    }
    return cache[0];
  }

  public static void main(String[] args) {
    int[] startTime = {1, 2, 3, 3};
    int[] endTime = {3, 4, 5, 6};
    int[] profit = {50, 10, 40, 70};
    int maxProfit = new LeetCode_1235().jobScheduling(startTime, endTime, profit);
    System.out.println(maxProfit);
  }

}
