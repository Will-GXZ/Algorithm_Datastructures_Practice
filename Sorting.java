// Implement sorting algorithm

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        // test here
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
        int[] arr2 = {6, 5, 4, 3, 2, 1, 0};
        int[] arr3 = {34, 5, 12, 12, 59, 846, 1323, 22, 4, 22, 8};
        int[] arr4 = {2};
        int[] arr5 = {5, 4};
        
        // testInsertionSort(arr1);
        // testInsertionSort(arr2);
        // testInsertionSort(arr3);
        // testInsertionSort(arr4);
        // testInsertionSort(arr5);
    
        // testMergeSort(arr1);
        // testMergeSort(arr2);
        // testMergeSort(arr3);
        // testMergeSort(arr4);
        // testMergeSort(arr5);

        testQuickSort(arr1);
        testQuickSort(arr2);
        testQuickSort(arr3);
        testQuickSort(arr4);
        testQuickSort(arr5);

        // testBubbleSort(arr1);
        // testBubbleSort(arr2);
        // testBubbleSort(arr3);
        // testBubbleSort(arr4);
        // testBubbleSort(arr5);

        // testSelectionSort(arr1);
        // testSelectionSort(arr2);
        // testSelectionSort(arr3);
        // testSelectionSort(arr4);
        // testSelectionSort(arr5);

        // testCountingSort(arr1);
        // testCountingSort(arr2);
        // testCountingSort(arr3);
        // testCountingSort(arr4);
        // testCountingSort(arr5);
    }

// Counting Sort ********************************************
    public static void testCountingSort(int[] arr) {
        int[] result = countingSort(arr);
        System.out.print("countingSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n"); 
    }
    public static int[] countingSort(int[] arr) {
        int[] ret = arr.clone();
        int min = ret[0], max = ret[0];
        for (int num : arr) {
            if (num > max)      max = num;
            else if (num < min) min = num;
        }
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min]++;
        }
        for (int i = 1; i < count.length; ++i) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; --i) {
            ret[--count[arr[i] - min]] = arr[i];
        }
        return ret;
    } 


// Selection sort **************************************************
    // left part is sorted, find min of the rest part in each iteration and swap
    // with the left most element of the right part.
    public static void testSelectionSort(int[] arr) {
        int[] result = selectionSort(arr);
        System.out.print("selectionSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }
    public static int[] selectionSort(int[] arr) {
        int[] ret = arr.clone();
        for (int i = 0; i < ret.length; ++i) {
            int minIndex = i;
            for (int j = i; j < ret.length; ++j) {
                if (ret[j] < ret[minIndex]) minIndex = j;
            }
            swap(ret, minIndex, i);
        }
        return ret;
    }

// Bubble sort **********************************************
    // Iterate n times, swap larger neighbors to right in each iteration.
    public static void testBubbleSort(int[] arr) {
        int[] result = bubbleSort(arr);
        System.out.print("bubbleSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }
    public static int[] bubbleSort(int[] arr) {
        int[] ret = arr.clone();
        boolean flag;
        for (int i = 0; i < ret.length; ++i) {
            for (int j = 1; j < ret.length; ++j) {
                if (ret[j] < ret[j - 1]) {
                    swap(ret, j, j - 1);
                    flag = true;
                }
            }
        }
        return ret;
    }


// Insertion sort ******************************************
    public static void testInsertionSort(int[] arr) {
        int[] result = insertionSort(arr);
        System.out.print("insertionSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }

    public static int[] insertionSort(int[] arr) {
        int[] ret = arr.clone();
        for (int i = 0; i < ret.length; ++i) {
            int key = ret[i], j = i - 1;
            while (j >= 0 && ret[j] > key) {
                ret[j + 1] = ret[j--];
            }
            ret[j + 1] = key;
        }
        return ret;
    }


// Merge sort ************************************************
    public static void testMergeSort(int[] arr) {
        int[] result = mergeSort(arr);
        System.out.print("mergeSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }
    public static int[] mergeSort(int[] arr) {
        int[] ret = arr.clone();
        mergeSort(ret, 0, ret.length - 1);
        return ret;
    }
    private static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
    private static void merge(int[] arr, int p, int q, int r) {
        int[] aux = Arrays.copyOfRange(arr, p, r + 1);
        int i = 0, j = q + 1 - p;
        for (int k = p; k <= r; ++k) {
            if      (i > q - p)       arr[k] = aux[j++];
            else if (j > r - p)       arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else                      arr[k] = aux[j++];
        }
    }

// Quick sort ************************************************
    public static void testQuickSort(int[] arr) {
        int[] result = quickSort(arr);
        System.out.print("quickSort output: { ");
        for (int n : result) { 
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }
    public static int[] quickSort(int[] arr) {
        int[] ret = arr.clone();
        quickSort(ret, 0, ret.length - 1);
        return ret;
    }
    private static void quickSort(int[] arr, int p, int r) {
        if (p >= r) return;
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for (int j = p; j <= r; j++) {
            if (arr[j] < pivot) swap(arr, ++i, j);
        }
        swap(arr, ++i, r);
        return i;
    }
    private static void swap(int[] arr, int p, int q) {
        int t = arr[p];
        arr[p] = arr[q];
        arr[q] = t;
    }
}




















