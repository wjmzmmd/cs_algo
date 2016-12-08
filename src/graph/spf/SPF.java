package graph.spf;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

/**
 * Created by qin on 16-12-7.
 */
public class SPF {

    private static final int MAXN = 1000;

    /** 邻接矩阵，由输入文件初始化 */
    int[][] edge;

    /** 表示顶点访问状态的数组，由内部初始化 */
    int[] visited;

    /** 顶点数目 */
    int nodesNum;

    // 在dfs中记录当前深度优先搜索序数
    int tmpdfn;

    // 每个顶点的dfn值
    int[] dfn;

    // 每个顶点的low值，通过该值判断是否关节点
    int[] low;

    // 根节点的子女节点的个数（如果大于2则根节点是关节点）
    int son;

    // 记录每个节点（去掉该节点后）的连通分量个数
    int[] subnets;

    public SPF() {
        // 节点号从1开始
        low[1] = dfn[1] = 1;
        tmpdfn = 1;
        son = 0;
        visited = new int[MAXN];
        visited[1] = 1;
    }

    public SPF(InputStream inputStream){

    }

    // 深度优先搜索,记录每个节点的 low 值(根据 low 值来判断是否求关节点)
    private void dfs(int u) {
        for (int v = 1; v < nodesNum; v++) { // 注意：节点号从1开始
            // u跟v邻接
            if (edge[u][v] != 0) {
                // v还未被访问，
                if (visited[v] != 0) {
                    visited[v] = 1;
                    tmpdfn++;
                    dfn[v] = low[v] = tmpdfn;
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] >= dfn[u]) {
                        if (u != 0) {
                            subnets[u]++;
                        } else {
                            son++;
                        }
                    }
                } else {
                    low[u] = Math.min(low[u], dfn[v]);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
