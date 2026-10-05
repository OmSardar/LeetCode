// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: HashSet (Sliding Window) — O(n), O(k) — BEST PRACTICAL / MOST EFFICIENT / MOST USED

import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

// RANK 2: HashMap (Store Last Index) — O(n), O(n) — BEST INDEX-TRACKING METHOD / SIMPLE

// import java.util.HashMap;

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             if (map.containsKey(nums[i])) {
//                 if (i - map.get(nums[i]) <= k) {
//                     return true;
//                 }
//             }
//             map.put(nums[i], i);
//         }
//         return false;
//     }
// }

// RANK 3: TreeSet (Balanced BST) — O(n log k), O(k) — ORDERED SET APPROACH / LESS EFFICIENT

// import java.util.TreeSet;

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         TreeSet<Integer> set = new TreeSet<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (set.contains(nums[i])) {
//                 return true;
//             }
//             set.add(nums[i]);

//             if (set.size() > k) {
//                 set.remove(nums[i - k]);
//             }
//         }
//         return false;
//     }
// }

// RANK 4: Brute Force (Naive) — O(nk) WORST CASE O(n²), O(1) — SIMPLEST, BUT SLOWEST
// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// Driver code to test the Solution class
public class ContainsDuplicateII {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[][] testCases = {
            {1, 2, 3, 1},
            {1, 0, 1, 1},
            {1, 2, 3, 1, 2, 3},
            {1, 2, 3, 1},
            {1, 2, 3, 4, 5},
            {1, 1},
            {1, 2, 1},
            {}
        };

        int[] kValues = {
            3,
            1,
            2,
            2,
            3,
            1,
            2,
            2
        };

        for (int i = 0; i < testCases.length; i++) {

            boolean result = obj.containsNearbyDuplicate(
                testCases[i], kValues[i]
            );

            System.out.println(
                "Input: " +
                java.util.Arrays.toString(testCases[i]) +
                ", k = " + kValues[i]
            );

            System.out.println("Output: " + result);
            System.out.println("------------------------");
        }

        /*
        Expected Answers:

        [1, 2, 3, 1], k = 3       → true
        [1, 0, 1, 1], k = 1       → true
        [1, 2, 3, 1, 2, 3], k = 2 → false
        [1, 2, 3, 1], k = 2       → false
        [1, 2, 3, 4, 5], k = 3   → false
        [1, 1], k = 1             → true
        [1, 2, 1], k = 2          → true
        [], k = 2                 → false
        */
    }
}