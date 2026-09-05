// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Space Optimized Dynamic Programming — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;

        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}

// RANK 2: Matrix Exponentiation — O(log n) TIME, O(1) EXTRA SPACE — FASTEST ASYMPTOTICALLY / ADVANCED
// class Solution {

//     public int tribonacci(int n) {
//         if (n == 0) return 0;
//         if (n == 1 || n == 2) return 1;

//         int[][] base = {
//             {1, 1, 1},
//             {1, 0, 0},
//             {0, 1, 0}
//         };

//         int[][] result = power(base, n - 2);

//         // T2 = 1, T1 = 1, T0 = 0
//         return result[0][0] * 1 + result[0][1] * 1 + result[0][2] * 0;
//     }

//     // Matrix exponentiation
//     private int[][] power(int[][] matrix, int exp) {
//         int[][] result = {
//             {1, 0, 0},
//             {0, 1, 0},
//             {0, 0, 1}
//         };

//         while (exp > 0) {
//             if ((exp & 1) == 1) {
//                 result = multiply(result, matrix);
//             }
//             matrix = multiply(matrix, matrix);
//             exp >>= 1;
//         }
//         return result;
//     }

//     // Matrix multiplication (3x3)
//     private int[][] multiply(int[][] a, int[][] b) {
//         int[][] res = new int[3][3];
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 for (int k = 0; k < 3; k++) {
//                     res[i][j] += a[i][k] * b[k][j];
//                 }
//             }
//         }
//         return res;
//     }
// }

// RANK 3: Bottom-Up Dynamic Programming — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int tribonacci(int n) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1 || n == 2) {
//             return 1;
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = dp[2] = 1;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//         }
//         return dp[n];
//     }
// }

// RANK 4: Recursion + Memoization (Top-Down DP) — O(n) TIME, O(n) SPACE — GOOD RECURSIVE APPROACH / AVOIDES REPEATED WORK
// class Solution {
//     int[] dp = new int[38];
//     public int tribonacci(int n) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1 || n == 2) {
//             return 1;
//         }
//         if (dp[n] != 0) {
//             return dp[n];
//         }
//         dp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

//         return dp[n];
//     }
// }

// RANK 5: Pure Recursion (Brute Force) — O(3^n) TIME, O(n) STACK SPACE — LEAST EFFICIENT / BRUTE FORCE
// class Solution {
//     public int tribonacci(int n) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1 || n == 2) {
//             return 1;
//         }
//         return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
//     }
// }

// Driver code to test the Solution class
public class NthTribonacciNumber {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: n = 0
        System.out.println(solution.tribonacci(0)); // Answer: 0

        // Test Case 2: n = 1
        System.out.println(solution.tribonacci(1)); // Answer: 1

        // Test Case 3: n = 2
        System.out.println(solution.tribonacci(2)); // Answer: 1

        // Test Case 4: n = 3
        System.out.println(solution.tribonacci(3)); // Answer: 2

        // Test Case 5: n = 4
        System.out.println(solution.tribonacci(4)); // Answer: 4

        // Test Case 6: n = 5
        System.out.println(solution.tribonacci(5)); // Answer: 7

        // Test Case 7: n = 10
        System.out.println(solution.tribonacci(10)); // Answer: 149

        // Test Case 8: n = 25
        System.out.println(solution.tribonacci(25)); // Answer: 1389537

        // Test Case 9: n = 37 (Maximum constraint)
        System.out.println(solution.tribonacci(37)); // Answer: 2082876103
    }
}
