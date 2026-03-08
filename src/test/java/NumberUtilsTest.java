import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class NumberUtilsTest {

    @Test
    public void testAddEmptyLists() {
        List<Integer> a = Arrays.asList();
        List<Integer> b = Arrays.asList();
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    public void testAddSingleDigitNoCarry() {
        List<Integer> a = Arrays.asList(1);
        List<Integer> b = Arrays.asList(2);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(3), result);
    }

    @Test
    public void testAddSingleDigitWithCarry() {
        List<Integer> a = Arrays.asList(5);
        List<Integer> b = Arrays.asList(7);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testAddDifferentLengths() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(1, 2, 7), result);
    }

    @Test
    public void testAddWithCarryPropagation() {
        List<Integer> a = Arrays.asList(9, 9, 9);
        List<Integer> b = Arrays.asList(1);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(1, 0, 0, 0), result);
    }

    @Test
    public void testAddLargeNumbers() {
        List<Integer> a = Arrays.asList(9, 9, 9, 9, 9);
        List<Integer> b = Arrays.asList(1);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0), result);
    }

    @Test
    public void testAddZero() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(0);
        List<Integer> result = NumberUtils.add(a, b);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testAddNullListReturnsNull() {
        assertNull(NumberUtils.add(null, Arrays.asList(1)));
        assertNull(NumberUtils.add(Arrays.asList(1), null));
    }

    @Test
    public void testAddNegativeDigitsThrowsException() {
        List<Integer> a = Arrays.asList(-1);
        List<Integer> b = Arrays.asList(1);
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(a, b));
    }

    @Test
    public void testAddDigitsGreaterThan9ThrowsException() {
        List<Integer> a = Arrays.asList(10);
        List<Integer> b = Arrays.asList(1);
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(a, b));
    }
}