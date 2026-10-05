// ============================ FINAL DESTINATION ============================

// RANK 1: First Two Edges — O(1) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {

            return edges[0][0];
        }

        return edges[0][1];
    }
}

// RANK 2: Degree Counting — O(n) TIME, O(n) SPACE — GENERAL / EASY TO UNDERSTAND
// class Solution {
//     public int findCenter(int[][] edges) {
//         int n = edges.length + 1;
//         int[] degree = new int[n + 1];
//
//         for (int[] edge : edges) {
//             degree[edge[0]]++;
//             degree[1]++;
//         }
//
//         for (int i = 1; i <= n; i++) {
//             if (degree[i] == n - 1) {
//                 return i;
//             }
//         }
//
//         return -1;
//     }
// }

// RANK 3: HashMap Frequency Counting — O(n) TIME, O(n) SPACE — GENERAL / HASHING APPROACH
// class Solution {
//     public int findCenter(int[][] edges) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//
//         for (int[] edge : edges) {
//             map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
//             map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
//         }
//
//         int n = edges.length + 1;
//
//         for (int node : map.keySet()) {
//             if (map.get(node) == n - 1) {
//                 return node;
//             }
//         }
//
//         return -1;
//     }
// }

// RANK 4: Brute Force — O(n²) TIME, O(1) EXTRA SPACE — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public int findCenter(int[][] edges) {
//         int n = edges.length + 1;
//
//         for (int candidate = 1; candidate <= n; candidate++) {
//             int count = 0;
//
//             for (int[] edge : edges) {
//                 if (edge[0] == candidate || edge[1] == candidate) {
//                     count++;
//                 }
//             }
//
//             if (count == n - 1) {
//                 return candidate;
//             }
//         }
//
//         return -1;
//     }
// }

// Driver code to test the Solution class
public class FindCenterOfStarGraph {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] edges1 = {
            {1, 2},
            {2, 3},
            {4, 2}
        };
        System.out.println(solution.findCenter(edges1)); // Answer: 2

        int[][] edges2 = {
            {1, 2},
            {5, 1},
            {1, 3},
            {1, 4}
        };
        System.out.println(solution.findCenter(edges2)); // Answer: 1

        int[][] edges3 = {
            {2, 1},
            {2, 3},
            {4, 2}
        };
        System.out.println(solution.findCenter(edges3)); // Answer: 2

        int[][] edges4 = {
            {5, 1},
            {2, 5},
            {5, 3},
            {4, 5}
        };
        System.out.println(solution.findCenter(edges4)); // Answer: 5

        int[][] edges5 = {
            {3, 1},
            {2, 3},
            {3, 4}
        };
        System.out.println(solution.findCenter(edges5)); // Answer: 3
    }
}