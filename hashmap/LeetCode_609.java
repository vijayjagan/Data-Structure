package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_609 {


  public static List<List<String>> findDuplicate(String[] paths) {
    List<List<String>> duplicateList = new ArrayList<>();
    Map<String, List<String>> fileAndPathMap = new HashMap<>();

    for (String path : paths) {
      String[] pathAndFiles = path.split(" ");
      String location = pathAndFiles[0];

      for (int i = 1; i < pathAndFiles.length; i++) {

        int endIndexOfFile = pathAndFiles[i].indexOf("(");
        String pathAndFile = pathAndFiles[i];
        String fileNameAndContent = pathAndFile.substring(0, endIndexOfFile);
        String content = pathAndFile.substring(endIndexOfFile + 1, pathAndFile.length() - 1);

        List<String> pathList = fileAndPathMap.getOrDefault(content, new ArrayList<>());
        pathList.add(location + "/" + fileNameAndContent);
        fileAndPathMap.put(content, pathList);

      }
    }


    for (Map.Entry<String, List<String>> entry : fileAndPathMap.entrySet()) {
      if (entry.getValue().size() >= 2) {
        duplicateList.add(entry.getValue());
      }
    }

    return duplicateList;
  }


  public static void main(String[] args) {
    String[] s = {"root/a a.txt(efsfgh) aa.txt(efsfgh) aaa.txt(efsfgh)\",\"root/c/a 3.txt(efsfgh)\",\"root/c/d 4.txt(efsfgh)"};
    System.out.println(findDuplicate(s));
  }
}
