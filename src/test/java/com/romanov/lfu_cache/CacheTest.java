package com.romanov.lfu_cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olerom on 09.12.16.
 */
public class CacheTest {
    @Test
    public void overflowTest() {
        Cache<String> cache = new Cache<String>(1000);

        cache.addElement(0, "Data: 0");
        for (int i = 1; i < cache.length(); i++) {
            cache.addElement(i, "Data: " + i);
            cache.getElement(i);
        }

        cache.addElement(1001, "Data: " + 1001);

        for (int i = 1; i < cache.length(); i++) {
            assertEquals("Data: " + i, cache.getElement(i));
        }
    }


    @Test(expected = NullPointerException.class)
    public void exceptionTest() {
        Cache<String> cache = new Cache<String>();
        for (int i = 0; i < 1000; i++) {
            cache.getElement(i);
        }
    }
}
