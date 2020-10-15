package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class TablaDeSimbolosOrdenada<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    
    public TablaDeSimbolosOrdenada() {
        st = new TreeMap<Key, Value>();
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

   
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        st.remove(key);
    }

   
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * Returns all of the keys in this symbol table.
     * To iterate over all of the keys in a symbol table named {@code st}, use the
     * foreach notation: {@code for (Key key : st)}.
     * <p>
     * This method is provided for backward compatibility with the version from
     * <em>Introduction to Programming in Java: An Interdisciplinary Approach.</em>
     *
     * @return     an iterator to all of the keys in this symbol table
     * @deprecated Replaced by {@link #keys()}.
     */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return st.lastKey();
    }

   
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("argument to ceiling() is too large");
        return k;
    }

   
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("argument to floor() is too small");
        return k;
    }

  
}
