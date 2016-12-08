package graph.spf;

import java.io.*;

/**
 * <p>
 * 节点是关节点的判断条件： 1.u是具有2个以上子女的深度优先生成树的根节点 2.u不是根，但至少有一个子女w使得low[w] >= dfn[u]
 * </p>
 * <p>
 * low值的更新策略： low[u] = Min{dfn[u], Min{low[w]|w是u的一个子女},
 * Min{dfn[v}|v与u邻接，且(u,v)是一条回边}
 * </p>
 * <p>
 * v是u的邻接顶点时，分两种情况更新u的low值： 1. v是u的儿子节点 2. v是u的祖先节点
 * </p>
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

    public SPF(InputStream inputStream) throws IOException {
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            String line;
            int i = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 1) { // 第一个输入
                    nodesNum = Integer.parseInt(line);
                    int tmpNodesNum = nodesNum + 1;
                    // 各种初始化
                    edge = new int[tmpNodesNum][tmpNodesNum];
                    visited = new int[tmpNodesNum];
                    low = new int[tmpNodesNum];
                    dfn = new int[tmpNodesNum];
                    subnets = new int[tmpNodesNum];
                } else {
                    int u = Integer.parseInt(line.split(" ")[0]);
                    int v = Integer.parseInt(line.split(" ")[1]);
                    edge[u][v] = 1;
                    edge[v][u] = 1;
                }
                i++;
            }
            // 节点号从1开始
            low[1] = dfn[1] = 1;
            tmpdfn = 1;
            son = 0;
            visited[1] = 1;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public void compute() {
        dfs(1); // 从第1个顶点开始搜索、处理
        printResult();
    }

    private void printResult() {
        if (son > 1) { // 如果根节点的孩子节点多于一个，则根节点也是关键节点
            subnets[1] = son - 1; // 这里减一是因为下边有循环加一
        }
        boolean find = false;
        for (int i = 1; i <= nodesNum; i++) {
            if (subnets[i] > 0) {
                find = true;
                System.out.println(String.format("SPF node %s leaves %s subnets.", i, subnets[i] + 1));
            }
        }
        if (!find) {
            System.out.println("No SPF nodes.");
        }
    }

    // 深度优先搜索,记录每个节点的 low 值(根据 low 值来判断是否求关节点)
    private void dfs(int u) {
        for (int v = 1; v <= nodesNum; v++) { // 注意：节点号从1开始
            // u跟v邻接
            if (edge[u][v] != 0) {
                // v还未被访问，v是u的儿子节点,更新low[u]
                if (visited[v] == 0) {
                    visited[v] = 1;
                    tmpdfn++;
                    dfn[v] = low[v] = tmpdfn;
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] >= dfn[u]) {
                        if (u != 1) {
                            subnets[u]++;
                        } else {
                            son++;
                        }
                    }
                } else {
                    // v访问过，v是u的祖先节点，(u,v)是一条回边
                    low[u] = Math.min(low[u], dfn[v]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SPF spf = new SPF(new FileInputStream("/home/qin/misc/cs_algo/data/spf"));
        spf.compute();
    }
}
