package search;

/**
 * Created by qin on 16-11-24.
 */
public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return ourInstance;
    }

    private TestSingleton() {
    }
}
