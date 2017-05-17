// Implement sorting algorithm

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        // test here
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
        int[] arr2 = {6, 5, 4, 3, 2, 1, 0};
        int[] arr3 = {34, 5, 12, 12, 59, 846, 1323, 22, 4, 22};
        int[] arr4 = {2};
        int[] arr5 = {5, 4};
        
        // testInsertionSort(arr1);
        // testInsertionSort(arr2);
        // testInsertionSort(arr3);
        // testInsertionSort(arr4);
        // testInsertionSort(arr5);
    
        testMergeSort(arr1);
        testMergeSort(arr2);
        testMergeSort(arr3);
        testMergeSort(arr4);
        testMergeSort(arr5);
    }

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
        for (int j = 1; j < ret.length; ++j) {
            int key = ret[j];
            int i = j - 1;
            while (i >= 0 && ret[i] > key) {
                ret[i + 1] = ret[i];
                i--; 
            }
            ret[i + 1] = key;
        }
        return ret;
    }


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
        if (p >= r) { return; }
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
    private static void merge(int[] arr, int p, int q, int r) {
        int[] aux = Arrays.copyOfRange(arr, p, r + 1);
        int i = 0, j = q + 1 - p;
        for (int k = p; k <= r; k++) {
            if      (i > q - p)       { arr[k] = aux[j++]; }
            else if (j > r - p)       { arr[k] = aux[i++]; }
            else if (aux[i] < aux[j]) { arr[k] = aux[i++]; }
            else                      { arr[k] = aux[j++]; }
        }
    }

}




















