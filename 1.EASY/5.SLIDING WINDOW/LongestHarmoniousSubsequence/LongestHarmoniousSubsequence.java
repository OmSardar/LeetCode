// ============================ FINAL DESTINATION ============================

// RANK 1: HashMap Frequency Counting — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of every number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Check every number with its consecutive value
        for (int num : map.keySet()) {

            if (map.containsKey(num + 1)) {

                int length = map.get(num) + map.get(num + 1);

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}


// RANK 2: Sorting + Two Pointers — O(n log n) TIME, O(1) SPACE — Good alternative

// import java.util.Arrays;

// class Solution {
//     public int findLHS(int[] nums) {

//         Arrays.sort(nums);

//         int left = 0;
//         int right = 0;
//         int maxLength = 0;

//         while (right < nums.length) {

//             while (nums[right] - nums[left] > 1) {
//                 left++;
//             }

//             if (nums[right] - nums[left] == 1) {
//                 maxLength = Math.max(maxLength, right - left + 1);
//             }

//             right++;
//         }

//         return maxLength;
//     }
// }


// RANK 3: Brute Force Frequency Checking — O(n²) TIME, O(1) SPACE

// class Solution {
//     public int findLHS(int[] nums) {

//         int maxLength = 0;

//         for (int i = 0; i < nums.length; i++) {

//             int countCurrent = 0;
//             int countNext = 0;

//             for (int j = 0; j < nums.length; j++) {

//                 if (nums[j] == nums[i]) {
//                     countCurrent++;
//                 }

//                 if (nums[j] == nums[i] + 1) {
//                     countNext++;
//                 }
//             }

//             if (countNext > 0) {
//                 maxLength = Math.max(maxLength, countCurrent + countNext);
//             }
//         }

//         return maxLength;
//     }
// }

// Driver code to test the Solution class
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(solution.findLHS(nums1));
        // Answer: 5

        // Test Case 2
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println(solution.findLHS(nums2));
        // Answer: 2

        // Test Case 3
        int[] nums3 = { 1, 1, 1, 1 };
        System.out.println(solution.findLHS(nums3));
        // Answer: 0

        // Test Case 4
        int[] nums4 = { 1, 1, 2, 2, 3, 3, 3 };
        System.out.println(solution.findLHS(nums4));
        // Answer: 5
    }
}