package basic_java.str.search;

import java.util.Iterator;

/**
 * 单词查找树，（不接受重复键或空键） Created by qin on 16-12-5.
 */
public interface StringST<V> {

    /**
     * 向表中插入键值对，如果为null则删除键key
     * 
     * @param key
     *            键
     * @param val
     *            值
     */
    void put(String key, V val);

    /**
     * 键key对应的值（如果键不存在则返回null）
     * 
     * @param key
     *            键
     * @return 值
     */
    V get(String key);

    /**
     * 删除键key
     * 
     * @param key
     *            键
     */
    void delete(String key);

    /**
     * 表中是否保存着key的值
     * 
     * @param key
     *            键
     * @return 表中保存着key的值返回true，否则返回false
     */
    boolean contains(String key);

    /**
     * 符号表是否为空
     * 
     * @return 符号表空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * s的前缀中最长的键
     * 
     * @param s
     *            字符串
     * @return 前缀
     */
    String longestPrefixOf(String s);

    /**
     * 所有以s为前缀的键
     * 
     * @param s
     *            前缀
     * @return 字符串
     */
    Iterator<String> keysWithPrefix(String s);

    /**
     * 所有和s匹配的键（其中.能够匹配任意字符）
     * 
     * @param s
     *            键
     * @return 键
     */
    Iterator<String> keysThatMatch(String s);

    /**
     * 键值对的数量
     * 
     * @return 数量
     */
    int size();

    /**
     * 符号表中的所有键
     * 
     * @return 键集合
     */
    Iterator<String> keys();

    // /**
    // *
    // * @param <V>
    // */
    // interface Elem<V>{
    //
    // }
}
