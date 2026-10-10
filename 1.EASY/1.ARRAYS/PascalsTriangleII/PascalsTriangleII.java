// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: One-Row Dynamic Programming — O(n²) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {

            row.add(1);

            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }
}


// RANK 2: Binomial Coefficient — O(n) TIME, O(n) SPACE — MATHEMATICAL / MOST EFFICIENT TIME
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//
//         List<Integer> row = new ArrayList<>();
//
//         long value = 1;
//
//         for (int col = 0; col <= rowIndex; col++) {
//
//             row.add((int) value);
//
//             value = value * (rowIndex - col) / (col + 1);
//         }
//
//         return row;
//     }
// }


// RANK 3: Full Pascal's Triangle — O(n²) TIME, O(n²) SPACE — SIMPLE / DIRECT / EXTRA MEMORY
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//
//         List<List<Integer>> triangle = new ArrayList<>();
//
//         for (int i = 0; i <= rowIndex; i++) {
//
//             List<Integer> row = new ArrayList<>();
//             row.add(1);
//
//             for (int j = 1; j < i; j++) {
//                 row.add(
//                     triangle.get(i - 1).get(j - 1)
//                     + triangle.get(i - 1).get(j)
//                 );
//             }
//
//             if (i > 0) {
//                 row.add(1);
//             }
//
//             triangle.add(row);
//         }
//
//         return triangle.get(rowIndex);
//     }
// }


// RANK 4: Recursive Construction — O(n²) TIME, O(n²) SPACE — RECURSIVE / INTUITIVE
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//
//         if (rowIndex == 0) {
//             return new ArrayList<>(Arrays.asList(1));
//         }
//
//         List<Integer> previous = getRow(rowIndex - 1);
//         List<Integer> row = new ArrayList<>();
//
//         row.add(1);
//
//         for (int i = 1; i < previous.size(); i++) {
//             row.add(previous.get(i - 1) + previous.get(i));
//         }
//
//         row.add(1);
//
//         return row;
//     }
// }


// Driver code to test the Solution class
public class PascalsTriangleII {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: First row
        int rowIndex1 = 0;
        System.out.println(
            "Test Case 1: " + solution.getRow(rowIndex1)
        ); // Answer: [1]


        // Test Case 2: Second row
        int rowIndex2 = 1;
        System.out.println(
            "Test Case 2: " + solution.getRow(rowIndex2)
        ); // Answer: [1, 1]


        // Test Case 3: Third row
        int rowIndex3 = 2;
        System.out.println(
            "Test Case 3: " + solution.getRow(rowIndex3)
        ); // Answer: [1, 2, 1]


        // Test Case 4: Fifth row
        int rowIndex4 = 4;
        System.out.println(
            "Test Case 4: " + solution.getRow(rowIndex4)
        ); // Answer: [1, 4, 6, 4, 1]


        // Test Case 5: Sixth row
        int rowIndex5 = 5;
        System.out.println(
            "Test Case 5: " + solution.getRow(rowIndex5)
        ); // Answer: [1, 5, 10, 10, 5, 1]


        // Test Case 6: Tenth row
        int rowIndex6 = 10;
        System.out.println(
            "Test Case 6: " + solution.getRow(rowIndex6)
        ); // Answer: [1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1]


        // Test Case 7: Row 3
        int rowIndex7 = 3;
        System.out.println(
            "Test Case 7: " + solution.getRow(rowIndex7)
        ); // Answer: [1, 3, 3, 1]


        // Test Case 8: Row 7
        int rowIndex8 = 7;
        System.out.println(
            "Test Case 8: " + solution.getRow(rowIndex8)
        ); // Answer: [1, 7, 21, 35, 35, 21, 7, 1]
    }
}