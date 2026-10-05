// ============================ FINAL DESTINATION ============================

// RANK 1: Sorting Rows by Strength — O(m × n + m log m) TIME, O(m) SPACE — BEST / SIMPLE / PRACTICAL

import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;

        // Store {number of soldiers, row index}
        int[][] rows = new int[m][2];

        for (int i = 0; i < m; i++) {

            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break;
                }
            }

            rows[i][0] = soldiers;
            rows[i][1] = i;
        }

        // Sort by:
        // 1. Number of soldiers
        // 2. Row index if soldiers are equal
        Arrays.sort(rows, (a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = rows[i][1];
        }

        return result;
    }
}


// RANK 2: Binary Search + Sorting — O(m log n + m log m) TIME, O(m) SPACE — FASTER ROW COUNTING
/*
import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int[][] rows = new int[m][2];

        for (int i = 0; i < m; i++) {

            int left = 0;
            int right = mat[i].length;

            // Find the first 0
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (mat[i][mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            rows[i][0] = left;
            rows[i][1] = i;
        }

        Arrays.sort(rows, (a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = rows[i][1];
        }

        return result;
    }
}
*/


// RANK 3: Max Heap — O(m × n + m log k) TIME, O(k) SPACE — GOOD WHEN k IS SMALL
/*
import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;

        // {soldiers, row index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {

                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }

                return Integer.compare(b[1], a[1]);
            }
        );

        for (int i = 0; i < m; i++) {

            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break;
                }
            }

            pq.offer(new int[]{soldiers, i});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[1];
        }

        return result;
    }
}
*/


// RANK 4: Brute Force Selection — O(m × n + m × k) TIME, O(m) SPACE — SIMPLE / NO SORTING
/*
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;

        int[] strength = new int[m];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    strength[i]++;
                } else {
                    break;
                }
            }
        }

        int[] result = new int[k];

        boolean[] used = new boolean[m];

        for (int position = 0; position < k; position++) {

            int weakest = -1;

            for (int i = 0; i < m; i++) {

                if (used[i]) {
                    continue;
                }

                if (weakest == -1
                        || strength[i] < strength[weakest]
                        || (strength[i] == strength[weakest]
                            && i < weakest)) {

                    weakest = i;
                }
            }

            result[position] = weakest;
            used[weakest] = true;
        }

        return result;
    }
}
*/


// Driver code to test the Solution class
public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1
        int[][] mat1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };

        System.out.println(
            "Test 1: " +
            Arrays.toString(solution.kWeakestRows(mat1, 3)) +
            "    // Answer: [2, 0, 3]"
        );


        // Test 2
        int[][] mat2 = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 0}
        };

        System.out.println(
            "Test 2: " +
            Arrays.toString(solution.kWeakestRows(mat2, 2)) +
            "    // Answer: [0, 3]"
        );


        // Test 3
        int[][] mat3 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        };

        System.out.println(
            "Test 3: " +
            Arrays.toString(solution.kWeakestRows(mat3, 4)) +
            "    // Answer: [3, 2, 1, 0]"
        );


        // Test 4
        int[][] mat4 = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 1, 0},
            {1, 1, 1, 1}
        };

        System.out.println(
            "Test 4: " +
            Arrays.toString(solution.kWeakestRows(mat4, 3)) +
            "    // Answer: [0, 1, 2]"
        );


        // Test 5
        int[][] mat5 = {
            {0, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {0, 0, 0}
        };

        System.out.println(
            "Test 5: " +
            Arrays.toString(solution.kWeakestRows(mat5, 2)) +
            "    // Answer: [0, 3]"
        );


        // Test 6
        int[][] mat6 = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 1, 1},
            {0, 0, 0},
            {1, 0, 0}
        };

        System.out.println(
            "Test 6: " +
            Arrays.toString(solution.kWeakestRows(mat6, 3)) +
            "    // Answer: [3, 0, 4]"
        );


        // Test 7
        int[][] mat7 = {
            {1, 1},
            {1, 0},
            {0, 0}
        };

        System.out.println(
            "Test 7: " +
            Arrays.toString(solution.kWeakestRows(mat7, 2)) +
            "    // Answer: [2, 1]"
        );


        // Test 8
        int[][] mat8 = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0}
        };

        System.out.println(
            "Test 8: " +
            Arrays.toString(solution.kWeakestRows(mat8, 3)) +
            "    // Answer: [3, 0, 1]"
        );
    }
}