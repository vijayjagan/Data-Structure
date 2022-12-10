package graph;

public interface DisJoin {

  void union(int var1, int var2);

  int findUnion(int var1);

  boolean isSameSet(int var1 , int var2);

  int unionBySize(int var1);

}
