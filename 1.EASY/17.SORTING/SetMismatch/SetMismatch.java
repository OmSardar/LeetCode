// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: In-Place Marking — O(n) TIME, O(1) EXTRA SPACE — Efficient
class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}

// RANK 2: HashSet — O(n) TIME, O(n) SPACE — Easy to Understand
// import java.util.HashSet;
// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         HashSet<Integer> seen = new HashSet<>();
//         int duplicate = -1;
//         int n = nums.length;
//
//         for (int num : nums) {
//             if (!seen.add(num)) {
//                 duplicate = num;
//             }
//         }
//
//         int missing = -1;
//         for (int i = 1; i <= n; i++) {
//             if (!seen.contains(i)) {
//                 missing = i;
//                 break;
//             }
//         }
//
//         return new int[]{duplicate, missing};
//     }
// }

// RANK 3: Sorting — O(n log n) TIME, O(1) EXTRA SPACE — Straightforward
// import java.util.Arrays;
// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         Arrays.sort(nums);
//         int duplicate = -1;
//         int missing = -1;
//         int n = nums.length;
//
//         for (int i = 1; i < n; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 duplicate = nums[i];
//             }
//         }
//
//         for (int i = 1; i <= n; i++) {
//             if (i <= n && Arrays.binarySearch(nums, i) < 0) {
//                 missing = i;
//                 break;
//             }
//         }
//
//         return new int[]{duplicate, missing};
//     }
// }


// Driver code to test the Solution class
public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 2, 4};
        System.out.println(Arrays.toString(solution.findErrorNums(nums1)));
        // Answer: [2, 3]

        int[] nums2 = {1, 1};
        System.out.println(Arrays.toString(solution.findErrorNums(nums2)));
        // Answer: [1, 2]

        int[] nums3 = {3, 2, 2};
        System.out.println(Arrays.toString(solution.findErrorNums(nums3)));
        // Answer: [2, 1]

        int[] nums4 = {2, 2};
        System.out.println(Arrays.toString(solution.findErrorNums(nums4)));
        // Answer: [2, 1]

        int[] nums5 = {1, 5, 3, 2, 2};
        System.out.println(Arrays.toString(solution.findErrorNums(nums5)));
        // Answer: [2, 4]
    }
}