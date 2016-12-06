package graph;

/**
 * Created by qin on 16-9-15.
 */
public class Vertex {
    /** 顶点序号 */
    private int vertexId;
    /** 度数 */
    private Integer degree;

    public Vertex(int vertexId, Integer degree){
        this.vertexId = vertexId;
        this.degree = degree;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
