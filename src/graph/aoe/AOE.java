package graph.aoe;

/**
 * 基本的活动网络中关键路径算法
 * 1.Ee[0]=0,Ee[i]=max{Ee[j]+dur(Ej,Ei)}
 * 2.El[n-1]=Ee[n-1],El[i]=min{El[j]-dur(Ei,Ej)}
 * 3.ak对应的带权有向边为(Ei,Ej),e[k]=Ee[i],l[k]=El[j]-dur(Ei,Ej)
 * Created by qin on 16-12-6.
 */
public class AOE {

    private static final int MAXN = 100; // 顶点个数最大值

    private static final int MAXM = 200; // 边数的最大值

    class ArcNode{
        // 边节点结构
        int to, dur, no; // 边的另一个顶点， 持续时间，活动序号
        ArcNode next;
    }

    int n, m; // 顶点个数，边数
    ArcNode[] list1 = new ArcNode[MAXN]; // 出边表
    ArcNode[] list2 = new ArcNode[MAXN]; // 入边表
    int[] count1 = new int[MAXN]; // 各顶点的出度
    int[] count2 = new int[MAXN]; // 各顶点的入度
    int[] Ee = new int[MAXN]; // 各事件最早可能开始时间
    int[] El = new int[MAXN]; // 各事件最迟允许开始时间
    int[] e = new int[MAXM]; // 各活动最早可能开始时间
    int[] l = new int[MAXM]; // 各活动最迟允许开始时间
}
