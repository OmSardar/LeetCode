// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: In-Place Negative Marking — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // Mark the number that exists by making
        // the value at its corresponding index negative.
        for (int num : nums) {

            int index = Math.abs(num) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Positive values indicate missing numbers.
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}

// RANK 2: HashSet — O(n) TIME, O(n) SPACE — Simple / Easy to Understand
// import java.util.*;
//
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//
//         List<Integer> result = new ArrayList<>();
//         HashSet<Integer> set = new HashSet<>();
//
//         for (int num : nums) {
//             set.add(num);
//         }
//
//         for (int i = 1; i <= nums.length; i++) {
//
//             if (!set.contains(i)) {
//                 result.add(i);
//             }
//         }
//
//         return result;
//     }
// }

// RANK 3: Sorting — O(n log n) TIME, O(1) EXTRA SPACE — Alternative
// import java.util.*;
//
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//
//         List<Integer> result = new ArrayList<>();
//
//         Arrays.sort(nums);
//
//         int expected = 1;
//
//         for (int num : nums) {
//
//             if (num == expected) {
//                 expected++;
//             } else if (num > expected) {
//
//                 while (expected < num) {
//                     result.add(expected);
//                     expected++;
//                 }
//
//                 expected++;
//             }
//         }
//
//         while (expected <= nums.length) {
//             result.add(expected);
//             expected++;
//         }
//
//         return result;
//     }
// }



// Driver code to test the Solution class
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(solution.findDisappearedNumbers(nums1));
        // Answer: [5, 6]


        // Test Case 2
        int[] nums2 = {1, 1};

        System.out.println(solution.findDisappearedNumbers(nums2));
        // Answer: [2]


        // Test Case 3
        int[] nums3 = {1, 2, 3, 4, 5};

        System.out.println(solution.findDisappearedNumbers(nums3));
        // Answer: []


        // Test Case 4
        int[] nums4 = {2, 2, 2, 2};

        System.out.println(solution.findDisappearedNumbers(nums4));
        // Answer: [1, 3, 4]


        // Test Case 5
        int[] nums5 = {2, 1};

        System.out.println(solution.findDisappearedNumbers(nums5));
        // Answer: []


        // Test Case 6
        int[] nums6 = {1, 1, 1, 1, 1};

        System.out.println(solution.findDisappearedNumbers(nums6));
        // Answer: [2, 3, 4, 5]
    }
}