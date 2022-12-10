package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode_721 {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> mailIndex = new HashMap<>();
    DisJoinSet disJoinSet = new DisJoinSet(accounts.size());
    for (int i = 0; i < accounts.size(); i++) {
      int index = i;
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String email = accounts.get(i).get(j);
        if (mailIndex.containsKey(email)) {
          int x = mailIndex.get(email);
          int y = index;
          disJoinSet.union(x, y);
          continue;
        }
        mailIndex.put(accounts.get(i).get(j), index);
      }
    }

    Map<Integer, List<String>> mergedMap = new HashMap<>();
    for (Map.Entry<String, Integer> entry : mailIndex.entrySet()) {
      int parent = disJoinSet.findUnion(entry.getValue());
      List<String> emails = mergedMap.getOrDefault(parent, new ArrayList<>());
      emails.add(entry.getKey());
      mergedMap.put(parent, emails);
    }
    List<List<String>> mergedAccounts = new LinkedList<>();

    for (Map.Entry<Integer, List<String>> entry : mergedMap.entrySet()) {
      String name = accounts.get(entry.getKey()).get(0);
      List<String> emails = entry.getValue();
      Collections.sort(emails);
      emails.add(0, name);
      mergedAccounts.add(new ArrayList<>(emails));
    }
    return mergedAccounts;
  }

}
