// ============================ FINAL DESTINATION ============================

import java.util.Arrays;

// RANK 1: Sorting + Two Pointers — O(n²) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Exact target found
                if (sum == target) {
                    return sum;
                }

                // Update closest sum
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Need a larger sum
                if (sum < target) {
                    left++;
                }
                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}

// RANK 2: Brute Force — O(n³) TIME, O(1) SPACE — Simple / Direct
// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//
//         int closestSum = nums[0] + nums[1] + nums[2];
//
//         for (int i = 0; i < nums.length - 2; i++) {
//
//             for (int j = i + 1; j < nums.length - 1; j++) {
//
//                 for (int k = j + 1; k < nums.length; k++) {
//
//                     int sum = nums[i] + nums[j] + nums[k];
//
//                     if (Math.abs(sum - target)
//                             < Math.abs(closestSum - target)) {
//
//                         closestSum = sum;
//                     }
//                 }
//             }
//         }
//
//         return closestSum;
//     }
// }


// RANK 3: Sorting + Binary Search — O(n² log n) TIME, O(1) SPACE — Alternative
// import java.util.Arrays;
//
// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//
//         Arrays.sort(nums);
//
//         int closestSum = nums[0] + nums[1] + nums[2];
//
//         for (int i = 0; i < nums.length - 2; i++) {
//
//             for (int j = i + 1; j < nums.length - 1; j++) {
//
//                 int needed = target - nums[i] - nums[j];
//
//                 int left = j + 1;
//                 int right = nums.length - 1;
//
//                 while (left <= right) {
//
//                     int mid = left + (right - left) / 2;
//
//                     if (nums[mid] == needed) {
//                         return target;
//                     }
//
//                     if (Math.abs(
//                             nums[i] + nums[j] + nums[mid] - target)
//                             < Math.abs(closestSum - target)) {
//
//                         closestSum = nums[i] + nums[j] + nums[mid];
//                     }
//
//                     if (nums[mid] < needed) {
//                         left = mid + 1;
//                     } else {
//                         right = mid - 1;
//                     }
//                 }
//
//                 // Check the closest elements around the insertion point
//                 if (left < nums.length) {
//
//                     int sum = nums[i] + nums[j] + nums[left];
//
//                     if (Math.abs(sum - target)
//                             < Math.abs(closestSum - target)) {
//
//                         closestSum = sum;
//                     }
//                 }
//
//                 if (right > j) {
//
//                     int sum = nums[i] + nums[j] + nums[right];
//
//                     if (Math.abs(sum - target)
//                             < Math.abs(closestSum - target)) {
//
//                         closestSum = sum;
//                     }
//                 }
//             }
//         }
//
//         return closestSum;
//     }
// }


// Driver code to test the Solution class
public class ThreeSumClosest {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;

        System.out.println(solution.threeSumClosest(nums1, target1));
        // Answer: 2


        // Test Case 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;

        System.out.println(solution.threeSumClosest(nums2, target2));
        // Answer: 0


        // Test Case 3
        int[] nums3 = {1, 1, 1, 0};
        int target3 = -100;

        System.out.println(solution.threeSumClosest(nums3, target3));
        // Answer: 2


        // Test Case 4
        int[] nums4 = {-1, 2, 1, -4};
        int target4 = 2;

        System.out.println(solution.threeSumClosest(nums4, target4));
        // Answer: 2


        // Test Case 5
        int[] nums5 = {1, 2, 3, 4, 5};
        int target5 = 10;

        System.out.println(solution.threeSumClosest(nums5, target5));
        // Answer: 10


        // Test Case 6
        int[] nums6 = {-8, -5, -3, -1, 2, 4, 7};
        int target6 = 0;

        System.out.println(solution.threeSumClosest(nums6, target6));
        // Answer: 0
    }
}