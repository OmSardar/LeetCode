
// ============================ FINAL DESTINATION ============================

// RANK 1: Fixed-Size Sliding Window — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // Find the sum of the first k elements
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window across the array
        for (int right = k; right < nums.length; right++) {

            // Find the index of the element leaving the window
            int left = right - k;

            // Remove the element leaving the window
            windowSum -= nums[left];

            // Add the new element entering the window
            windowSum += nums[right];

            // Update maximum window sum
            maxSum = Math.max(maxSum, windowSum);
        }

        // Every window has exactly k elements
        return (double) maxSum / k;
    }
}


// RANK 2: Prefix Sum — O(n) TIME, O(n) SPACE — Simple alternative
// class Solution {
//     public double findMaxAverage(int[] nums, int k) {

//         int[] prefix = new int[nums.length + 1];

//         for (int i = 0; i < nums.length; i++) {
//             prefix[i + 1] = prefix[i] + nums[i];
//         }

//         int maxSum = Integer.MIN_VALUE;

//         for (int i = k; i <= nums.length; i++) {

//             int windowSum = prefix[i] - prefix[i - k];

//             maxSum = Math.max(maxSum, windowSum);
//         }

//         return (double) maxSum / k;
//     }
// }

// RANK 3: Brute Force — O(n × k) TIME, O(1) SPACE
// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         int n = nums.length;
//         double max = Integer.MIN_VALUE;
//         for (int i = 0; i <= n - k; i++) {
//             int sum = 0;
//             for (int j = 0; j < k; j++) {
//                 sum += nums[i + j];
//             }
//             double avg = (double)sum / k;
//             max = Math.max(max, avg);
//         }
//         return max;
//     }
// }


// Driver code to test the Solution class
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        System.out.println(solution.findMaxAverage(nums1, 4));
        // Answer: 12.75

        // Test Case 2
        int[] nums2 = {5};
        System.out.println(solution.findMaxAverage(nums2, 1));
        // Answer: 5.0

        // Test Case 3
        int[] nums3 = {0, 1, 1, 3, 3};
        System.out.println(solution.findMaxAverage(nums3, 4));
        // Answer: 2.0

        // Test Case 4
        int[] nums4 = {-1, -2, -3, -4};
        System.out.println(solution.findMaxAverage(nums4, 2));
        // Answer: -1.5
    }
}