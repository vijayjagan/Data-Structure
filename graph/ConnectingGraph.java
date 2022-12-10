package graph;

public class ConnectingGraph {


  public int Solve(int n, int[][] edge) {
    DisJoinSet disJoinSet = new DisJoinSet(n);
    int extra = 0;
    for (int [] data : edge) {
      int from = data[0];
      int to = data[1];
      if (disJoinSet.isSameSet(from, to)) {
        extra++;
        continue;
      }
      disJoinSet.union(from, to);
    }
    int province = -1;
    for (int i = 0; i < n; i++) {
      province += disJoinSet.findUnion(i) == i ? 1 : 0;
    }
    return province <= extra ? province : -1;
  }


}
