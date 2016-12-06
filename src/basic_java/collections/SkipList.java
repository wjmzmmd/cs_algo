package basic_java.collections;

/**
 * Created by qin on 16-11-25.
 */
public class SkipList {

    private int level; //

    private Node head; //

    class Node <Key, Value>{
        Key key; //
        Value value; //
        Node[] next;

        public Node(int level, Key key, Value value){
            this.next = new Node[level];
            this.key = key;
            this.value = value;
        }
    }
}
