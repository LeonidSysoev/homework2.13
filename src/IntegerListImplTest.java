import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    static IntegerList integerList = new IntegerListImpl();

    @BeforeEach
    void setUp() {
        integerList.add(50);
        integerList.add(100);
    }

    @Test
    void addTest() {
        Integer[] expected = new Integer[]{50, 100};
        assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    void sizeTest() {
        Integer[] expected = new Integer[]{50, 100};
        assertEquals(expected.length, integerList.toArray().length);
    }

    @Test
    void testAddByIndex() {
        integerList.add(0, 50);
        integerList.add(1, 100);

        Integer[] expected = new Integer[]{50, 100};
        assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    void setTest() {
        integerList.set(1, 200);
        Integer[] expected = new Integer[]{50, 200};
        assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    void removeTestByIndex() {
        integerList.remove(0);
        Integer[] expected = new Integer[]{100};
        assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    void RemoveTest() {
        Integer a = 100;
        integerList.remove(a);

        Integer[] expected = new Integer[]{50};
        assertArrayEquals(expected, integerList.toArray());
    }

    @Test
    void containsTest() {
        assertEquals(true, integerList.contains(50));
    }

    @Test
    void indexOfTest() {
        assertEquals(0, integerList.indexOf(50));
    }

    @Test
    void lastIndexOfTest() {
        assertEquals(1, integerList.indexOf(100));
    }

    @Test
    void getTest() {
        assertEquals(100, integerList.get(1));
    }

    @Test
    void EqualsTest() {
        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(50);
        otherIntegerList.add(100);
        assertEquals(true, integerList.equals(otherIntegerList));
    }

    @Test
    void arraySizeTest() {
        assertEquals(2, integerList.size());
    }

    @Test
    void isEmptyTest() {
        assertEquals(false, integerList.isEmpty());
    }

    @Test
    void clearTest() {
        integerList.clear();
        assertEquals(0, integerList.size());
    }

    @Test
    void toArrayTest() {
        assertEquals(integerList.toArray().length, integerList.size());
    }

    @Test
    void IndexNotCorrectExceptionTest() {
        assertThrows(IndexNotCorrectException.class, () -> integerList.add(15, 200));
    }

}
