package graph;

public class UnionByRank implements  DisJoin{


  private int[] parent;
  private int[] rank;



  private UnionByRank() {
  }


  public UnionByRank(int size) {
    this.parent = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  public int findUnion(int val) {
    if (val == parent[val]) {
      return val;
    }
    return parent[val] = findUnion(parent[val]);
  }

  public void union(int var1, int var2) {
    int p1 = findUnion(var1);
    int p2 = findUnion(var2);

    if (p1 == p2) {
      return;
    }

    if (rank[p1] < rank[p2]) {
      parent[p1] = p2;
    } else {
      parent[p2] = p1;
    }

    if (rank[p1] == rank[p2]) {
      rank[p1]++;
    }
  }


  public boolean isSameSet(int var1, int var2) {
    return findUnion(var1) == findUnion(var2);
  }

  @Override
  public int unionBySize( int var1) {
    return 0;
  }

}
