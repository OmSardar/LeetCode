// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Bitwise OR Mathematical Optimization — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;
        }
        return or * (1 << (nums.length - 1));
    }
}

// RANK 2: Backtracking — O(2^n) TIME, O(n) STACK SPACE — SIMPLE / INTUITIVE / EASY TO UNDERSTAND
// class Solution {
//     int sum = 0;

//     public int subsetXORSum(int[] nums) {
//         backtrack(nums, 0, 0);
//         return sum;
//     }

//     private void backtrack(int[] nums, int index, int xor) {
//         if (index == nums.length) {
//             sum += xor;
//             return;
//         }

//         // include
//         backtrack(nums, index + 1, xor ^ nums[index]);

//         // exclude
//         backtrack(nums, index + 1, xor);
//     }
// }

// RANK 3: Brute Force (DFS Recursion) — O(2^n) TIME, O(n) STACK SPACE — RECURSIVE / STRAIGHTFORWARD
// class Solution {
//     public int subsetXORSum(int[] nums) {
//         return dfs(nums, 0, 0);
//     }

//     private int dfs(int[] nums, int index, int xor) {
//         if (index == nums.length) {
//             return xor;
//         }

//         // include current element
//         int include = dfs(nums, index + 1, xor ^ nums[index]);

//         // exclude current element
//         int exclude = dfs(nums, index + 1, xor);

//         return include + exclude;
//     }
// }

// Driver code to test the Solution class
public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[] nums1 = {1, 3};
        System.out.println(solution.subsetXORSum(nums1)); // Answer: 6

        // Test Case 2: Three elements
        int[] nums2 = {5, 1, 6};
        System.out.println(solution.subsetXORSum(nums2)); // Answer: 28

        // Test Case 3: Single element
        int[] nums3 = {5};
        System.out.println(solution.subsetXORSum(nums3)); // Answer: 5

        // Test Case 4: Two equal elements
        int[] nums4 = {2, 2};
        System.out.println(solution.subsetXORSum(nums4)); // Answer: 4

        // Test Case 5: All elements are zero
        int[] nums5 = {0, 0, 0};
        System.out.println(solution.subsetXORSum(nums5)); // Answer: 0

        // Test Case 6: Three elements
        int[] nums6 = {1, 2, 3};
        System.out.println(solution.subsetXORSum(nums6)); // Answer: 12

        // Test Case 7: Four elements
        int[] nums7 = {1, 2, 3, 4};
        System.out.println(solution.subsetXORSum(nums7)); // Answer: 24

        // Test Case 8: Larger values
        int[] nums8 = {10, 5, 7};
        System.out.println(solution.subsetXORSum(nums8)); // Answer: 88
    }
}