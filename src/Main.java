import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[100000];

        for (int i = 0; i < 100000; i++) {
            array[i] = getRandomNumbers();
        }

        long start = System.currentTimeMillis();
        sortSelection(Arrays.copyOf(array, 100000));
        // sortInsertion(Arrays.copyOf(array, 100000));
        //sortBubble(Arrays.copyOf(array, 100000));
        System.out.println(System.currentTimeMillis() - start);


    }

    public static Integer getRandomNumbers() {
        int num = 10;
        Random random = new Random();
        return random.nextInt(num);
    }

    public static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void sortSelection(Integer[] arr) {
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

    private static void sortInsertion(Integer[] arr) {
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

}