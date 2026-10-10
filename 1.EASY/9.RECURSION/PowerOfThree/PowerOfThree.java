// ============================ FINAL DESTINATION ============================

// RANK 1: Repeated Division by 3 — O(log n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

// RANK 2: Recursion — O(log n) TIME, O(log n) SPACE — Natural / Interview-Relevant
// class Solution {
//     public boolean isPowerOfThree(int n) {

//         if (n == 1) {
//             return true;
//         }

//         if (n <= 0 || n % 3 != 0) {
//             return false;
//         }

//         return isPowerOfThree(n / 3);
//     }
// }

// RANK 3: Mathematical Logarithm — O(1) TIME, O(1) SPACE — Mathematical / Less Reliable

// class Solution {
//     public boolean isPowerOfThree(int n) {
//
//         if (n <= 0) {
//             return false;
//         }
//
//         double power = Math.log(n) / Math.log(3);
//
//         return Math.abs(power - Math.round(power)) < 1e-10;
//     }
// }


// Driver code to test the Solution class
public class PowerOfThree {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int n1 = 27;

        System.out.println(solution.isPowerOfThree(n1));
        // Answer: true

        // Test Case 2
        int n2 = 9;

        System.out.println(solution.isPowerOfThree(n2));
        // Answer: true

        // Test Case 3
        int n3 = 1;

        System.out.println(solution.isPowerOfThree(n3));
        // Answer: true

        // Test Case 4
        int n4 = 45;

        System.out.println(solution.isPowerOfThree(n4));
        // Answer: false

        // Test Case 5
        int n5 = 0;

        System.out.println(solution.isPowerOfThree(n5));
        // Answer: false

        // Test Case 6
        int n6 = -3;

        System.out.println(solution.isPowerOfThree(n6));
        // Answer: false

        // Test Case 7
        int n7 = 243;

        System.out.println(solution.isPowerOfThree(n7));
        // Answer: true
    }
}