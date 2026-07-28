// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Newton’s Method (FASTEST) — O(log n), O(1)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long r = x;
        while (r * r > x) {
            r = (r + (x / r)) / 2;
        }
        return (int) r;
    }
}

// RANK 2: Binary Search — O(log n), O(1)
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2) return x;

//         int left = 1, right = x / 2, ans = 0;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             long sq = (long) mid * mid;

//             if (sq == x) return mid;
//             if (sq < x) {
//                 ans = mid;
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return ans;
//     }
// }

// RANK 3: Using Division Instead of Multiplication — O(log n), O(1)
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2) return x;

//         int left = 1, right = x / 2;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (mid == x / mid) return mid;
//             if (mid < x / mid) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return right;
//     }
// }

// RANK 4: Using Math.sqrt — O(1), O(1)
// class Solution {
//     public int mySqrt(int x) {
//         return (int) Math.sqrt(x);
//     }
// }

// RANK 5: Brute Force (Linear Scan) — O(√n), O(1)
// class Solution {
//     public int mySqrt(int x) {
//         if (x == 0) return 0;

//         int i = 1;
//         while ((long) i * i <= x) {
//             i++;
//         }
//         return i - 1;
//     }
// }

// Driver code to test the Solution class
public class SqrtX {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {
                0,
                1,
                4,
                8,
                16,
                25,
                100,
                2147395599
        };

        for (int x : testCases) {
            System.out.println("Input: " + x + " -> Output: " + sol.mySqrt(x));
        }
    }
}