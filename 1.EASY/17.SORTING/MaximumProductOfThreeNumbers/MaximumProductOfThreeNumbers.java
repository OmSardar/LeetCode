// ============================ FINAL DESTINATION ============================

// RANK 1: Sorting — O(n log n) TIME, O(log n) SPACE — Simple / Practical

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }
}

// RANK 2: One-Pass Tracking — O(n) TIME, O(1) SPACE — Most Efficient
// class Solution {
//     public int maximumProduct(int[] nums) {
//         int max1 = Integer.MIN_VALUE;
//         int max2 = Integer.MIN_VALUE;
//         int max3 = Integer.MIN_VALUE;
//
//         int min1 = Integer.MAX_VALUE;
//         int min2 = Integer.MAX_VALUE;
//
//         for (int num : nums) {
//             if (num > max1) {
//                 max3 = max2;
//                 max2 = max1;
//                 max1 = num;
//             } else if (num > max2) {
//                 max3 = max2;
//                 max2 = num;
//             } else if (num > max3) {
//                 max3 = num;
//             }
//
//             if (num < min1) {
//                 min2 = min1;
//                 min1 = num;
//             } else if (num < min2) {
//                 min2 = num;
//             }
//         }
//
//         int product1 = max1 * max2 * max3;
//         int product2 = min1 * min2 * max1;
//
//         return Math.max(product1, product2);
//     }
// }


// Driver code to test the Solution class
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.println(solution.maximumProduct(nums1));
        // Answer: 6

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.maximumProduct(nums2));
        // Answer: 24

        int[] nums3 = {-10, -10, 1, 3, 2};
        System.out.println(solution.maximumProduct(nums3));
        // Answer: 300

        int[] nums4 = {-5, -4, -3, -2, -1};
        System.out.println(solution.maximumProduct(nums4));
        // Answer: -6

        int[] nums5 = {-100, -2, -3, 1, 2, 3};
        System.out.println(solution.maximumProduct(nums5));
        // Answer: 600

        int[] nums6 = {-4, -3, -2, -1, 60};
        System.out.println(solution.maximumProduct(nums6));
        // Answer: 720
    }
}