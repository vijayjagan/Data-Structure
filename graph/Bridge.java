package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridge {

    static int depthFirstSearch(int vertex, int parent, int[] depth, int[] lowDepth, int time,
            ArrayList<ArrayList<Integer>> adj, int c, int d) {

        depth[vertex] = lowDepth[vertex] = time;
        for (Integer nextVertex : adj.get(vertex)) {
            if (nextVertex == parent) {
                continue;
            }
            if (depth[nextVertex] == 0) {
                if (depthFirstSearch(nextVertex, vertex, depth, lowDepth, time + 1, adj, c, d) == 1) {
                    return 1;
                }
                // Update Current Vertex based on child (In order to check child has any backedges or not)
                lowDepth[vertex] = Math.min(lowDepth[vertex], lowDepth[nextVertex]);
                if (lowDepth[nextVertex] > depth[vertex]
                        && ((nextVertex == c && vertex == d) || (nextVertex == d && vertex == c))) {
                    return 1;
                }
            } else {
                lowDepth[vertex] = Math.min(lowDepth[vertex], depth[nextVertex]);
            }
        }
        return 0;
    }

    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        // code here
        int[] depth = new int[V];
        int[] lowDepth = new int[V];
        for (int i = 0; i < V; i++) {
            if (depth[i] == 0) {
                if (depthFirstSearch(i, -1, depth, lowDepth, 1, adj, c, d) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
