// ============================ FINAL DESTINATION ============================

import java.util.ArrayList;
import java.util.List;

// RANK 1: One-Pass Traversal — O(n) TIME, O(1) EXTRA SPACE* — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i] != nums[i - 1] + 1) {
                if (start == i - 1) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        return result;
    }
}

// RANK 2: Two-Pointer Range Expansion — O(n) TIME, O(1) EXTRA SPACE* — SIMPLE / EASY TO UNDERSTAND
// *Excluding output space.
// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//
//         List<String> result = new ArrayList<>();
//
//         int i = 0;
//
//         while (i < nums.length) {
//
//             int start = i;
//
//             while (i + 1 < nums.length &&
//                    nums[i + 1] == nums[i] + 1) {
//                 i++;
//             }
//
//             if (start == i) {
//                 result.add(String.valueOf(nums[start]));
//             } else {
//                 result.add(
//                     nums[start] + "->" + nums[i]
//                 );
//             }
//
//             i++;
//         }
//
//         return result;
//     }
// }

// RANK 3: Recursive Traversal — O(n) TIME, O(n) STACK SPACE — RECURSIVE / INTUITIVE
// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//
//         List<String> result = new ArrayList<>();
//
//         if (nums.length == 0) {
//             return result;
//         }
//
//         buildRanges(nums, 0, result);
//
//         return result;
//     }
//
//     private void buildRanges(
//         int[] nums,
//         int start,
//         List<String> result
//     ) {
//
//         if (start >= nums.length) {
//             return;
//         }
//
//         int end = start;
//
//         while (end + 1 < nums.length &&
//                nums[end + 1] == nums[end] + 1) {
//             end++;
//         }
//
//         if (start == end) {
//             result.add(String.valueOf(nums[start]));
//         } else {
//             result.add(
//                 nums[start] + "->" + nums[end]
//             );
//         }
//
//         buildRanges(nums, end + 1, result);
//     }
// }

// Driver code to test the Solution class
public class SummaryRanges {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {
            0, 1, 2, 4, 5, 7
        };
        System.out.println(
            solution.summaryRanges(nums1)
        ); // Answer: [0->2, 4->5, 7]

        int[] nums2 = {
            0, 2, 3, 4, 6, 8, 9
        };
        System.out.println(
            solution.summaryRanges(nums2)
        ); // Answer: [0, 2->4, 6, 8->9]

        int[] nums3 = {
            1
        };
        System.out.println(
            solution.summaryRanges(nums3)
        ); // Answer: [1]

        int[] nums4 = {
            1, 2, 3, 4, 5
        };
        System.out.println(
            solution.summaryRanges(nums4)
        ); // Answer: [1->5]

        int[] nums5 = {
            1, 3, 5, 7
        };
        System.out.println(
            solution.summaryRanges(nums5)
        ); // Answer: [1, 3, 5, 7]

        int[] nums6 = {};
        System.out.println(
            solution.summaryRanges(nums6)
        ); // Answer: []

        int[] nums7 = {
            -5, -4, -3, 0, 1, 5
        };
        System.out.println(
            solution.summaryRanges(nums7)
        ); // Answer: [-5->-3, 0->1, 5]

        int[] nums8 = {
            0, 1, 2, 4, 5, 6, 8, 10, 11
        };
        System.out.println(
            solution.summaryRanges(nums8)
        ); // Answer: [0->2, 4->6, 8, 10->11]
    }
}