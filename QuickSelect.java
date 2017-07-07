import java.util.*;

public class QuickSelect {
    private static int quickSelect(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int q = randPartition(arr, start, end);
            if (q == target) return arr[q];
            if (target < q) end = q - 1;
            else start = q + 1;
        }
        return arr[start];
    }
    private static int randPartition(int[] arr, int p, int r) {
        if (p >= r) return p;
        int index = (int)(Math.random() * (r - p + 1) + p);
        swap(arr, index, r);
        int pivot = arr[r];
        int i = p - 1, j = p;
        while (j < r) {
            if (arr[j] <= pivot) swap(arr, ++i, j++);
            else j++;
        }
        swap(arr, ++i, r);     
        return i;
    }
    private static void swap(int[] arr, int p, int r) {
        int t = arr[p];
        arr[p] = arr[r];
        arr[r] = t;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,1,2,3,7,6,5,4,3,2,1};
        for (int i = 0; i < 10000; ++i) {
            if (quickSelect(arr, 6) != 3) {
                System.out.println("\nError");
                System.exit(1);
            }
        }
    }
}