// ============================ FINAL DESTINATION ============================

import java.util.Arrays;

// RANK 1: Iterative / Space Optimized DP — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {

            int next = previous + current;

            previous = current;
            current = next;
        }

        return current;
    }
}

// RANK 2: Recursion with Memoization — O(n) TIME, O(n) SPACE — Interview-Relevant / DP
// class Solution {
//     public int fib(int n) {
//         int[] memo = new int[n + 1];

//         Arrays.fill(memo, -1);

//         return fibonacci(memo, n);
//     }

//     private int fibonacci(int[] memo, int n) {
//         if (n <= 1) {
//             return n;
//         }
//         if (memo[n] != -1) {
//             return memo[n];
//         }

//         memo[n] = fibonacci(memo, n - 1) + fibonacci(memo, n - 2);

//         return memo[n];

//     }
// }


// RANK 3: Simple Recursion — O(2^n) TIME, O(n) SPACE — Basic Recursion / Educational
// class Solution {
//     public int fib(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         return fib(n - 1) + fib(n - 2);
//     }
// }

// Driver code to test the Solution class
public class FibonacciNumber {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int n1 = 0;

        System.out.println(solution.fib(n1));
        // Answer: 0

        // Test Case 2
        int n2 = 1;

        System.out.println(solution.fib(n2));
        // Answer: 1

        // Test Case 3
        int n3 = 2;

        System.out.println(solution.fib(n3));
        // Answer: 1

        // Test Case 4
        int n4 = 5;

        System.out.println(solution.fib(n4));
        // Answer: 5

        // Test Case 5
        int n5 = 10;

        System.out.println(solution.fib(n5));
        // Answer: 55

        // Test Case 6
        int n6 = 15;

        System.out.println(solution.fib(n6));
        // Answer: 610

        // Test Case 7
        int n7 = 20;

        System.out.println(solution.fib(n7));
        // Answer: 6765
    }
}