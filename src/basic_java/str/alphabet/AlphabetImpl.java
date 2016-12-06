package basic_java.str.alphabet;

/**
 * 字母表接口的一个简单基本实现， 先用比较low的方法实现。 Created by qin on 16-12-5.
 * <b>之后可能会用一个映射表把65536大小的字母数组映射成更小的</b>
 */
public class AlphabetImpl implements Alphabet {

    // 先用比较low的数组的方式之后可以优化
    // 依赖字符表关联index和字符
    char[] chars;

    AlphabetImpl(String s) {
        // 根据字符串s创建一张新的字母表
        chars = new char[UNICODE_SIZE];
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        for (int i = 0; i < length; i++) {
            char c = sChars[i];
            chars[(int) c] = c;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[10];
        for (int i = 0; i < chars.length; i++) {
            System.out.println((int) chars[i]);
        }
    }

    @Override
    public char toChar(int index) {
        return chars[index];
    }

    @Override
    public int toIndex(char c) {
        return (int) c;
    }

    @Override
    public boolean contains(char c) {
        return chars[(int) c] != 0;
    }

    @Override
    public int R() {
        return UNICODE_SIZE;
    }

    @Override
    public int lgR() {
        return (int) Math.floor(Math.log(UNICODE_SIZE));
    }

    @Override
    public int[] toIndices(String s) {
        char[] sChars = s.toCharArray();
        int leng = sChars.length;
        int[] ret = new int[leng];
        for (int i = 0; i < leng; i++) {
            ret[i] = sChars[i];
        }
        return ret;
    }

    @Override
    public String toChars(int[] indices) {
        int leng = indices.length;
        char[] ret = new char[leng];
        for (int i = 0; i < leng; i++) {
            ret[i] = chars[indices[i]];
        }
        return new String(ret);
    }
}
