// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Simple Nested Loop — O(m × n), O(m × n) — BEST GENERAL SOLUTION
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}

// RANK 2: Enhanced for Loop — O(m × n), O(m × n) — SAME EFFICIENCY / CLEANER SYNTAX
// class Solution {
//     public int[][] transpose(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int ans[][] = new int[n][m];
//         int i = 0;
//         for (int row[] : matrix) {
//             for (int j = 0; j < n; j++) {
//                 ans[j][i] = row[j];
//             }
//             i++;
//         }
//         return ans;
//     }
// }

// RANK 3: In-Place Swap — O(n²), O(1) EXTRA SPACE — BEST OPTIMIZATION FOR SQUARE MATRICES ONLY
// class Solution {
//     public int[][] transpose(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = i + 1; j < matrix.length; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
//         return matrix;
//     }
// }

// Driver code to test the Solution class
public class TransposeMatrix {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Square Matrix
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] result1 = solution.transpose(matrix1);

        // Answer:
        // [1, 4, 7]
        // [2, 5, 8]
        // [3, 6, 9]

        for (int[] row : result1) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println();

        // Test Case 2: Rectangular Matrix (2 × 3)
        int[][] matrix2 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] result2 = solution.transpose(matrix2);

        // Answer:
        // [1, 4]
        // [2, 5]
        // [3, 6]

        for (int[] row : result2) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println();

        // Test Case 3: Rectangular Matrix (3 × 2)
        int[][] matrix3 = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };

        int[][] result3 = solution.transpose(matrix3);

        // Answer:
        // [1, 3, 5]
        // [2, 4, 6]

        for (int[] row : result3) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println();

        // Test Case 4: Single Row
        int[][] matrix4 = {
                { 1, 2, 3, 4 }
        };

        int[][] result4 = solution.transpose(matrix4);

        // Answer:
        // [1]
        // [2]
        // [3]
        // [4]

        for (int[] row : result4) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println();

        // Test Case 5: Single Column
        int[][] matrix5 = {
                { 1 },
                { 2 },
                { 3 },
                { 4 }
        };

        int[][] result5 = solution.transpose(matrix5);

        // Answer:
        // [1, 2, 3, 4]

        for (int[] row : result5) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}