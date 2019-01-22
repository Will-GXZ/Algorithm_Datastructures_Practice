import java.util.*;

public class MinHeap {
    private int size;
    private int[] array;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public MinHeap(int[] arr) {
        this.size = arr.length;
        this.capacity = arr.length;
        this.array = arr;
        heapify();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return array[0];
    }

    public Integer poll() {
        return null;
    }

    public boolean offer(int ele) {
        return false;
    }

    public boolean update(int ele, int newEle) {
        return false;
    }

    private void heapify() {
        int start = size / 2 - 1;
        for (int i = start; i >= 0; --i) {
            downheap(i);
        }
    }

    private void upheap(int index) {
        while (index > 0 && array[(index - 1) / 2] > array[index]) {
            swap(array[(index - 1) / 2], index);
            index = (index - 1) / 2;
        }
    }

    private void swap(int i1, int i2) {
        int t = array[i1];
        array[i1] = array[i2];
        array[i2] = t;
    }

    private void downheap(int index) {
        if (2 * index + 1 >= size) return;
        int curr = index, left = 2 * index + 1, right = 2 * index + 2;
        while (left < size) {
            int minChild = left;
            if (right < size && array[right] < array[left]) {
                minChild = right;
            }
            if (array[curr] > array[minChild]) {
                swap(curr, minChild);
                curr = minChild;
                left = 2 * curr + 1;
                right = 2 * curr + 2;
            } else {
                break;
            }
        }
    }

    // test function
    private static void testMinHeap(int[] arr) {
        // take as input a int array
        MinHeap pq = new MinHeap(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }
        testMinHeap(arr);
    }
}
