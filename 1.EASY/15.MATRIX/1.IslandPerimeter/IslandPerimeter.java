// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Count Land + Subtract Shared Edges — O(m × n) Time, O(1) Space — BEST PRACTICAL / SIMPLEST / MOST EFFICIENT
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;

                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}

// RANK 2: Math Formula Approach — O(m × n) Time, O(1) Space — CLEAN / ELEGANT / MATHEMATICAL
// class Solution {
//     public int islandPerimeter(int[][] grid) {
//         int land = 0, neighbors = 0;

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1) {
//                     land++;

//                     if (i > 0 && grid[i - 1][j] == 1)
//                         neighbors++;
//                     if (j > 0 && grid[i][j - 1] == 1)
//                         neighbors++;
//                 }
//             }
//         }
//         return land * 4 - neighbors * 2;
//     }
// }

// RANK 3: Check 4 Directions for Each Land Cell — O(m × n) Time, O(1) Space — GENERAL / EASY TO UNDERSTAND / FLEXIBLE
// class Solution {
//     public int islandPerimeter(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int perimeter = 0;

//         int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == 1) {
//                     for (int[] d : dirs) {
//                         int ni = i + d[0];
//                         int nj = j + d[1];

//                         if (ni < 0 || nj < 0 || ni >= rows || nj >= cols
//                             || grid[ni][nj] == 0) {
//                             perimeter++;
//                         }
//                     }
//                 }
//             }
//         }
//         return perimeter;
//     }
// }

// RANK 4: DFS (Flood Fill) — O(m × n) Time, O(m × n) Space — GOOD FOR TRAVERSAL / EXTRA SPACE / LESS PREFERRED
// class Solution {
//     int rows, cols;

//     public int islandPerimeter(int[][] grid) {
//         rows = grid.length;
//         cols = grid[0].length;

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == 1) {
//                     return dfs(grid, i, j);
//                 }
//             }
//         }
//         return 0;
//     }
    
//     private int dfs(int[][] grid, int i, int j) {
//         if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) {
//             return 1;
//         }
//         if (grid[i][j] == -1) {
//             return 0;
//         }

//         grid[i][j] = -1;

//         return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
//     }
// }

// Driver code to test the Solution class
public class IslandPerimeter {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        int[][] grid1 = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        System.out.println("Island Perimeter: " + obj.islandPerimeter(grid1));
        // Island Perimeter: 16


        // Test 2
        int[][] grid2 = {
            {1}
        };

        System.out.println("Island Perimeter: " + obj.islandPerimeter(grid2));
        // Island Perimeter: 4


        // Test 3
        int[][] grid3 = {
            {1, 1},
            {1, 1}
        };

        System.out.println("Island Perimeter: " + obj.islandPerimeter(grid3));
        // Island Perimeter: 8


        // Test 4
        int[][] grid4 = {
            {1, 0},
            {0, 0}
        };

        System.out.println("Island Perimeter: " + obj.islandPerimeter(grid4));
        // Island Perimeter: 4
    }
}