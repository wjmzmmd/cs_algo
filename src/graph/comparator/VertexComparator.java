package graph.comparator;

import graph.Vertex;

import java.util.Comparator;

/**
 * Created by qin on 16-9-15.
 */
public class VertexComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex vertex1, Vertex vertex2) {
        return vertex2.getDegree().compareTo(vertex1.getDegree());
    }
}
