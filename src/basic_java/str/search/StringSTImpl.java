package basic_java.str.search;

import basic_java.str.alphabet.Alphabet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基本字符查找树实现 Created by qin on 16-12-5.
 */
public class StringSTImpl<Integer> implements StringST<Integer> {

    Alphabet alphabet; // 尽量缩小alphabet.R()对减小trie树空间复杂度作用巨大

    Elem<Integer> root; // trie树根节点

    @Override
    public void put(String key, Integer val) {
        char[] keyChars = key.toCharArray();
        int leng = keyChars.length;
        Elem<Integer> elem = root;

    }

    private Elem<Integer> put(Elem<Integer> x, String key, Integer val, int d) {
        // 如果key存在于以x为根节点的子单词查找树中，则更新与它相关联的值
        if (x == null)
            x = new Elem<>(null);
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.setNext(alphabet.toIndex(c), put(x.next(alphabet.toIndex(c)), key, val, ++d));
        return x;
    }

    private Elem<Integer> get(Elem<Integer> x, String key, int d) {
        // 返回以x作为根节点的子单词查找树中与key相关联的值
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d); // 找到第dg个字符对应的子单词查找树
        return get(x.next(alphabet.toIndex(c)), key, ++d);
    }

    @Override
    public Integer get(String key) {
        Elem<Integer> elem = get(root, key, 0);
        if (elem == null)
            return null;
        return elem.val;
    }

    // @Override
    // public Integer get(String key) {
    // char[] keyChars = key.toCharArray();
    // int leng = keyChars.length;
    // Elem<Integer> elem = root;
    // int i=0;
    // for(;i<leng && elem.next(alphabet.toIndex(keyChars[i])) != null; i++){
    // elem = elem.next(alphabet.toIndex(keyChars[i]));
    // }
    // if(i == leng){ // 如果确实搜索到了字符尾
    // if(elem.val != null){
    // return elem.val;
    // }
    // }
    // return null;
    // }

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
        Queue<String>  queue = new LinkedList<>();
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
        return keysWithPrefix("");
    }

    class Elem<Integer> {

        Integer val;

        Elem<Integer>[] elems;

        Elem(Integer val) {
            this.val = val;
            elems = new Elem[alphabet.R()]; // 字母表大小的数组
        }

        /**
         * 根据字母表中索引，查找下一个节点
         * 
         * @param index
         *            字母表中索引
         * @return 下一个节点
         */
        Elem<Integer> next(int index) {
            return elems[index];
        }

        void setNext(int index, Elem<Integer> nextElem) {
            elems[index] = nextElem;
        }
    }

    public static void main(String[] args) {
        StringST stringST = new StringSTImpl<>();
        StringSTImpl.Elem[] elems = new StringSTImpl.Elem[10];
        for (int i = 0; i < elems.length; i++) {
            System.out.println(elems[i]); // 如果只是初始化，一定返回null
        }
    }
}
