import java.util.*;

// // traditional Tree implementation
// class UnionFind {
//     private class Node {
//         int val, rank;
//         Node parent;
//         public Node(int val) {
//             this.val = val;
//             this.rank = 0;
//             this.parent = this;
//         }
//     }
//     private Map<Integer, Node> disjointSet;

//     // if x is not already in the set, add x
//     public void makeSet(int x) {
//         if (disjointSet == null) disjointSet = new HashMap<>();
//         if (! disjointSet.containsKey(x)) {
//             disjointSet.put(x, new Node(x));
//         }
//     }

//     public Node find(int x) {
//         if (! disjointSet.containsKey(x)) return null;
//         Node nodex = disjointSet.get(x);
//         return find(nodex);
//     }
//     // find the root of x, do path compression along recursion
//     private Node find(Node nodex) {
//         // path compression
//         while (nodex.parent != nodex) {
//             nodex.parent = find(nodex.parent);
//             nodex = nodex.parent;
//         }
//         return nodex;
//     }

//     public void union(int x, int y) {
//         Node rootx = find(x);
//         Node rooty = find(y);
//         if (rootx == null || rooty == null) return;
//         // union by rank 优化
//         if (rootx.rank < rooty.rank) {
//             rootx.parent = rooty;
//         } else if (rootx.rank > rooty.rank) {
//             rooty.parent = rootx;
//         } else {
//             // 只有当合并之前两者rank相同的时候才需要增加rank
//             rootx.parent = rooty;
//             rooty.rank++;
//         }
//     }

//     public static void main(String[] args) {
//         // test
//         UnionFind uf = new UnionFind();
//         // 1,2,3,4,5 五个set
//         uf.makeSet(1);
//         uf.makeSet(2);
//         uf.makeSet(3);
//         uf.makeSet(4);
//         uf.makeSet(5);
//         // for (int i = 1; i < 6; ++i) System.out.println(uf.find(i).val);

//         // 合并 1，2 以及 3，4，5
//         uf.union(1,2);
//         uf.union(3,4);
//         uf.union(4,5);
//         // for (int i = 1; i < 6; ++i) System.out.println(uf.find(i).val);

//         // 合并 1，5
//         uf.union(1, 5);
//         for (int i = 1; i < 6; ++i) System.out.println(uf.find(i).val);
//     }
// }


// int array implementation
class UnionFind {
    private int[] ids; // index是id本身，val 存的是parent的index
    private int[] rank;
    public void makeSet(int maxSize) {
        ids = new int[maxSize];
        rank = new int[maxSize]; // 初始rank都为0
        for (int i = 0; i < ids.length; ++i) {
            // 初始时刻令每个元素的parent都指向自己
            ids[i] = i;
        }
    }

    public int find(int x) {
        while (ids[x] != x) {
            // path compress
            ids[x] = find(ids[x]); // 等价于 x.parent = find(x.parent)
            x = ids[x];
        }
        return x;
    }

    public void union(int x, int y) {
        // 先找到 x 和 y 的root
        int rootx = find(x);
        int rooty = find(y);
        // union by rank
        if (rank[rootx] < rank[rooty]) {
            ids[rootx] = rooty;
        } else if (rank[rooty] < rank[rootx]) {
            ids[rooty] = rootx;
        } else {
            ids[rootx] = rooty;
            rank[rooty]++;
        }
    }

    public static void main(String[] args) {
        // test
        UnionFind uf = new UnionFind();
        // 1,2,3,4,5 五个set
        uf.makeSet(6);
        // for (int i = 1; i < 6; ++i) System.out.println(uf.find(i));

        // 合并 1，2 以及 3，4，5
        uf.union(1,2);
        uf.union(3,4);
        uf.union(4,5);
        // for (int i = 1; i < 6; ++i) System.out.println(uf.find(i));

        // 合并 1，5
        uf.union(1, 5);
        for (int i = 1; i < 6; ++i) System.out.println(uf.find(i));
    }
}






