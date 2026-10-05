// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Dynamic Programming — O(n) Time, O(n) Space — BEST PRACTICAL / MOST EFFICIENT / MOST USED
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

// RANK 2: DP Using Lowest Set Bit — O(n) Time, O(n) Space — EFFICIENT / CLEAN / BIT MANIPULATION
// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n + 1];

//         for (int i = 1; i <= n; i++) {
//             ans[i] = ans[i & (i - 1)] + 1;
//         }
//         return ans;
//     }
// }

// RANK 3: Brian Kernighan’s Algorithm — O(n log n) Time, O(n) Space — EFFICIENT / BIT MANIPULATION / GOOD ALTERNATIVE
// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n + 1];

//         for (int i = 0; i <= n; i++) {
//             int x = i, count = 0;
//             while (x > 0) {
//                 x = x & (x - 1);
//                 count++;
//             }
//             ans[i] = count;
//         }
//         return ans;
//     }
// }


// RANK 4: Manual Bit Counting — O(n log n) Time, O(n) Space — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n + 1];

//         for (int i = 0; i <= n; i++) {
//             int x = i, count = 0;
//             while (x > 0) {
//                 count += (x & 1);
//                 x >>= 1;
//             }
//             ans[i] = count;
//         }
//         return ans;
//     }
// }

// RANK 5: Built-in Bit Count — O(n log n) Time, O(n) Space — SIMPLEST / BUILT-IN / LEAST ALGORITHMIC
// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n + 1];
//         for (int i = 0; i <= n; i++) {
//             ans[i] = Integer.bitCount(i);
//         }
//         return ans;
//     }
// }

// Driver code to test the Solution class
public class CountingBits {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        int n1 = 2;
        System.out.println("n = " + n1);
        System.out.println(java.util.Arrays.toString(obj.countBits(n1)));
        // [0, 1, 1]

        // Test 2
        int n2 = 5;
        System.out.println("n = " + n2);
        System.out.println(java.util.Arrays.toString(obj.countBits(n2)));
        // [0, 1, 1, 2, 1, 2]

        // Test 3
        int n3 = 8;
        System.out.println("n = " + n3);
        System.out.println(java.util.Arrays.toString(obj.countBits(n3)));
        // [0, 1, 1, 2, 1, 2, 2, 3, 1]
    }
}