package basic_java.inner_class;

import java.util.concurrent.RecursiveTask;

/**
 * Created by qin on 16-11-25.
 */
public class CountTask extends RecursiveTask<Long>{

    private static final int THRESHOLD = 10000;

    private long start;

    private long end;

    public CountTask(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        return null;
    }
}
