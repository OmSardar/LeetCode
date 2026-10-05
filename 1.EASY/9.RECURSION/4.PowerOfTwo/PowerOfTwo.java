// ============================ FINAL DESTINATION ============================

// RANK 1: Bit Manipulation (n & (n - 1)) — O(1) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public boolean isPowerOfTwo(int n) {

        // Powers of two have exactly one set bit.
        //
        // Example:
        // 8      = 1000
        // 7      = 0111
        //
        // 8 & 7  = 0000
        //
        // Therefore, if n > 0 and
        // n & (n - 1) == 0,
        // n is a power of two.

        return n > 0 && (n & (n - 1)) == 0;
    }
}

// RANK 2: Repeated Division by 2 — O(log n) TIME, O(1) SPACE — Simple / Easy to Understand
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if (n <= 0) {
//             return false;
//         }
//         while (n % 2 == 0) {
//             n /= 2;
//         }
//         return n == 1;
//     }
// }


// RANK 3: Mathematical Approach — O(log n) TIME, O(1) SPACE

// class Solution {
//     public boolean isPowerOfTwo(int n) {
//
//         if (n <= 0) {
//             return false;
//         }
//
//         double value = Math.log(n) / Math.log(2);
//
//         return value == Math.floor(value);
//     }
// }



// Driver code to test the Solution class
public class PowerOfTwo {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int n1 = 1;

        System.out.println(solution.isPowerOfTwo(n1));
        // Answer: true

        // Test Case 2
        int n2 = 16;

        System.out.println(solution.isPowerOfTwo(n2));
        // Answer: true

        // Test Case 3
        int n3 = 3;

        System.out.println(solution.isPowerOfTwo(n3));
        // Answer: false

        // Test Case 4
        int n4 = 0;

        System.out.println(solution.isPowerOfTwo(n4));
        // Answer: false

        // Test Case 5
        int n5 = 1024;

        System.out.println(solution.isPowerOfTwo(n5));
        // Answer: true

        // Test Case 6
        int n6 = -16;

        System.out.println(solution.isPowerOfTwo(n6));
        // Answer: false
    }
}