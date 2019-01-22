/**
 * Quick Selection
 * 
 * Find K-th smallest number in O(n) time
 */

import java.util.*;

public class QuickSelect {

  // public static int quickSelect(int[] arr, int rank) {
  //   int p = 0, r = arr.length - 1;
  //   while (p < r) {
  //     int index = partition(arr, p, r);
  //     if (index == rank) return arr[index];
  //     else if (index < rank) p = index + 1;
  //     else r = index - 1;
  //   }
  //   return arr[p];
  // }
  //
  // private static int partition(int[] arr, int p, int r) {
  //   if (p == r) return p;
  //   int rand = (int)(Math.random() * (r - p + 1)) + p;
  //   swap(arr, r, rand);
  //   int pivot = arr[r];
  //   int i = p - 1, j = p;
  //   while (j <= r) {
  //     if (arr[j] <= pivot) swap(arr, ++i, j);
  //     j++;
  //   }
  //   return i;
  // }
  
  public static int quickSelect(int[] arr, int k) {
    int left = 0, right = arr.length - 1;
    while (true) {
      int mid = partition(arr, left, right);
      if (mid == k) return arr[mid];
      else if (mid < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }

  // select the last number as pivot, 
  // put all numbers <= pivot to left,
  // put all numbers > pivot to right,
  // put pivot in the middle, 
  // return pivot's index 
  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int i = left - 1;
    for (int j = left; j <= right; ++j) {
      if (arr[j] <= pivot) swap(arr, ++i, j);
    }
    return i;
  }

  private static void swap(int[] arr, int p, int r) {
    int t = arr[p];
    arr[p] = arr[r];
    arr[r] = t;
  }
  public static void main(String[] args) {
    int[] arr = new int[] {9,4,2,8,7,6,5,4,3,2,1,2,3,12,56,23,5,1,3,7,9,4,21,4,6,8,3};
    for (int i = 0; i < 10; ++i) {
      int[] dup = Arrays.copyOf(arr, arr.length);
      int a = quickSelect(dup, 17);
      if (a != 7) {
        System.out.println("error! " + a);
        System.exit(1);
      }
    }
    arr = new int[]{1};
    if (quickSelect(arr, 0) == 1) {
      System.out.println("pass {1}:0 -> 1");
    }
    arr = new int[]{1,2};
    if (quickSelect(arr, 1) == 2) {
      System.out.println("pass {1,2}:1 -> 2");
    }
  }
}
