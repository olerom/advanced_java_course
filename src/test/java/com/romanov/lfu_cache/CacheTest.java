package com.romanov.lfu_cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olerom on 09.12.16.
 */
public class CacheTest {
    @Test
    public void deleteTest() {
        Cache<String> cache = new Cache<>(1000);

        for (int i = 0; i < cache.length(); i++) {
            cache.addElement(i, "Data: " + i);
            if (i < cache.length()) {
                cache.getElement(i + 1);
            }
        }
        cache.addElement(1001, "Data: " + 1001);

        assertEquals(null, cache.getElement(0));


        for (int i = 1; i < cache.length(); i++) {
            assertEquals("Data: " + i, cache.getElement(i));
        }
    }
}
