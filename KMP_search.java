class KMP_search {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int kmpSearch(String source, String target) {
        // KMP implementation.
        if (source == null || target == null) return -1;
        if (target.length() == 0) return 0;
        int[] next = getNextArr(target);
        char[] s = source.toCharArray();
        char[] p = target.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == p.length ? i - j : -1;
    }
    private static int[] getNextArr(String pattern) {
        char[] p = pattern.toCharArray();
        int k = -1;
        int j = 0;
        int[] next = new int[p.length];
        next[0] = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                next[++j] = ++k;
                if (p[j] == p[k]) {
                    next[j] = next[k];
                }
            }
            else {
                k = next[k];
            }
        }
        return next;
    }
    public static void main(String[] args) {
        // test
        int res = kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(res);
    }
}