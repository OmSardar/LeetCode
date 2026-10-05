// ============================ FINAL DESTINATION ============================

// RANK 1: 3×3 Neighbor Traversal — O(m × n) TIME, O(m × n) OUTPUT SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int[][] imageSmoother(int[][] img) {

        int m = img.length;
        int n = img[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;
                int count = 0;

                // Check all 9 possible positions around (i, j)
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {

                        // Make sure the position is inside the matrix
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}


// RANK 2: Explicit 8-Direction Checking — O(m × n) TIME, O(m × n) OUTPUT SPACE — CLEAR / ALTERNATIVE
// class Solution {
//     public int[][] imageSmoother(int[][] img) {
//
//         int m = img.length;
//         int n = img[0].length;
//         int[][] result = new int[m][n];
//
//         int[][] directions = {
//             {-1, -1}, {-1, 0}, {-1, 1},
//             { 0, -1}, { 0, 0}, { 0, 1},
//             { 1, -1}, { 1, 0}, { 1, 1}
//         };
//
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//
//                 int sum = 0;
//                 int count = 0;
//
//                 for (int[] dir : directions) {
//                     int r = i + dir[0];
//                     int c = j + dir[1];
//
//                     if (r >= 0 && r < m && c >= 0 && c < n) {
//                         sum += img[r][c];
//                         count++;
//                     }
//                 }
//
//                 result[i][j] = sum / count;
//             }
//         }
//
//         return result;
//     }
// }


// Driver code to test the Solution class
public class ImageSmoother {
    public static void main(String[] args) {

        Solution s = new Solution();


        // Test Case 1
        int[][] img1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int[][] result1 = s.imageSmoother(img1);

        for (int[] row : result1) {
            System.out.println(java.util.Arrays.toString(row));
        }

        // Answer:
        // [0, 0, 0]
        // [0, 0, 0]
        // [0, 0, 0]


        System.out.println();


        // Test Case 2
        int[][] img2 = {
            {100, 200, 100},
            {200, 50, 200},
            {100, 200, 100}
        };

        int[][] result2 = s.imageSmoother(img2);

        for (int[] row : result2) {
            System.out.println(java.util.Arrays.toString(row));
        }

        // Answer:
        // [137, 141, 137]
        // [141, 138, 141]
        // [137, 141, 137]


        System.out.println();


        // Test Case 3
        int[][] img3 = {
            {5}
        };

        int[][] result3 = s.imageSmoother(img3);

        for (int[] row : result3) {
            System.out.println(java.util.Arrays.toString(row));
        }

        // Answer:
        // [5]
    }
}