package com.momate.array.hashset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HSet<T> implements Iterable<T>{

    private static final Object NO_OBJ = new Object();
    private Map<T, Object> map;

    public HSet() {
        this.map = new HashMap<>();
    }

    public boolean add(T elem){
        return this.map.put(elem, NO_OBJ) == NO_OBJ;
    }

    public boolean remove(T elem){
        return this.map.remove(elem) == NO_OBJ;
    }

    public boolean contains(T elem){
        return this.map.containsKey(elem);
    }

    public boolean isEmpty(){
        return this.map.isEmpty();
    }

    public int size(){
        return this.map.size();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
}
