package graph;

/**
 * Created by qin on 16-9-15.
 */
public class AdjacencyListVNode {
    /** 顶点序号 */
    private int vertexId;
    /** 边节点 */
    private AdjacencyListArcNode inArcNode;

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
}
