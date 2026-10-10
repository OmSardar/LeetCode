// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: Row Sum — O(n²) TIME, O(n) SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += matrix[i][j];
            }
        }

        return result;
    }
}

// RANK 2: Column Sum — O(n²) TIME, O(n) SPACE — SIMPLE / GOOD ALTERNATIVE
// class Solution {
//     public int[] findDegrees(int[][] matrix) {
//         int n = matrix.length;
//         int[] result = new int[n];
//
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 result[j] += matrix[i][j];
//             }
//         }
//
//         return result;
//     }
// }

// RANK 3: Count Only Upper Triangle — O(n²) TIME, O(n) SPACE — USES UNDIRECTED GRAPH PROPERTY
// class Solution {
//     public int[] findDegrees(int[][] matrix) {
//         int n = matrix.length;
//         int[] result = new int[n];
//
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//
//                 if (matrix[i][j] == 1) {
//                     result[i]++;
//                     result[j]++;
//                 }
//             }
//         }
//
//         return result;
//     }
// }

// RANK 4: Convert Matrix to Edge List + Count Degrees — O(n²) TIME, O(n + E) SPACE — GENERAL / EXTRA MEMORY
// class Solution {
//     public int[] findDegrees(int[][] matrix) {
//         int n = matrix.length;
//         int[] result = new int[n];
//         List<int[]> edges = new ArrayList<>();
//
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//
//                 if (matrix[i][j] == 1) {
//                     edges.add(new int[]{i, j});
//                 }
//             }
//         }
//
//         for (int[] edge : edges) {
//             result[edge[0]]++;
//             result[edge[1]]++;
//         }
//
//         return result;
//     }
// }

// Driver code to test the Solution class
public class FindTheDegreeOfEachVertex {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test 1
        int[][] matrix1 = {
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix1))
        ); // Answer: [2, 2, 2]

        // Test 2
        int[][] matrix2 = {
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix2))
        ); // Answer: [1, 1, 0]

        // Test 3
        int[][] matrix3 = {
            {0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix3))
        ); // Answer: [0]

        // Test 4
        int[][] matrix4 = {
            {0, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix4))
        ); // Answer: [3, 2, 2, 3]

        // Test 5
        int[][] matrix5 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix5))
        ); // Answer: [0, 0, 0, 0]

        // Test 6
        int[][] matrix6 = {
            {0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0}
        };
        System.out.println(
            Arrays.toString(solution.findDegrees(matrix6))
        ); // Answer: [4, 4, 4, 4, 4]
    }
}