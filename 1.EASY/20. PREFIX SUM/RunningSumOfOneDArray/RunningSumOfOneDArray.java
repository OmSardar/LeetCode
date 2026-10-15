// ============================ FINAL DESTINATION ============================

// RANK 1: In-Place Running Sum — O(n) TIME, O(1) EXTRA SPACE — Most Efficient
class Solution {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}

// RANK 2: Separate Result Array — O(n) TIME, O(n) EXTRA SPACE — Preserves Input
// class Solution {
//     public int[] runningSum(int[] nums) {
//         int[] result = new int[nums.length];
//         result[0] = nums[0];
//
//         for (int i = 1; i < nums.length; i++) {
//             result[i] = result[i - 1] + nums[i];
//         }
//
//         return result;
//     }
// }

// RANK 3: Brute Force — O(n²) TIME, O(n) SPACE — Basic / Educational
// class Solution {
//     public int[] runningSum(int[] nums) {
//         int[] result = new int[nums.length];
//
//         for (int i = 0; i < nums.length; i++) {
//             int sum = 0;
//
//             for (int j = 0; j <= i; j++) {
//                 sum += nums[j];
//             }
//
//             result[i] = sum;
//         }
//
//         return result;
//     }
// }



// Driver code to test the Solution class
public class RunningSumOfOneDArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(java.util.Arrays.toString(solution.runningSum(nums1)));
        // Answer: [1, 3, 6, 10]

        int[] nums2 = { 1, 1, 1, 1, 1 };
        System.out.println(java.util.Arrays.toString(solution.runningSum(nums2)));
        // Answer: [1, 2, 3, 4, 5]

        int[] nums3 = { 3, 1, 2, 10, 1 };
        System.out.println(java.util.Arrays.toString(solution.runningSum(nums3)));
        // Answer: [3, 4, 6, 16, 17]

        int[] nums4 = { 5 };
        System.out.println(java.util.Arrays.toString(solution.runningSum(nums4)));
        // Answer: [5]

        int[] nums5 = { -1, 2, -3, 4 };
        System.out.println(java.util.Arrays.toString(solution.runningSum(nums5)));
        // Answer: [-1, 1, -2, 2]
    }
}