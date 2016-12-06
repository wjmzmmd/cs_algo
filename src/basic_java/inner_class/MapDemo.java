package basic_java.inner_class;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * test reference in collections, like map, set, array
 *
 * Created by qin on 16-11-24.
 */
public class MapDemo {

    Inner getInner(){
        return new Inner();
    }

    class Inner{
        String str;
    }

    public static void main(String[] args) {
        MapDemo.Inner[] array = new MapDemo.Inner[3];
        Map<String, Inner> map = new HashMap<>();
        Set<Inner> set = new HashSet<>();
        MapDemo mapDemo = new MapDemo();
        MapDemo.Inner inner = mapDemo.getInner();
        inner.str = "1";
        array[0] = inner;
        map.put("1", inner);
        set.add(inner);
        inner = mapDemo.getInner();
        inner.str = "2";
        array[1] = inner;
        map.put("2", inner);
        set.add(inner);
        inner.str = "3";
        System.out.println("inner.str = " + inner.str);
        System.out.println("array[1].str = " + array[1].str);
        System.out.println("map.get(\"2\").str = " + map.get("2").str);
        set.forEach(inner1 -> {
            System.out.println("inner.str = " + inner1.str);
        });
    }
}
