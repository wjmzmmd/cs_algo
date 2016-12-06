package graph.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import graph.GraphAdjacencyMatrix;
import graph.Vertex;
import graph.comparator.VertexComparator;

/**
 * Created by qin on 16-9-15.
 */
public class HavelHakimi {

    public static GraphAdjacencyMatrix buildGraph(List<Vertex> vertexes) throws Exception {
        if (vertexes == null || vertexes.size() <= 0) {
            throw new RuntimeException("不能为空");
        }
        int m = vertexes.size();
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(m, m);
        Comparator<Vertex> comparator = new VertexComparator();
        Collections.sort(vertexes, comparator);
        Vertex v1 = vertexes.remove(0);
        Integer d1 = v1.getDegree();
        while (vertexes.size() > 0) {
            if (vertexes.get(vertexes.size() - 1).getDegree() < 0 || d1 > vertexes.size()) {
                throw new Exception("NO");
            }
            for (int i = 0; i < d1; i++) {
                int locI = v1.getVertexId();
                int locJ = vertexes.get(i).getVertexId();
                graph.setIJ(locI, locJ);
                graph.setIJ(locJ, locI);
                vertexes.get(i).setDegree(vertexes.get(i).getDegree() - 1);
            }
            Collections.sort(vertexes, comparator);
            v1 = vertexes.remove(0);
            d1 = v1.getDegree();
        }
        return graph;
    }

    public static void main(String[] args) throws Exception {
        List<Vertex> vertexes = new ArrayList<>();
        int[] data = new int[] { 4, 3, 1, 5, 4, 2, 1 };
        // data = new int[]{4,3,1,4,2,0};
        for (int i = 0; i < data.length; i++) {
            vertexes.add(new Vertex(i, data[i]));
        }
        GraphAdjacencyMatrix graph = HavelHakimi.buildGraph(vertexes);
        System.out.print(PrintUtil.printMatrix(graph.getEdge()));
    }
}
