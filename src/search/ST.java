package search;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by qin on 16-11-24.
 */
public interface ST<Key extends Comparable<Key>, Value> {

    void put(Key key, Value value);

    Value get(Key key); // 获取键key对应的值

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    /**
     * 排名为k的键
     * 
     * @param k
     *            排名
     * @return
     */
    Key select(int k);

    void deleteMin();

    void deleteMan();

    /**
     * [lo..hi]之间的键的数量
     * 
     * @param lo
     * @param hi
     * @return
     */
    int size(Key lo, Key hi);

    Iterator<Key> keys(Key lo, Key hi);

    Iterator<Key> keys();
}
