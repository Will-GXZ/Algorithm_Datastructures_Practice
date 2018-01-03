// Implement sorting algorithm

import java.util.*;
import java.util.stream.*;

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

        testMergeSort(arr1);
        testMergeSort(arr2);
        testMergeSort(arr3);
        testMergeSort(arr4);
        testMergeSort(arr5);

        // testQuickSort(arr1);
        // testQuickSort(arr2);
        // testQuickSort(arr3);
        // testQuickSort(arr4);
        // testQuickSort(arr5);

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
    // stable counting sort
    public static void testCountingSort(int[] arr) {
        int[] result = countingSort(arr);
        System.out.print("countingSort output: { ");
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }
    public static int[] countingSort(int[] arr) {
        int[] ret = new int[arr.length];
        // 先建一个长度等于数据范围的数组
        int min = arr[0], max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
            else if (i < min) min = i;
        }
        int[] count = new int[max - min + 1];
        // 数组中每个位置存放input array中对应元素出现的次数
        for (int i : arr) {
            count[i - min]++;
        }
        // 为了stable，将count数组转换为原始count数组的preSum数组, 到这里为止，解释一下：
        // 现在count 数组中的 count[i] 表示原数组arr中有 count[i] 个数小于等于 i+min;
        // 则我们可知原数组中位置最靠右的 i+min, 它在结果中的位置一定是 index=count[i]-1
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }
        // 根据如上理由，ret中的数 x（最靠右的x） 在count中对应的下标应为 x-min，而 count[x-min]-1 就
        // 是 x 在ret中的 index，于是将 x 放在 ret[count[x-min]]-1 之后，还要将 count[x-min] 也减一
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
        for (int i = 0; i < ret.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < ret.length; ++j) {
                if (ret[minIndex] > ret[j]) minIndex = j;
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
        for (int i = 0; i < ret.length; ++i) {
            for (int j = 1; j < ret.length; ++j) {
                if (ret[j - 1] > ret[j]) swap(ret, j, j - 1);
            }
        }
        return ret;
    }


// Insertion sort ******************************************
    // maintain a sorted sequence at left, insert one element at one time
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
        for (int i = 1; i < ret.length; ++i) {
            int key = ret[i];
            int j = 0;
            for (j = i - 1; j >= 0 && ret[j] > key; --j) {
                ret[j + 1] = ret[j];
            }
            ret[j + 1] = key;
        }
        return ret;
    }


// Merge sort ************************************************
/*
    MergeSort 为什么需要 O(n) space：
    因为每次我们需要把两个sorted array merge 到原来的 array 中的时候，我们必须新建辅助数组
    储存那两个array，这个过程在recursion的过程中，至多消耗O(n)的space；
*/
    public static void testMergeSort(int[] arr) {
        int[] result = mergeSort(arr);
        System.out.print("mergeSort output: { ");
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.print(" }\n");
    }

    // // 每次复制数组的写法
    // public static int[] mergeSort(int[] arr) {
    //     if (arr.length == 1) return arr;
    //     int mid = arr.length / 2 - 1;
    //     int[] left = null, right = null;
    //     if (mid + 1 >= 0) {
    //         left = Arrays.copyOfRange(arr, 0, mid + 1);
    //     }
    //     if (arr.length >= mid + 1) {
    //         right = Arrays.copyOfRange(arr, mid + 1, arr.length);
    //     }
    //     int[] sortedLeft = mergeSort(left);
    //     int[] sortedRight = mergeSort(right);
    //     if (sortedLeft != null && sortedRight != null) {
    //         return merge(sortedLeft, sortedRight);
    //     } else if (sortedLeft != null) return sortedLeft;
    //     else return sortedRight;
    // }
    //
    // private static int[] merge(int[] arr1, int[] arr2) {
    //     int[] ret = new int[arr1.length + arr2.length];
    //     int left = 0, right = 0;
    //     for (int i = 0; i < ret.length; ++i) {
    //         if (left >= arr1.length) ret[i] = arr2[right++];
    //         else if (right >= arr2.length) ret[i] = arr1[left++];
    //         else if (arr1[left] < arr2[right]) ret[i] = arr1[left++];
    //         else ret[i] = arr2[right++];
    //     }
    //     return ret;
    // }




    // MergeSort 简洁的写法
    public static int[] mergeSort(int[] arr) {
        int[] ret = Arrays.copyOf(arr, arr.length);
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

    // 写这个函数之前先画图：
    //  input arr: __|p|__________| q |______| r |_____
    //  aux:         |0|__________|q-p|______|r-p|
    private static void merge(int[] arr, int p, int q, int r) {
        int[] aux = Arrays.copyOfRange(arr, p, r + 1);
        int i = 0, j = q - p + 1;
        for (int k = p; k < r + 1; ++k) {
            if (i > q - p)            arr[k] = aux[j++];
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
        int[] ret = Arrays.copyOf(arr, arr.length);
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
        // // use the last element as pivot
        // int pivot = arr[r];
        // int i = p - 1, j = p;
        // while (j < r) {
        //     if (arr[j] <= pivot) swap(arr, ++i, j++);
        //     else j++;
        // }
        // swap(arr, ++i, r);
        // return i;


           // 或者让j最右移到r，这样不需要另外换r到i+1
        int pivot = arr[r];
        int i = p - 1, j = p;
        while (j <= r) {
            if (arr[j] <= pivot) swap(arr, ++i, j++);
            else j++;
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
