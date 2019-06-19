package com.company.par2_18_02.ej2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DoubleKeyHashMap<K1, K2, V> implements DoubleKeyMap<K1, K2, V> {

    private Map<K1, Map<K2, V>> map;

    public DoubleKeyHashMap() {
        this.map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (K1 key: map.keySet()
             ) {
            size += map.get(key).size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(K1 firstKey, K2 secondKey) {
        Map innerMap = map.get(firstKey);
        if(innerMap == null) {
            return false;
        }
        return innerMap.containsKey(secondKey);
    }

    @Override
    public boolean containsValue(V value) {
        Set<K1> mapKeySet = map.keySet();
        for(K1 key: mapKeySet){
            if(map.get(key).containsValue(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K1 firstKey, K2 secondKey) {
        return map.get(firstKey).get(secondKey);
    }

    @Override
    public void put(K1 firstKey, K2 secondKey, V value) {
        Map<K2, V> innerMap = map.get(firstKey);
        if (innerMap == null)
            innerMap = new HashMap<>();

        innerMap.put(secondKey, value);

        map.put(firstKey, innerMap);
    }
}
