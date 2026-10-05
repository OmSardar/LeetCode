// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: Sorting + Two Pointers — O(n³) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        // Skip duplicate third elements
                        while (left < right
                                && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Skip duplicate fourth elements
                        while (left < right
                                && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;

                    } else if (sum < target) {

                        // Need a larger sum
                        left++;

                    } else {

                        // Need a smaller sum
                        right--;
                    }
                }
            }
        }

        return result;
    }
}

// RANK 2: HashSet + Two Loops — O(n³) TIME, O(n) SPACE — Alternative
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {

//         List<List<Integer>> result = new ArrayList<>();

//         Arrays.sort(nums);

//         int n = nums.length;

//         for (int i = 0; i < n - 3; i++) {

//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }

//             for (int j = i + 1; j < n - 2; j++) {

//                 if (j > i + 1 && nums[j] == nums[j - 1]) {
//                     continue;
//                 }

//                 HashSet<Long> seen = new HashSet<>();

//                 for (int k = j + 1; k < n; k++) {

//                     long needed = (long) target
//                             - nums[i]
//                             - nums[j]
//                             - nums[k];

//                     if (seen.contains(needed)) {

//                         result.add(Arrays.asList(
//                                 nums[i],
//                                 nums[j],
//                                 (int) needed,
//                                 nums[k]
//                         ));
//                     }

//                     seen.add((long) nums[k]);
//                 }
//             }
//         }

//         return result;
//     }
// }

// RANK 3: Brute Force — O(n⁴) TIME, O(1) EXTRA SPACE — Basic / Educational
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {

//         List<List<Integer>> list = new ArrayList<>();
//         for (int i = 0; i < nums.length - 3; i++) {
//             for (int j = i + 1; j < nums.length - 2; j++) {
//                 for (int k = j + 1; k < nums.length - 1; k++) {
//                     for (int l = k + 1; l < nums.length; l++) {
//                         int sum = nums[i] + nums[j] + nums[k] + nums[l];
//                         if (sum == target) {
//                             List<Integer> current = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                             if (!list.contains(current)) {
//                                 list.add(current);
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return list;
//     }
// }


// Driver code to test the Solution class
public class FourSum {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        System.out.println(solution.fourSum(nums1, target1));
        // Answer: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]


        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println(solution.fourSum(nums2, target2));
        // Answer: [[2, 2, 2, 2]]


        // Test Case 3
        int[] nums3 = {1, 0, -1, 0, -2, 2};
        int target3 = 1;

        System.out.println(solution.fourSum(nums3, target3));
        // Answer: [[-2, 0, 1, 2], [-1, 0, 0, 2]]


        // Test Case 4
        int[] nums4 = {0, 0, 0, 0};
        int target4 = 0;

        System.out.println(solution.fourSum(nums4, target4));
        // Answer: [[0, 0, 0, 0]]


        // Test Case 5
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        int target5 = 18;

        System.out.println(solution.fourSum(nums5, target5));
        // Answer: [[2, 3, 6, 7], [2, 4, 5, 7], [3, 4, 5, 6]]


        // Test Case 6
        int[] nums6 = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target6 = 0;

        System.out.println(solution.fourSum(nums6, target6));
        // Answer: [
        // [-3, -2, 2, 3],
        // [-3, -1, 1, 3],
        // [-3, 0, 0, 3],
        // [-3, 0, 1, 2],
        // [-2, -1, 0, 3],
        // [-2, -1, 1, 2],
        // [-2, 0, 0, 2],
        // [-1, 0, 0, 1]
        // ]
    }
}