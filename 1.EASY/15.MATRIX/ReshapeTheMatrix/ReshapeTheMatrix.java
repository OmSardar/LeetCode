// ============================ FINAL DESTINATION ============================
import java.util.*;


// RANK 1: Single-Pass Mapping — O(m × n) TIME, O(m × n) OUTPUT SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // If the total number of elements is different,
        // reshaping is impossible.
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        for (int i = 0; i < m * n; i++) {

            // Position in the original matrix
            int originalRow = i / n;
            int originalCol = i % n;

            // Position in the new matrix
            int newRow = i / c;
            int newCol = i % c;

            result[newRow][newCol] = mat[originalRow][originalCol];
        }

        return result;
    }
}


// RANK 2: Nested Loops + Separate Indices — O(m × n) TIME, O(m × n) OUTPUT SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
//
//         int m = mat.length;
//         int n = mat[0].length;
//
//         if (m * n != r * c) {
//             return mat;
//         }
//
//         int[][] result = new int[r][c];
//
//         int row = 0;
//         int col = 0;
//
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//
//                 result[row][col] = mat[i][j];
//
//                 col++;
//
//                 if (col == c) {
//                     col = 0;
//                     row++;
//                 }
//             }
//         }
//
//         return result;
//     }
// }

// RANK 3: Flatten + Reshape — O(m × n) TIME, O(m × n) SPACE — SIMPLE / EXTRA MEMORY
// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
//         int m = mat.length;
//         int n = mat[0].length;
//         if (m * n != r * c) {
//             return mat;
//         }
        
//         int[] flat = new int[m * n];
//         int index = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 flat[index++] = mat[i][j];
//             }
//         }

//         int[][] result = new int[r][c];
//         index = 0;

//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 result[i][j] = flat[index++];
//             }
//         }
//         return result;
//     }
// }

// Driver code to test the Solution class
public class ReshapeTheMatrix {
    public static void main(String[] args) {

        Solution s = new Solution();


        // Test Case 1
        int[][] mat1 = {
            {1, 2},
            {3, 4}
        };

        int[][] result1 = s.matrixReshape(mat1, 1, 4);

        for (int[] row : result1) {
            System.out.println(Arrays.toString(row));
        }
        // Answer: [1, 2, 3, 4]


        System.out.println();


        // Test Case 2
        int[][] mat2 = {
            {1, 2},
            {3, 4}
        };

        int[][] result2 = s.matrixReshape(mat2, 4, 1);

        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
        // Answer:
        // [1]
        // [2]
        // [3]
        // [4]


        System.out.println();


        // Test Case 3
        int[][] mat3 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] result3 = s.matrixReshape(mat3, 3, 2);

        for (int[] row : result3) {
            System.out.println(Arrays.toString(row));
        }
        // Answer:
        // [1, 2]
        // [3, 4]
        // [5, 6]


        System.out.println();


        // Test Case 4
        int[][] mat4 = {
            {1, 2},
            {3, 4}
        };

        int[][] result4 = s.matrixReshape(mat4, 2, 2);

        for (int[] row : result4) {
            System.out.println(Arrays.toString(row));
        }
        // Answer:
        // [1, 2]
        // [3, 4]


        System.out.println();


        // Test Case 5
        int[][] mat5 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] result5 = s.matrixReshape(mat5, 4, 2);

        for (int[] row : result5) {
            System.out.println(Arrays.toString(row));
        }
        // Answer: Original matrix returned because
        // 2 × 3 != 4 × 2
    }
}