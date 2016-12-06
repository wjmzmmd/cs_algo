package graph;

import java.util.Arrays;

/**
 * Created by qin on 16-9-15.
 */
public class GraphAdjacencyMatrix {
    /**
     * 邻接矩阵
     */
    private int[][] edge;

    public GraphAdjacencyMatrix(int n, int m) {
        edge = new int[n][m];
        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge[0].length; j++) {
                edge[i][j] = 0;
            }
        }
    }

    public int[][] getEdge() {
        return edge;
    }

    public void setEdge(int[][] edge) {
        this.edge = edge;
    }

    public void setIJ(int i, int j) {
        edge[i][j] = 1;
    }
}
