package search;

import java.util.Iterator;

/**
 * Created by qin on 16-11-24.
 */
public class SequentialSearchST<Key, Value> {

    private Node first; // 链表首节点

    private class Node { // 链表节点的定义

        Key key;

        Value val;

        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * @param key
     * @return
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    /**
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public boolean isEmpty(){
        return first != null;
    }

    public int size(){
        return 0;
    }

    public Iterator<Key> keys(){
       return null;
    }
}
