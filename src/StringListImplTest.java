import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    static StringList stringList = new StringListImpl();


    @Test
    void addTest() {
        stringList.add("Иванов");
        stringList.add("Петров");
        String[] expected = new String[]{"Иванов", "Петров"};
        assertArrayEquals(expected, stringList.toArray());
    }
    @Test
    void addTestSize() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(2, stringList.toArray().length);
    }

    @Test
    void testAddByIndex() {
        stringList.add(0, "Иванов");
        stringList.add(1, "Петров");
        String[] expected = new String[]{"Иванов", "Петров"};
        assertArrayEquals(expected, stringList.toArray());
    }
    @Test
    void testAddByIndexNotCorrect() {
        assertThrows(IndexNotCorrectException.class, () -> stringList.add(9, "Иванов"));
    }

    @Test
    void set() {
        stringList.add("Иванов");
        stringList.add("Петров");
        stringList.set(0, "Сидоров");
        String[] expected = new String[]{"Сидоров", "Петров"};
        assertArrayEquals(expected, stringList.toArray());
    }

    @Test
    void remove() {
        stringList.add("Иванов");
        stringList.add("Петров");
        stringList.remove("Иванов");
        String[] expected = new String[]{"Петров"};
        assertArrayEquals(expected, stringList.toArray());
    }

    @Test
    void testRemoveByIndex() {
        stringList.add("Иванов");
        stringList.add("Петров");
        stringList.remove(1);
        String[] expected = new String[]{"Иванов"};
        assertArrayEquals(expected, stringList.toArray());
    }

    @Test
    void contains() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(stringList.contains("Сидоров"), false);
    }

    @Test
    void indexOf() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(stringList.indexOf("Иванов"), 0);
    }

    @Test
    void lastIndexOf() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(stringList.lastIndexOf("Петров"), 1);
    }

    @Test
    void get() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(stringList.get(0), "Иванов");
    }

    @Test
    void testEquals() {
        StringList otherStringList = new StringListImpl();
        stringList.add("Иванов");
        stringList.add("Петров");
        otherStringList.add("Иванов");
        otherStringList.add("Петров");
        assertEquals(true, stringList.equals(otherStringList));
    }

    @Test
    void size() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(2, stringList.size());
    }

    @Test
    void isEmpty() {
        stringList.add("Иванов");
        stringList.add("Петров");
        assertEquals(false, stringList.isEmpty());
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}