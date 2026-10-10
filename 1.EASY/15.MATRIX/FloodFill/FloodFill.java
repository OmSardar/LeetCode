// ============================ FINAL DESTINATION ============================
import java.util.*;

// RANK 1: DFS Recursion — O(m × n) TIME, O(m × n) SPACE — BEST / MOST PRACTICAL

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If the starting color is already the new color,
        // nothing needs to be changed.
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col,
                     int originalColor, int newColor) {

        // Out of bounds
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length) {
            return;
        }

        // Stop if this cell does not have the original color
        if (image[row][col] != originalColor) {
            return;
        }

        // Change the current cell
        image[row][col] = newColor;

        // Visit four directions
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
    }
}

// RANK 2: BFS with Queue — O(m × n) TIME, O(m × n) SPACE — Iterative / Robust
// import java.util.*;
//
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//
//         int originalColor = image[sr][sc];
//
//         if (originalColor == color) {
//             return image;
//         }
//
//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{sr, sc});
//
//         image[sr][sc] = color;
//
//         int[][] directions = {
//             {-1, 0},
//             {1, 0},
//             {0, -1},
//             {0, 1}
//         };
//
//         while (!queue.isEmpty()) {
//
//             int[] current = queue.poll();
//
//             int row = current[0];
//             int col = current[1];
//
//             for (int[] direction : directions) {
//
//                 int newRow = row + direction[0];
//                 int newCol = col + direction[1];
//
//                 if (newRow >= 0 && newRow < image.length &&
//                     newCol >= 0 && newCol < image[0].length &&
//                     image[newRow][newCol] == originalColor) {
//
//                     image[newRow][newCol] = color;
//
//                     queue.offer(new int[]{newRow, newCol});
//                 }
//             }
//         }
//
//         return image;
//     }
// }

// RANK 3: DFS with Explicit Stack — O(m × n) TIME, O(m × n) SPACE — Iterative DFS
// import java.util.*;
//
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//
//         int originalColor = image[sr][sc];
//
//         if (originalColor == color) {
//             return image;
//         }
//
//         Stack<int[]> stack = new Stack<>();
//         stack.push(new int[]{sr, sc});
//
//         int[][] directions = {
//             {-1, 0},
//             {1, 0},
//             {0, -1},
//             {0, 1}
//         };
//
//         image[sr][sc] = color;
//
//         while (!stack.isEmpty()) {
//
//             int[] current = stack.pop();
//
//             int row = current[0];
//             int col = current[1];
//
//             for (int[] direction : directions) {
//
//                 int newRow = row + direction[0];
//                 int newCol = col + direction[1];
//
//                 if (newRow >= 0 && newRow < image.length &&
//                     newCol >= 0 && newCol < image[0].length &&
//                     image[newRow][newCol] == originalColor) {
//
//                     image[newRow][newCol] = color;
//
//                     stack.push(new int[]{newRow, newCol});
//                 }
//             }
//         }
//
//         return image;
//     }
// }


// Driver code to test the Solution class
public class FloodFill {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] result1 = solution.floodFill(image1, 1, 1, 2);

        printImage(result1);
        // Answer:
        // [[2, 2, 2],
        //  [2, 2, 0],
        //  [2, 0, 1]]


        // Test Case 2
        int[][] image2 = {
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] result2 = solution.floodFill(image2, 0, 0, 2);

        printImage(result2);
        // Answer:
        // [[2, 2, 2],
        //  [2, 2, 2]]


        // Test Case 3
        int[][] image3 = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 1}
        };

        int[][] result3 = solution.floodFill(image3, 0, 0, 3);

        printImage(result3);
        // Answer:
        // [[3, 3, 0],
        //  [3, 0, 0],
        //  [3, 3, 3]]


        // Test Case 4
        int[][] image4 = {
                {1, 1},
                {1, 1}
        };

        int[][] result4 = solution.floodFill(image4, 0, 0, 1);

        printImage(result4);
        // Answer:
        // [[1, 1],
        //  [1, 1]]


        // Test Case 5
        int[][] image5 = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        int[][] result5 = solution.floodFill(image5, 1, 1, 2);

        printImage(result5);
        // Answer:
        // [[1, 0, 1],
        //  [0, 2, 0],
        //  [1, 0, 1]]
    }


    static void printImage(int[][] image) {

        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }
}