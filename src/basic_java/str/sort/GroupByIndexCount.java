package basic_java.str.sort;

/**
 * Created by qin on 16-12-2.
 */

public class GroupByIndexCount {

    Elem[] a;

    Elem[] aux;

    int[] count;

    int N;

    /** 组数在[0,R)之间 */
    int R;

    GroupByIndexCount(Elem[] a, int R){
        this.a = a;
        this.R = R;
        N = a.length;
        Elem[] aux = new Elem[N];
        count = new int[R];
    }

    class Elem{
        int groupId;
        String name;
    }
}
