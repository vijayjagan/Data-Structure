package greedy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1383 {

  class Engineer {

    int speed;
    int efficiency;

    public Engineer(int speed, int efficiency) {
      this.speed = speed;
      this.efficiency = efficiency;
    }

    public int getSpeed() {
      return speed;
    }

    public void setSpeed(int speed) {
      this.speed = speed;
    }

    public int getEfficiency() {
      return efficiency;
    }

    public void setEfficiency(int efficiency) {
      this.efficiency = efficiency;
    }

    @Override
    public String toString() {
      return "Engineer{" +
          "speed=" + speed +
          ", efficiency=" + efficiency +
          '}';
    }
  }

  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

    List<Engineer> engineerList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      engineerList.add(new Engineer(speed[i], efficiency[i]));
    }
    engineerList.sort((a, b) -> Integer.compare(b.efficiency, a.efficiency));

    int max = Integer.MIN_VALUE;
    int count = 0;
    int speedValue = 0;

    for (int i = 0; i < n; i++) {
      speedValue += engineerList.get(i).speed;
      count++;
      if (count == k) {
        max = Math.max(max, speedValue * engineerList.get(i).efficiency);
        speedValue -= engineerList.get(i + 1 - k).speed;
        count--;
      }
    }
    return max;
  }


  public static void main(String[] args) {
    int[] speed = {2, 10, 3, 1, 5, 8};
    int[] efficiency = {5, 4, 3, 9, 7, 2};
    new LeetCode_1383().maxPerformance(6, speed, efficiency, 2);
  }


}
