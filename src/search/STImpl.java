package search;

/**
 * Created by qin on 16-11-24.
 */
public abstract class STImpl<Key extends Comparable<Key>, Value> implements ST<Key, Value>{

    @Override
    public void delete(Key key){
        put(key, null);
    }

    @Override
    public boolean contains(Key key){
        return get(key) != null;
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }


}
