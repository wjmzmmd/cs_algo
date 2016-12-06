package graph;

/**
 * Created by qin on 16-9-15.
 */
public class NetAdjacencyMatrix {
    /**
     * 邻接矩阵
     */
    private double[][] edge;

    public NetAdjacencyMatrix(int n, int m) {
        edge = new double[n][m];
        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge[0].length; j++) {
                if (i == j) {
                    edge[i][j] = 0.0d;
                } else {
                    edge[i][j] = Double.MAX_VALUE;
                }
            }
        }
    }

    public double[][] getEdge() {
        return edge;
    }

    public void setEdge(double[][] edge) {
        this.edge = edge;
    }

    public void setIJ(int i, int j, double weight) {
        edge[i][j] = weight;
    }
}
