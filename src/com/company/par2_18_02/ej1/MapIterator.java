package com.company.par2_18_02.ej1;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MapIterator<K, V> implements Iterator {

    private Iterator<K> iterator;
    private V currentValue = null;
    private K currentKey = null;
    private Map<K, V> map;

    public MapIterator(Map<K, V> map) {
        this.map = map;
        iterator = map.keySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next(){
        if(hasNext()) {
            currentKey = iterator.next();
            currentValue = map.get(currentKey);
            return currentKey;
        } else {
            throw new NoSuchElementException();
        }
    }

    public V getValue() {
        if(currentValue == null)
            throw new NoSuchElementException();
        return currentValue;
    }
}
