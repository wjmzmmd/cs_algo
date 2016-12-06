package graph;

/**
 * Created by qin on 16-9-15.
 */
public class DAdjacencyListVNode {
    /** 顶点序号 */
    private int vertexId;
    /** 入边表节点 */
    private AdjacencyListArcNode inArcNode;
    /** 出边表节点 */
    private AdjacencyListArcNode outArcNode;

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public AdjacencyListArcNode getInArcNode() {
        return inArcNode;
    }

    public void setInArcNode(AdjacencyListArcNode inArcNode) {
        this.inArcNode = inArcNode;
    }

    public AdjacencyListArcNode getOutArcNode() {
        return outArcNode;
    }

    public void setOutArcNode(AdjacencyListArcNode outArcNode) {
        this.outArcNode = outArcNode;
    }
}
