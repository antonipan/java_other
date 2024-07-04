package algorithms;

import java.util.Arrays;

public class Exm09SortMethods {
    public static void main(String[] args) {
        Exm09SortMethods less = new Exm09SortMethods();
        int [] array = new int [] {1, 8, 6, 14, 33, 50};
        System.out.println(less.binaryFind(array, 33));

    }
    // 1. Сортировка пузырьком
    public void bubbleSort (int [] array ) {
        boolean finish;
        int count =0;
        do {
            finish = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array [i+1];
                    array[i+1] = temp;
                    finish = false;
                }
                count++;
            }
        } while (!finish);
        System.out.println(count);

    }

    // 2. Сортировка вызовом
    public void directSort (int [] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array [j] < array[minPosition]) {
                    minPosition = j;
                }
                count++;
            }
            if (i != minPosition) {
                int temp = array [i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
        System.out.println(count);
    }
    // 3. Сортировка вставкой.
    public void insertSort (int []array) {
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array [i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                count++;
            }
        }
        System.out.println(count);
    }

    // 4. Бинарный поиск.
    public int binaryFind (int [] array, int value, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value) {
            return binaryFind(array, value, midpoint+1, max);
        } else {
            if (array[midpoint] > value) {
                return binaryFind(array, value, min, midpoint-1);
            } else {
                return midpoint;
            }
        }
    }
    // Переобпределение метода - бинарный поиск.
    public int binaryFind (int [] array, int value) {
        return binaryFind(array, value, 0, array.length-1);
    }


    // 5. Пирамидальная сортировка.
    public void pyramid (int [] array) {
        int n = array.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }

        for (int i = n-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heap(array, i, 0);
        }
    }

    // функция преобразования массива в двоичную кучу.
    public void heap (int [] array, int n, int i) {
        int root = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && array[left] > array[root] ) {
            root = left;
        }
        if (right < n && array[right] > array[root]) {
            root = right;
        }
        if (root != i) {
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;

            heap(array, n, root);
        }
    }

    public void printArray (int [] array ) {
        System.out.println(Arrays.toString(array));
    }

}
