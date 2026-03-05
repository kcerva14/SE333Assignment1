package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class NumberUtilsTest {

    @Test
    void add_nullLeft_returnsNull() {
        Assertions.assertNull(NumberUtils.add(null, Arrays.asList(1,2,3)));
    }

    @Test
    void add_nullRight_returnsNull() {
        Assertions.assertNull(NumberUtils.add(Arrays.asList(1,2,3), null));
    }

    @Test
    void add_bothEmpty_returnsEmpty() {
        List<Integer> empty = Collections.emptyList();
        List<Integer> result = NumberUtils.add(empty, empty);
        Assertions.assertEquals(Collections.emptyList(), result);
    }

    @Test
    void add_simpleNoCarry() {
        List<Integer> left = Arrays.asList(1,2);
        List<Integer> right = Arrays.asList(3,4);
        Assertions.assertEquals(Arrays.asList(4,6), NumberUtils.add(left, right));
    }

    @Test
    void add_withCarry() {
        List<Integer> left = Arrays.asList(9,9);
        List<Integer> right = Collections.singletonList(1);
        Assertions.assertEquals(Arrays.asList(1,0,0), NumberUtils.add(left, right));
    }

    @Test
    void add_leadingZeros() {
        List<Integer> left = Arrays.asList(0,1,2); // 12
        List<Integer> right = Arrays.asList(0,0,3); // 3
        Assertions.assertEquals(Arrays.asList(1,5), NumberUtils.add(left, right));
    }

    @Test
    void add_invalidDigit_throws() {
        List<Integer> left = Arrays.asList(1, -1);
        List<Integer> right = Arrays.asList(2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }
}
