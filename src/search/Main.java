package search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qin on 16-11-24.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> map =  new HashMap<>();
        map.put(null, "1");
        printMap(map);
        map.put(null, "2");
        printMap(map);
        map.put("3", "4");
        printMap(map);
        map.put("5", null);
        printMap(map);
        map.put("3", null);
        printMap(map);
        System.out.println("===get -100 out map===");
        System.out.println("key: -100" + " value: " + map.get("-100"));
    }

    private static void printMap(Map<String, String> map){
        System.out.println("===print map out===");
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
//        System.out.println("===print map out end===");
    }
}
