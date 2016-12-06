package basic_java.str.search;

import java.util.Iterator;

/**
 * 三向单词查找树 每个节点都含有一个字符，三条链接和一个值 这三个条链接分别对应当前字母小于、等于、大于节点字母的所有键 Created by qin on
 * 16-12-5.
 */
public class TST<V> implements StringST<V> {

    Elem<V> root; // 三向查找树根节点

    @Override
    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Elem<V> put(Elem<V> x, String key, V val, int d) {
        if (x == null)
            return new Elem<>(val, key.charAt(d));
        if (d == key.length() - 1) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        return put(x.next(c), key, val, ++d);
    }

    @Override
    public V get(String key) {
        return get(root, key, 0);
    }

    private V get(Elem<V> x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length() - 1)
            return x.val;
        char c = key.charAt(d); // 得到键的当前字符
        return get(x.next(c), key, ++d);
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String longestPrefixOf(String s) {
        return null;
    }

    @Override
    public Iterator<String> keysWithPrefix(String s) {
        return null;
    }

    @Override
    public Iterator<String> keysThatMatch(String s) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<String> keys() {
        return null;
    }

    class Elem<V> {

        char nodeVal;

        V val;

        Elem<V>[] elems;

        Elem(V val, char nodeVal) {
            this.val = val;
            this.nodeVal = nodeVal;
            elems = new Elem[3]; // 三向列表
        }

        Elem<V> next(char kChar) {
            if (nodeVal < kChar) { // 如果key比节点小，返回左子节点
                return elems[0];
            } else if (nodeVal == kChar) { // 如果key等于节点，返回中子节点
                return elems[1];
            } else { // 如果key比节点大，返回右子节点
                return elems[2];
            }
        }
    }
}
