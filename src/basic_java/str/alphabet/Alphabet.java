package basic_java.str.alphabet;

/**
 * 基本字母表接口 Created by qin on 16-12-5.
 */
public interface Alphabet {

    int UNICODE_SIZE = 65536; // 先全量数组

    /**
     * 获取字母表中索引位置字符
     * 
     * @param index
     *            索引
     * @return 字符
     */
    char toChar(int index);

    /**
     * 获取c的索引，在0到R-1之间
     * 
     * @param c
     *            字符
     * @return 索引
     */
    int toIndex(char c);

    /**
     * c在字母表之中吗
     * 
     * @param c
     *            字符
     * @return 在字母表中返回true，否则返回false
     */
    boolean contains(char c);

    /**
     * 基数（字母表中的字符数量）
     * 
     * @return 字母表中的字符数量
     */
    int R();

    /**
     * 表示一个索引所需的位数
     * 
     * @return 位数
     */
    int lgR();

    /**
     * 将s转化为R进制的整数
     * 
     * @param s
     *            字符串
     * @return 字母表中索引的数组
     */
    int[] toIndices(String s);

    /**
     * 将R进制的整数转换成基于该字母表的字符串
     * 
     * @param indices
     *            索引数组
     * @return 字符串
     */
    String toChars(int[] indices);
}
