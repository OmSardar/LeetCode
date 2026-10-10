// ============================ FINAL DESTINATION ============================

// RANK 1: Binary Search — O(log n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int arrangeCoins(int n) {

        long left = 1;
        long right = n;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            // Number of coins needed to build
            // 'mid' complete rows:
            //
            // 1 + 2 + 3 + ... + mid
            //
            // = mid * (mid + 1) / 2
            long coinsNeeded = mid * (mid + 1) / 2;

            if (coinsNeeded == n) {
                return (int) mid;
            }

            if (coinsNeeded < n) {

                // We have enough coins for these rows.
                // Try to build more rows.
                left = mid + 1;

            } else {

                // We don't have enough coins.
                // Try fewer rows.
                right = mid - 1;
            }
        }

        // 'right' is the largest number of
        // complete rows we can build.
        return (int) right;
    }
}


// RANK 2: Mathematical Formula — O(1) TIME, O(1) SPACE — Fastest

// class Solution {
//     public int arrangeCoins(int n) {
//
//         // We need the largest k such that:
//         //
//         // k * (k + 1) / 2 <= n
//
//         return (int) ((Math.sqrt(1L + 8L * n) - 1) / 2);
//     }
// }


// RANK 3: Simulation — O(sqrt(n)) TIME, O(1) SPACE — Simple / Easy to Understand

// class Solution {
//     public int arrangeCoins(int n) {
//
//         int rows = 0;
//
//         while (n >= rows + 1) {
//
//             rows++;
//             n -= rows;
//         }
//
//         return rows;
//     }
// }




// Driver code to test the Solution class
public class ArrangingCoins {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int n1 = 5;

        System.out.println(solution.arrangeCoins(n1));
        // Answer: 2


        // Test Case 2
        int n2 = 8;

        System.out.println(solution.arrangeCoins(n2));
        // Answer: 3


        // Test Case 3
        int n3 = 1;

        System.out.println(solution.arrangeCoins(n3));
        // Answer: 1


        // Test Case 4
        int n4 = 3;

        System.out.println(solution.arrangeCoins(n4));
        // Answer: 2


        // Test Case 5
        int n5 = 6;

        System.out.println(solution.arrangeCoins(n5));
        // Answer: 3


        // Test Case 6
        int n6 = 10;

        System.out.println(solution.arrangeCoins(n6));
        // Answer: 4


        // Test Case 7
        int n7 = 0;

        System.out.println(solution.arrangeCoins(n7));
        // Answer: 0
    }
}