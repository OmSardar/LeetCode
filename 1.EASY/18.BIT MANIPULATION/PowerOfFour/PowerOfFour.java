// ============================ FINAL DESTINATION ============================

class Solution {
    public boolean isPowerOfFour(int n) {
        // First condition:
        // n must be positive.
        //
        // Second condition:
        // n must be a power of 2.
        //
        // Third condition:
        // For powers of 4, the single 1-bit
        // must be at an EVEN position.
        //
        // 0x55555555 =
        // 01010101010101010101010101010101
        //
        // This keeps bits at positions:
        // 0, 2, 4, 6, 8, ...

        return n > 0 
        && (n & (n - 1)) == 0 
        && (n & 0x55555555) != 0; 
    }
}

// RANK 2: Repeated Division by 4 — O(log₄ n) TIME, O(1) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if (n <= 0) {
//             return false;
//         }
//         while (n % 4 == 0) {
//             n /= 4;
//         }
//         return n == 1;
//     }
// }

// RANK 3: Mathematical Check — O(1) TIME, O(1) SPACE — Simple Mathematical Approach
// class Solution {
//     public boolean isPowerOfFour(int n) {
//          if (n <= 0) {
//             return false;
//         }

//         double value = Math.log(n) / Math.log(4);

//         return value == Math.floor(value);
//     }
// }

// Driver code to test the Solution class
public class PowerOfFour {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int n1 = 1;

        System.out.println(solution.isPowerOfFour(n1));
        // Answer: true

        // Test Case 2
        int n2 = 4;

        System.out.println(solution.isPowerOfFour(n2));
        // Answer: true

        // Test Case 3
        int n3 = 16;

        System.out.println(solution.isPowerOfFour(n3));
        // Answer: true

        // Test Case 4
        int n4 = 64;

        System.out.println(solution.isPowerOfFour(n4));
        // Answer: true

        // Test Case 5
        int n5 = 8;

        System.out.println(solution.isPowerOfFour(n5));
        // Answer: false

        // Test Case 6
        int n6 = 2;

        System.out.println(solution.isPowerOfFour(n6));
        // Answer: false

        // Test Case 7
        int n7 = 0;

        System.out.println(solution.isPowerOfFour(n7));
        // Answer: false

        // Test Case 8
        int n8 = -4;

        System.out.println(solution.isPowerOfFour(n8));
        // Answer: false
    }
}