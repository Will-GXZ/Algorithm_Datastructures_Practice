import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.*;
 
public class HelloWorld {
    private static int quickSelect(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int q = randPartition(arr, start, end);
            if (q == target) return q;
            if (target < q) end = q - 1;
            else start = q + 1;
        }
        return arr[start];
    }
    private static int randPartition(int[] arr, int p, int r) {
        if (p >= r) return p;
        int index = (int)(Math.random() * (r - p + 1) + p);
        swap(arr, index, r);
        System.out.println("p: " + p + ", " + "r: " + r + ", " + "index: " + index);
        int pivot = arr[r];
        int i = p - 1, j = p;
        while (j < r) {
            if (arr[j] <= pivot) swap(arr, ++i, j++);
            else j++;
        }
        swap(arr, ++i, r);
        System.out.println("partition: " + i);
        for (int n : arr) System.out.print(n + " ");
        System.out.println();        
        return i;
    }
    private static void swap(int[] arr, int p, int r) {
        int t = arr[p];
        arr[p] = arr[r];
        arr[r] = t;
    }
     public static void main(String []args){
        // int[] e = new int[] {7,6,5,4,3,2,1,2,3,4,5};
        // int s = quickSelect(e, 5);
        // System.out.println(s);
        // for (int n : e) System.out.print(n + " ");
        for (int i = 0; i < 100; ++i) {
            int test = (int)(Math.random() * 2);
            System.out.println(test);
        }   
    }
}
