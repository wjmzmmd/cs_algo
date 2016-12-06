package basic_java.inner_class;

import java.util.Random;

/**
 * Created by qin on 16-11-24.
 */
public class Outer {

    private String prefix = "prefix_";

    private String midfix = "_midfix_";

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print("123");
        inner = outer.getInner();
        inner.print("456");
    }

    public String getCapitalStr(String str) {
        return str.toUpperCase();
    }

    public Inner getInner() {
        return new Inner();
    }

    public class Inner {
        public void print(String str) {
            System.out.println(Outer.this.hashCode() + midfix + str);
        }
    }
}
