// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: Dynamic Programming (Previous Row) — O(n²) TIME, O(n²) SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(
                    triangle.get(i - 1).get(j - 1)
                    + triangle.get(i - 1).get(j)
                );
            }

            if (i > 0) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }
}


// RANK 2: Dynamic Programming (In-Place Row Construction) — O(n²) TIME, O(n²) SPACE — CLEAN / EFFICIENT / GOOD ALTERNATIVE
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//
//         List<List<Integer>> triangle = new ArrayList<>();
//
//         for (int i = 0; i < numRows; i++) {
//
//             List<Integer> row = new ArrayList<>();
//
//             for (int j = 0; j <= i; j++) {
//
//                 if (j == 0 || j == i) {
//                     row.add(1);
//                 } else {
//                     row.add(
//                         triangle.get(i - 1).get(j - 1)
//                         + triangle.get(i - 1).get(j)
//                     );
//                 }
//             }
//
//             triangle.add(row);
//         }
//
//         return triangle;
//     }
// }


// RANK 3: Binomial Coefficient — O(n²) TIME, O(n²) SPACE — MATHEMATICAL / GOOD ALTERNATIVE
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//
//         List<List<Integer>> triangle = new ArrayList<>();
//
//         for (int row = 0; row < numRows; row++) {
//
//             List<Integer> currentRow = new ArrayList<>();
//
//             long value = 1;
//
//             for (int col = 0; col <= row; col++) {
//
//                 currentRow.add((int) value);
//
//                 value = value * (row - col) / (col + 1);
//             }
//
//             triangle.add(currentRow);
//         }
//
//         return triangle;
//     }
// }


// RANK 4: Recursive Row Construction — O(n²) TIME, O(n²) SPACE — RECURSIVE / INTUITIVE
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         return generateRows(numRows);
//     }
//
//     private List<List<Integer>> generateRows(int numRows) {
//
//         if (numRows == 0) {
//             return new ArrayList<>();
//         }
//
//         List<List<Integer>> triangle = generateRows(numRows - 1);
//
//         List<Integer> row = new ArrayList<>();
//
//         row.add(1);
//
//         if (!triangle.isEmpty()) {
//
//             List<Integer> previous = triangle.get(triangle.size() - 1);
//
//             for (int i = 1; i < previous.size(); i++) {
//                 row.add(previous.get(i - 1) + previous.get(i));
//             }
//
//             row.add(1);
//         }
//
//         triangle.add(row);
//
//         return triangle;
//     }
// }


// RANK 5: Recursive Combination Calculation — O(2ⁿ) TIME, O(n²) OUTPUT SPACE — LEAST EFFICIENT / BRUTE FORCE
// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//
//         List<List<Integer>> triangle = new ArrayList<>();
//
//         for (int row = 0; row < numRows; row++) {
//
//             List<Integer> currentRow = new ArrayList<>();
//
//             for (int col = 0; col <= row; col++) {
//                 currentRow.add(combination(row, col));
//             }
//
//             triangle.add(currentRow);
//         }
//
//         return triangle;
//     }
//
//     private int combination(int n, int r) {
//
//         if (r == 0 || r == n) {
//             return 1;
//         }
//
//         return combination(n - 1, r - 1)
//              + combination(n - 1, r);
//     }
// }

// Driver code to test the Solution class
public class PascalsTriangle {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: One row
        int numRows1 = 1;
        System.out.println(
            "Test Case 1: " + solution.generate(numRows1)
        ); // Answer: [[1]]


        // Test Case 2: Two rows
        int numRows2 = 2;
        System.out.println(
            "Test Case 2: " + solution.generate(numRows2)
        ); // Answer: [[1], [1, 1]]


        // Test Case 3: Three rows
        int numRows3 = 3;
        System.out.println(
            "Test Case 3: " + solution.generate(numRows3)
        ); // Answer: [[1], [1, 1], [1, 2, 1]]


        // Test Case 4: Five rows
        int numRows4 = 5;
        System.out.println(
            "Test Case 4: " + solution.generate(numRows4)
        ); // Answer: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]


        // Test Case 5: Six rows
        int numRows5 = 6;
        System.out.println(
            "Test Case 5: " + solution.generate(numRows5)
        ); // Answer: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]


        // Test Case 6: Zero rows
        int numRows6 = 0;
        System.out.println(
            "Test Case 6: " + solution.generate(numRows6)
        ); // Answer: []


        // Test Case 7: Eight rows
        int numRows7 = 8;
        System.out.println(
            "Test Case 7: " + solution.generate(numRows7)
        ); // Answer: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1], [1, 6, 15, 20, 15, 6, 1], [1, 7, 21, 35, 35, 21, 7, 1]]


        // Test Case 8: Ten rows
        int numRows8 = 10;
        System.out.println(
            "Test Case 8: " + solution.generate(numRows8)
        ); // Answer: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1], [1, 6, 15, 20, 15, 6, 1], [1, 7, 21, 35, 35, 21, 7, 1], [1, 8, 28, 56, 70, 56, 28, 8, 1], [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]]
    }
}