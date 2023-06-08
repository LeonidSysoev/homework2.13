import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integers;
    private int size;

    public IntegerListImpl() {
        this.integers = new Integer[10];
    }

    public IntegerListImpl(int arraySize) {
        this.integers = new Integer[arraySize];
    }

    @Override
    public Integer add(Integer item) {
        lengthCheck();
        nullCheck(item);
        integers[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        lengthCheck();
        nullCheck(item);
        indexCheck(index);
        if (index == size) {
            integers[size++] = item;
        } else {
            System.arraycopy(integers, index, integers, size + 1, size - index);

        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        indexCheck(index);
        nullCheck(item);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                integers[i] = item;
            }

        }
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        nullCheck(item);
        int index = indexOf(item);
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        indexCheck(index);
        Integer item = integers[index];
        if (!contains(item)) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(integers, index + 1, integers, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arr = toArray();
        sortSelection(arr);
        return binarySearch(arr, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        indexCheck(index);
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    private void lengthCheck() {
        if (size == integers.length) {
            throw new ArrayLengthException();
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexNotCorrectException();
        }
    }

    private void nullCheckArray(IntegerList array) {
        if (array == null) {
            throw new ArrayNullException();
        }
    }

    private void nullCheck(Integer item) {
        if (item == null) {
            throw new ItemNullException();
        }
    }
    public void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    private void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    private void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
