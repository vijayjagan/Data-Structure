package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TimeMap {

  private final Map<Integer, Map<String, String>> timeBasedMap;

  private final Map<String, List<Integer>> keyTimeMap;

  public TimeMap() {
    this.timeBasedMap = new HashMap<>();
    this.keyTimeMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Integer> timeStampList = keyTimeMap.getOrDefault(key, new ArrayList<>());
    timeStampList.add(timestamp);
    keyTimeMap.put(key, timeStampList);

    Map<String, String> keyValue = timeBasedMap.getOrDefault(timestamp, new HashMap<>());
    keyValue.put(key, value);
    timeBasedMap.put(timestamp, keyValue);
  }

  public String get(String key, int timestamp) {
    if (!keyTimeMap.containsKey(key)) {
      return "";
    }
    Map<String, String> keyValue = timeBasedMap.getOrDefault(timestamp, null);
    if (keyValue == null) {
      int closestTimeStamp = getLowerBound(key, timestamp);
      Map<String, String> value = timeBasedMap.getOrDefault(closestTimeStamp, null);
      return value != null ? value.get(key) : "";
    }
    return keyValue.get(key);
  }

  private int getLowerBound(String key, int timeStamp) {
    List<Integer> timeStampList = keyTimeMap.get(key);
    int l = 0;
    int r = timeStampList.size() - 1;
    if (timeStamp < timeStampList.get(0)) {
      return -1;
    }
    if (timeStamp >= timeStampList.get(r)) {
      return timeStampList.get(r);
    }
    while (l < r - 1) {
      int m = l + (r - l) / 2;
      if (timeStampList.get(m) <= timeStamp) {
        l = m;
      } else {
        r = m - 1;
      }
    }
    return timeStampList.get(r) <= timeStamp ? timeStampList.get(r) : timeStampList.get(l);
  }

  public static void main(String[] args) {
    TimeMap timeMap = new TimeMap();
    timeMap.set("a", "bar", 1);
    timeMap.set("x", "b", 3);
    timeMap.set("foo", "bar2", 4);

//    System.out.println(timeMap.get("b", 3));
//    System.out.println(timeMap.get("foo", 4));
    System.out.println(timeMap.get("foo", 5));
  }
}
