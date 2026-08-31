// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Space Optimized DP — O(n) time, O(1) space — BEST SOLUTION / MOST EFFICIENT / OPTIMAL SPACE
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0, prev1 = 0;

        for (int i = 2; i <= cost.length; i++) {
            int curr = Math.min(
                prev1 + cost[i - 1],
                prev2 + cost[i - 2]
            );
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// RANK 2: Tabulation (Bottom-Up DP) — O(n) time, O(n) space — BEST FOR LEARNING DP / SIMPLE ITERATIVE APPROACH
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n + 1];

//         dp[0] = 0;
//         dp[1] = 0;

//         for (int i = 2; i <= n; i++) {
//             dp[i] = Math.min(
//                 dp[i - 1] + cost[i - 1],
//                 dp[i - 2] + cost[i - 2]
//             );
//         }
//         return dp[n];
//     }
// }


// RANK 3: Recursion + Memoization (Top-Down DP) — O(n) time, O(n) space — BEST FOR LEARNING DP FROM RECURSION / TOP-DOWN APPROACH

// import java.util.Arrays;

// class Solution {
//     int dp[];
//     private int solve(int[] cost, int i) {
//         if (i >= cost.length)
//             return 0;
//         if (dp[i] != -1)
//             return dp[i];
    
//         return dp[i] =  cost[i] + Math.min(
//             solve(cost, i + 1),
//             solve(cost, i + 2)
//         );
//     }

//     public int minCostClimbingStairs(int[] cost) {
//         dp = new int[cost.length];
//         Arrays.fill(dp, -1);
//         return Math.min(solve(cost, 0), solve(cost, 1));
//     }
// }

// RANK 4: Recursion (Brute Force) — O(2^n) time, O(n) space — SIMPLEST RECURSIVE IDEA / BEST FOR UNDERSTANDING THE RECURSIVE PATTERN / SLOW
// class Solution {
//     private int solve(int[] cost, int i) {
//         if (i >= cost.length) return 0;
//         return cost[i] + Math.min(
//             solve(cost, i + 1),
//             solve(cost, i + 2)
//         );
//     }

//     public int minCostClimbingStairs(int[] cost) {
//         return Math.min(solve(cost, 0), solve(cost, 1));
//     }
// }

// Driver code to test the Solution class
public class MinCostClimbingStairs {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] tests = {
            {10, 15, 20},                         // 15
            {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, // 6
            {0, 0, 0, 0},                         // 0
            {10, 15}                              // 10
        };

        for (int[] cost : tests) {
            System.out.println(solution.minCostClimbingStairs(cost));
        }
    }
}
