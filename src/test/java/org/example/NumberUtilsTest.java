package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @Test
    @Tag("Specification")
    void add_leftNull_returns_null() {

        //Arrange
        List<Integer> left = null;
        List<Integer> right = new ArrayList<>();
        right.add(1);

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertNull(actual);
    }

    @Test
    @Tag("Structural")
    void add_rightNull_returns_null() {

        //Arrange
        List<Integer> left = new ArrayList<>();
        left.add(1);
        List<Integer> right = null;

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertNull(actual);
    }

    @Test
    @Tag("Structural")
    void add_bothEmpty_returnsEmpty(){

        //Arrange
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Structural")
    void add_leftEmpty_rightNonEmpty(){

        //Arrange
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(1);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Specification")
    void add_singleDigitEachList(){

        //Assert
        List<Integer> left = new ArrayList<>();
        left.add(8);
        List<Integer> right = new ArrayList<>();
        right.add(9);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Specification")
    void add_differentLengthLists(){

        //Arrange
        List<Integer> left = new ArrayList<>();
        left.add(8);
        left.add(9);
        List<Integer> right = new ArrayList<>();
        right.add(2);
        List<Integer> expected = new ArrayList<>();
        expected.add(9);
        expected.add(1);

        //Act
        List<Integer> actual = NumberUtils.add(left, right);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Structural")
    void add_invalidDigits(){

        //Arrange
        List<Integer> left = new ArrayList<>();
        left.add(16);
        List<Integer> right = new ArrayList<>();
        right.add(0);

        //Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    //ASSIGNMENT 2
    @Test
    @Tag("Structural")
    void nullLists(){
        List<Integer> left = null;
        List<Integer> right = null;
        assertNull(NumberUtils.add(left, right));
    }

    @Test
    @Tag("Structural")
    void leftDigitNeg(){
        List<Integer> left = new ArrayList<>();
        left.add(-1);
        List<Integer> right = new ArrayList<>();
        right.add(9);

        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    @Tag("Structural")
    void rightDigitNeg(){
        List<Integer> left = new ArrayList<>();
        left.add(9);
        List<Integer> right = new ArrayList<>();
        right.add(-1);

        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    @Tag("Structural")
    void rightDoubleDigit(){
        List<Integer> left = new ArrayList<>();
        left.add(4);
        List<Integer> right = new ArrayList<>();
        right.add(10);

        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    @Tag("Structural")
    void leadDigitZero(){
        List<Integer> left = new ArrayList<>();
        left.add(0);
        left.add(2);
        List<Integer> right = new ArrayList<>();
        right.add(0);
        right.add(2);
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        List<Integer> actual = NumberUtils.add(left, right);

        assertEquals(expected, actual);
    }
}