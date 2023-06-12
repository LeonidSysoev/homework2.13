import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] array;
    private int size;

    public StringListImpl() {
        this.array = new String[10];
    }

    public StringListImpl(int arraySize) {
        this.array = new String[arraySize];
    }

    @Override
    public String add(String item) {
        lengthCheck();
        nullCheck(item);
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        lengthCheck();
        nullCheck(item);
        indexCheck(index);
        if (index == size) {
            array[size++] = item;
        } else {
            System.arraycopy(array, index, array, size + 1, size - index);

        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        indexCheck(index);
        nullCheck(item);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                array[i] = item;
            }

        }
        return item;
    }

    @Override
    public String remove(String item) {
        nullCheck(item);
        int index = indexOf(item);
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        indexCheck(index);
        String item = array[index];
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        indexCheck(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        nullCheckArray(otherList);

        if (Arrays.equals(this.toArray(), otherList.toArray())) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void nullCheck(String item) {
        if (item == null) {
            throw new ItemNullException();
        }
    }

    private void lengthCheck() {
        if (size >= array.length) {
            throw new ArrayLengthException();
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexNotCorrectException();
        }
    }

    private void nullCheckArray(StringList array) {
        if (array == null) {
            throw new ArrayNullException();
        }
    }

}
