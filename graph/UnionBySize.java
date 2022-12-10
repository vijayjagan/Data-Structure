package graph;

public class UnionBySize implements DisJoin {

  private int[] parent;
  private int[] size;


  private UnionBySize() {
  }

  public UnionBySize(int size) {
    this.parent = new int[size];
    this.size = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  @Override
  public void union(int var1, int var2) {
    int x = findUnion(var1);
    int y = findUnion(var2);

    if (x == y) {
      return;
    }
    if (size[var1] < size[var2]) {
      parent[var2] = var1;
      size[var2] += size[var1];
    } else {
      parent[var1] = var2;
      size[var1] += size[var2];
    }

  }

  @Override
  public int findUnion(int var1) {
    if (parent[var1] == var1) {
      return var1;
    }
    return parent[var1] = findUnion(parent[var1]);
  }

  @Override
  public int unionBySize(int var1) {
    return size[findUnion(var1)];
  }

  @Override
  public boolean isSameSet(int var1, int var2) {
    return findUnion(var1) == findUnion(var2);
  }
}
