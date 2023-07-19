package pro.sky.algorithmspart3;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = generateRandomArray();
        long start = System.currentTimeMillis();

        sortSelection(arr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = Arrays.copyOf(arr, arr.length);

        sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        sortInsertion(arr2);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[300];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    public static void sortSelection(int[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[j] < arr1[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr1, i, minElementIndex);
        }

    }

    public static void sortInsertion(int[] arr2) {
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr2[i];
            int j = i;
            while (j > 0 && arr2[j - 1] >= temp) {
                arr2[j] = arr2[j - 1];
                j--;
            }
            arr2[j] = temp;
        }
    }
}

