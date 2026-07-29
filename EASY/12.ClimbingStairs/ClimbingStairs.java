// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Space Optimized DP — O(n), O(1)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev1 = 2;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

// RANK 2: Tabulation (Bottom-Up DP) — O(n), O(n)
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2) return n;

//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;

//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }

// RANK 3: Recursion + Memoization (Top-Down DP) — O(n), O(n)
// class Solution {
//     int dp[];

//     public int climbStairs(int n) {
//         dp = new int[n + 1];
//         return solve(n);
//     }

//     private int solve(int n) {
//         if (n <= 2) {
//             return n;
//         }
//         if (dp[n] != 0) {
//             return dp[n];
//         }
//         dp[n] = solve(n - 1) + solve(n - 2);
//         return dp[n];
//     }
// }

// RANK 4: Mathematical (Fibonacci Formula) — O(1), O(1)
// class Solution {
//     public int climbStairs(int n) {
//         double sqrt5 = Math.sqrt(5);
//         double phi = (1 + sqrt5) / 2;
//         return (int) Math.round(Math.pow(phi, n + 1) / sqrt5);
//     }
// }

// RANK 5: Recursion (Brute Force) — O(2^n), O(n)
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2) {
//             return n;
//         }
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }

// Driver code to test the Solution class
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.climbStairs(2)); // 2
        System.out.println(obj.climbStairs(3)); // 3
        System.out.println(obj.climbStairs(5)); // 8
        System.out.println(obj.climbStairs(10)); // 89
    }
}