// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: HashSet — O(n), O(n) — BEST PRACTICAL / FASTEST GENERAL METHOD

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

// RANK 2: Sorting — O(n log n), O(1) EXTRA SPACE — BEST SPACE-EFFICIENT METHOD / SIMPLE

// import java.util.Arrays;

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// RANK 3: Brute Force (Double Loop) — O(n²), O(1) — SIMPLEST, BUT WORST PERFORMANCE
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] == nums[j]) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }


// Driver code to test the Solution class
public class ContainsDuplicate {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[][] testCases = {
            {1, 2, 3, 1},
            {1, 2, 3, 4},
            {1, 1, 1, 3, 3, 4, 3, 2, 4, 2},
            {5, 10, 15, 20},
            {7, 7},
            {}
        };

        for (int[] nums : testCases) {

            System.out.println("Input: " + java.util.Arrays.toString(nums));
            System.out.println("Output: " + obj.containsDuplicate(nums));
            System.out.println();
        }

        /*
        Expected Answers:

        [1, 2, 3, 1]                      → true
        [1, 2, 3, 4]                      → false
        [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] → true
        [5, 10, 15, 20]                   → false
        [7, 7]                            → true
        []                                → false
        */
    }
}