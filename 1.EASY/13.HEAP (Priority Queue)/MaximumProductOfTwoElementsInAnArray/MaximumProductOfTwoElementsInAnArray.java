// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: Find Two Largest Elements — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax){
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}

// RANK 2: Max Heap / Priority Queue — O(n + n log n) TIME, O(n) SPACE — Heap Approach
// class Solution {
//     public int maxProduct(int[] nums) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//         for (int num : nums) {
//             maxHeap.offer(num);
//         }
//         int largest = maxHeap.poll();
//         int secondLargest = maxHeap.poll();

//         return (largest - 1) * (secondLargest - 1);
//     }
// }

// RANK 3: Sorting — O(n log n) TIME, O(1) SPACE — Simple / Direct
// import java.util.Arrays;
//
// class Solution {
//     public int maxProduct(int[] nums) {
//
//         Arrays.sort(nums);
//
//         int n = nums.length;
//
//         return (nums[n - 1] - 1) * (nums[n - 2] - 1);
//     }
// }

// RANK 4: Brute Force — O(n²) TIME, O(1) SPACE — Simple / Basic
// class Solution {
//     public int maxProduct(int[] nums) {
//
//         int maxProduct = 0;
//
//         for (int i = 0; i < nums.length; i++) {
//
//             for (int j = i + 1; j < nums.length; j++) {
//
//                 int product = (nums[i] - 1) * (nums[j] - 1);
//
//                 maxProduct = Math.max(maxProduct, product);
//             }
//         }
//
//         return maxProduct;
//     }
// }

// Driver code to test the Solution class
public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 3, 4, 5, 2 };

        System.out.println(solution.maxProduct(nums1));
        // Answer: 12

        // Test Case 2
        int[] nums2 = { 1, 5, 4, 5 };

        System.out.println(solution.maxProduct(nums2));
        // Answer: 16

        // Test Case 3
        int[] nums3 = { 3, 7 };

        System.out.println(solution.maxProduct(nums3));
        // Answer: 12

        // Test Case 4
        int[] nums4 = { 10, 2, 5, 6 };

        System.out.println(solution.maxProduct(nums4));
        // Answer: 45

        // Test Case 5
        int[] nums5 = { 1, 1, 1, 1 };

        System.out.println(solution.maxProduct(nums5));
        // Answer: 0

        // Test Case 6
        int[] nums6 = { 8, 6, 9, 3, 7 };

        System.out.println(solution.maxProduct(nums6));
        // Answer: 56
    }
}