package com.romanov.lfu_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by olerom on 08.12.16.
 */
class Cache<T> {

    class Data {
        private T data;
        private int counter;

        private Data() {
        }

        public T getData() {
            return data;
        }

        void setData(T data) {
            this.data = data;
        }

        public int getCounter() {
            return counter;
        }

        void setCounter(int counter) {
            this.counter = counter;
        }

    }

    int length() {
        return capacity;
    }

    private int capacity;

    private LinkedHashMap<Integer, Data> cacheMap = new LinkedHashMap<Integer, Data>();

    public Cache() {
        capacity = 10;
    }

    Cache(int capacity) {
        this.capacity = capacity;
    }

    void addElement(int key, T data) {
        if (data == null){
            throw new NullPointerException();
        }
        if (cacheMap.size() != capacity) {
            Data temp = new Data();
            temp.setData(data);
            temp.setCounter(0);

            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getKey();
            cacheMap.remove(entryKeyToBeRemoved);

            Data temp = new Data();
            temp.setData(data);
            temp.setCounter(0);

            cacheMap.put(key, temp);
        }
    }

    private int getKey() {
        int key = 0;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Data> entry : cacheMap.entrySet()) {
            if (min > entry.getValue().counter) {
                key = entry.getKey();
                min = entry.getValue().counter;
            }
        }
        return key;
    }

    T getElement(int key) {
        if (cacheMap.containsKey(key)) {
            Data temp = cacheMap.get(key);
            temp.counter++;
            cacheMap.put(key, temp);
            return temp.data;
        } else {
            throw new NullPointerException();
        }
    }


}
