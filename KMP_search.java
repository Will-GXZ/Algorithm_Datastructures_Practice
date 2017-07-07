import java.util.*;

class KMP_search {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // KMP implementation.
        if (source == null || target == null) return -1;
        if (target.length() == 0) return 0;
        int[] kmp = getKMP(target);
        int i = 0, j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) i++;
                else j = kmp[j - 1];
            }
        }
        return j == target.length() ? i - j : -1;
    }
    private int[] getKMP(String target) {
        char[] p = target.toCharArray();
        int[] kmp = new int[p.length];
        kmp[0] = 0;
        int i = 0, j = 1;
        while (j < p.length) {
            if (p[i] == p[j]) {
                kmp[j] = i + 1;
                if (p[j] == p[kmp[j - 1]]) kmp[j - 1] = kmp[kmp[j - 1]];
                i++;
                j++;
            } else {
                if (i == 0) kmp[j++] = 0;
                else i = kmp[i - 1];
            }
        }
        return kmp;
    }

    public static void main(String[] args) {
        int res = new KMP_search().strStr("abcdabcdaae", "abcdaa");
        System.out.println(res);
    }
}