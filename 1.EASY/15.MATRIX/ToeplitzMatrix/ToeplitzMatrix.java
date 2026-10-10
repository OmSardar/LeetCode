// ============================ FINAL DESTINATION ============================

// RANK 1: Compare Each Cell with Top-Left Diagonal — O(m × n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 1; row < rows; row++) {

            for (int col = 1; col < cols; col++) {

                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// RANK 2: Compare Diagonals — O(m × n) TIME, O(1) SPACE — Direct Diagonal Approach
// class Solution {
//     public boolean isToeplitzMatrix(int[][] matrix) {
//
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//
//         // Start from every cell in the first row
//         for (int col = 0; col < cols; col++) {
//
//             int row = 0;
//             int currentCol = col;
//
//             int value = matrix[row][currentCol];
//
//             while (row < rows && currentCol < cols) {
//
//                 if (matrix[row][currentCol] != value) {
//                     return false;
//                 }
//
//                 row++;
//                 currentCol++;
//             }
//         }
//
//         // Start from every cell in the first column
//         for (int row = 1; row < rows; row++) {
//
//             int currentRow = row;
//             int col = 0;
//
//             int value = matrix[currentRow][col];
//
//             while (currentRow < rows && col < cols) {
//
//                 if (matrix[currentRow][col] != value) {
//                     return false;
//                 }
//
//                 currentRow++;
//                 col++;
//             }
//         }
//
//         return true;
//     }
// }

// RANK 3: Store Diagonal Values in HashMap — O(m × n) TIME, O(m + n) SPACE — Alternative
// import java.util.HashMap;
//
// class Solution {
//     public boolean isToeplitzMatrix(int[][] matrix) {
//
//         HashMap<Integer, Integer> diagonal = new HashMap<>();
//
//         for (int row = 0; row < matrix.length; row++) {
//
//             for (int col = 0; col < matrix[0].length; col++) {
//
//                 // Cells on the same diagonal have the same row - col.
//                 int key = row - col;
//
//                 if (diagonal.containsKey(key)) {
//
//                     if (diagonal.get(key) != matrix[row][col]) {
//                         return false;
//                     }
//
//                 } else {
//                     diagonal.put(key, matrix[row][col]);
//                 }
//             }
//         }
//
//         return true;
//     }
// }


// Driver code to test the Solution class
public class ToeplitzMatrix {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        System.out.println(solution.isToeplitzMatrix(matrix1));
        // Answer: true


        // Test Case 2
        int[][] matrix2 = {
                {1, 2},
                {2, 2}
        };

        System.out.println(solution.isToeplitzMatrix(matrix2));
        // Answer: false


        // Test Case 3
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 1, 2},
                {5, 4, 1}
        };

        System.out.println(solution.isToeplitzMatrix(matrix3));
        // Answer: true


        // Test Case 4
        int[][] matrix4 = {
                {1}
        };

        System.out.println(solution.isToeplitzMatrix(matrix4));
        // Answer: true


        // Test Case 5
        int[][] matrix5 = {
                {1, 2, 3},
                {4, 1, 2}
        };

        System.out.println(solution.isToeplitzMatrix(matrix5));
        // Answer: true


        // Test Case 6
        int[][] matrix6 = {
                {1, 2, 3},
                {4, 1, 9},
                {5, 4, 1}
        };

        System.out.println(solution.isToeplitzMatrix(matrix6));
        // Answer: false
    }
}