// ============================ FINAL DESTINATION ============================
import java.util.*;

// RANK 1: DFS + Adjacency List — O(V + E) TIME, O(V + E) SPACE — BEST / OPTIMAL / MOST NATURAL
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(
        int current,
        int destination,
        List<List<Integer>> graph,
        boolean[] visited
    ) {

        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : graph.get(current)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

// RANK 2: BFS + Adjacency List — O(V + E) TIME, O(V + E) SPACE — ITERATIVE / EASY TO UNDERSTAND
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//
//         if (source == destination) {
//             return true;
//         }
//
//         List<List<Integer>> graph = new ArrayList<>();
//
//         for (int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//         }
//
//         for (int[] edge : edges) {
//             graph.get(edge[0]).add(edge[1]);
//             graph.get(edge[1]).add(edge[0]);
//         }
//
//         boolean[] visited = new boolean[n];
//         Queue<Integer> queue = new LinkedList<>();
//
//         queue.offer(source);
//         visited[source] = true;
//
//         while (!queue.isEmpty()) {
//
//             int current = queue.poll();
//
//             if (current == destination) {
//                 return true;
//             }
//
//             for (int neighbor : graph.get(current)) {
//
//                 if (!visited[neighbor]) {
//                     visited[neighbor] = true;
//                     queue.offer(neighbor);
//                 }
//             }
//         }
//
//         return false;
//     }
// }

// RANK 3: Union-Find (Disjoint Set Union) — O((V + E) α(V)) TIME, O(V) SPACE — CONNECTIVITY-BASED
// class Solution {
//
//     private int[] parent;
//     private int[] rank;
//
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//
//         parent = new int[n];
//         rank = new int[n];
//
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }
//
//         for (int[] edge : edges) {
//             union(edge[0], edge[1]);
//         }
//
//         return find(source) == find(destination);
//     }
//
//     private int find(int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x]);
//         }
//
//         return parent[x];
//     }
//
//     private void union(int a, int b) {
//
//         int rootA = find(a);
//         int rootB = find(b);
//
//         if (rootA == rootB) {
//             return;
//         }
//
//         if (rank[rootA] < rank[rootB]) {
//             parent[rootA] = rootB;
//         } else if (rank[rootA] > rank[rootB]) {
//             parent[rootB] = rootA;
//         } else {
//             parent[rootB] = rootA;
//             rank[rootA]++;
//         }
//     }
// }

// RANK 4: DFS with Edge Scanning — O(V × E) TIME, O(V) SPACE — SIMPLE / NO ADJACENCY LIST / LEAST EFFICIENT
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//
//         boolean[] visited = new boolean[n];
//
//         return dfs(source, destination, edges, visited);
//     }
//
//     private boolean dfs(
//         int current,
//         int destination,
//         int[][] edges,
//         boolean[] visited
//     ) {
//
//         if (current == destination) {
//             return true;
//         }
//
//         visited[current] = true;
//
//         for (int[] edge : edges) {
//
//             int neighbor = -1;
//
//             if (edge[0] == current) {
//                 neighbor = edge[1];
//             } else if (edge[1] == current) {
//                 neighbor = edge[0];
//             }
//
//             if (neighbor != -1 && !visited[neighbor]) {
//
//                 if (dfs(neighbor, destination, edges, visited)) {
//                     return true;
//                 }
//             }
//         }
//
//         return false;
//     }
// }

// Driver code to test the Solution class
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test 1
        int[][] edges1 = {
            {0, 1},
            {1, 2},
            {2, 0}
        };
        System.out.println(
            solution.validPath(3, edges1, 0, 2)
        ); // Answer: true

        // Test 2
        int[][] edges2 = {
            {0, 1},
            {1, 2},
            {2, 3}
        };
        System.out.println(
            solution.validPath(4, edges2, 0, 3)
        ); // Answer: true

        // Test 3
        int[][] edges3 = {
            {0, 1},
            {2, 3}
        };
        System.out.println(
            solution.validPath(4, edges3, 0, 3)
        ); // Answer: false

        // Test 4
        int[][] edges4 = {};
        System.out.println(
            solution.validPath(1, edges4, 0, 0)
        ); // Answer: true

        // Test 5
        int[][] edges5 = {
            {0, 1},
            {1, 3},
            {3, 4},
            {4, 5}
        };
        System.out.println(
            solution.validPath(6, edges5, 0, 5)
        ); // Answer: true

        // Test 6
        int[][] edges6 = {
            {0, 1},
            {1, 2},
            {3, 4}
        };
        System.out.println(
            solution.validPath(5, edges6, 0, 4)
        ); // Answer: false
    }
}