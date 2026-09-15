// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: System.arraycopy() — O(n) TIME, O(n) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[2 * n];

//         System.arraycopy(nums, 0, ans, 0, n);
//         System.arraycopy(nums, 0, ans, n, n);

//         return ans;
//     }
// }

// RANK 2: Basic Loop — O(n) TIME, O(n) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND / MOST DIRECT
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}

// RANK 3: Modulo Trick (Single Loop) — O(n) TIME, O(n) EXTRA SPACE — CONCISE / GOOD ALTERNATIVE
// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[2 * n];

//         for (int i = 0; i < 2 * n; i++) {
//             ans[i] = nums[i % n];
//         }

//         return ans;
//     }
// }


// RANK 4: Two Separate Loops — O(n) TIME, O(n) EXTRA SPACE — SIMPLE / CLEAR / SLIGHTLY REDUNDANT
// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[2 * n];

//         for (int i = 0; i < n; i++) {
//             ans[i] = nums[i];
//         }

//         for (int i = 0; i < n; i++) {
//             ans[i + n] = nums[i];
//         }

//         return ans;
//     }
// }

// RANK 5: Streams — O(n) TIME, O(n) EXTRA SPACE — CONCISE / MODERN / MORE OVERHEAD
// import java.util.stream.IntStream;

// class Solution {
//     public int[] getConcatenation(int[] nums) {
//         return IntStream.concat(
//                 IntStream.of(nums),
//                 IntStream.of(nums)
//         ).toArray();
//     }
// }

// Driver code to test the Solution class
public class ConcatenationOfArray {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[] nums1 = {1, 2, 1};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums1))); // Answer: [1, 2, 1, 1, 2, 1]

        // Test Case 2: Two elements
        int[] nums2 = {1, 3};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums2))); // Answer: [1, 3, 1, 3]

        // Test Case 3: Single element
        int[] nums3 = {5};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums3))); // Answer: [5, 5]

        // Test Case 4: All elements equal
        int[] nums4 = {7, 7, 7};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums4))); // Answer: [7, 7, 7, 7, 7, 7]

        // Test Case 5: Increasing order
        int[] nums5 = {1, 2, 3, 4};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums5))); // Answer: [1, 2, 3, 4, 1, 2, 3, 4]

        // Test Case 6: Negative values
        int[] nums6 = {-1, -2, -3};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums6))); // Answer: [-1, -2, -3, -1, -2, -3]

        // Test Case 7: Mixed values
        int[] nums7 = {10, 20, 30};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums7))); // Answer: [10, 20, 30, 10, 20, 30]

        // Test Case 8: Larger array
        int[] nums8 = {1, 2, 3, 4, 5, 6};
        System.out.println(java.util.Arrays.toString(solution.getConcatenation(nums8))); // Answer: [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]
    }
}