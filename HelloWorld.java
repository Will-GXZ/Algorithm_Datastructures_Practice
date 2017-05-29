import java.util.*;
import java.util.function.*;

public class HelloWorld {
    public static int kmp(String source, String target) {
        // KMP implementation.
        if (source == null || target == null) return -1;
        if (target.length() == 0) return 0;
        int[] next = getNextArr(target);
        int lenS = source.length();
        int lenP = target.length();
        int i = 0, j = 0;
        while (i < lenS && j < lenP) {
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (i == lenS) return -1;
        else return i - j;
    }
    private static int[] getNextArr(String p) {
        int len = p.length();
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                next[++j] = ++k;
                if (p.charAt(j) == p.charAt(k)) {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        for (int n : next) System.out.println(n);
        return next;
    }
    public static void main(String[] args) {
        int res = kmp("abcdab", "da");
        System.out.println(res);
    }
}