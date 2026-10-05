// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: HashMap Frequency Counting — O(n + m) TIME, O(min(n,m)) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        // Check elements of nums2
        for (int num : nums2) {

            if (map.getOrDefault(num, 0) > 0) {

                result[k++] = num;

                map.put(num, map.get(num) - 1);
            }
        }

        return Arrays.copyOf(result, k);
    }
}

// RANK 2: Sorting + Two Pointers — O(n log n + m log m) TIME, O(1) EXTRA SPACE*
// *Ignoring the space used by the sorting implementation

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {

//         Arrays.sort(nums1);
//         Arrays.sort(nums2);

//         int[] result = new int[Math.min(nums1.length, nums2.length)];

//         int i = 0;
//         int j = 0;
//         int k = 0;

//         while (i < nums1.length && j < nums2.length) {

//             if (nums1[i] == nums2[j]) {
//                 result[k++] = nums1[i];
//                 i++;
//                 j++;
//             }
//             else if (nums1[i] < nums2[j]) {
//                 i++;
//             }
//             else {
//                 j++;
//             }
//         }

//         return Arrays.copyOf(result, k);
//     }
// }

// RANK 3: Brute Force + Visited Array — O(n × m) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {

//         boolean[] used = new boolean[nums2.length];

//         int[] result = new int[Math.min(nums1.length, nums2.length)];

//         int k = 0;

//         for (int i = 0; i < nums1.length; i++) {

//             for (int j = 0; j < nums2.length; j++) {

//                 if (!used[j] && nums1[i] == nums2[j]) {

//                     result[k++] = nums1[i];

//                     used[j] = true;

//                     break;
//                 }
//             }
//         }

//         return Arrays.copyOf(result, k);
//     }
// }

// RANK 4: Brute Force + Removing Elements — O(n × m) TIME, O(m) SPACE — SIMPLE / LESS EFFICIENT
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {

//         ArrayList<Integer> list = new ArrayList<>();

//         for (int num : nums2) {
//             list.add(num);
//         }

//         ArrayList<Integer> resultList = new ArrayList<>();

//         for (int num : nums1) {

//             if (list.contains(num)) {

//                 resultList.add(num);

//                 list.remove(Integer.valueOf(num));
//             }
//         }

//         int[] result = new int[resultList.size()];

//         for (int i = 0; i < resultList.size(); i++) {
//             result[i] = resultList.get(i);
//         }

//         return result;
//     }
// }

// Driver code to test the Solution class
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] nums1Tests = {
            {1, 2, 2, 1},
            {2, 2, 1},
            {4, 9, 5},
            {1, 2, 2, 1, 2},
            {1, 1, 1},
            {1, 2, 3, 4, 5},
            {1, 2, 3},
            {4, 4, 9, 5}
        };

        int[][] nums2Tests = {
            {2, 2},
            {2, 2},
            {9, 4, 9, 8, 4},
            {2, 2, 1},
            {1, 1},
            {3, 4, 5, 6},
            {4, 5, 6},
            {9, 4, 4, 4}
        };

        for (int i = 0; i < nums1Tests.length; i++) {

            int[] answer = solution.intersect(
                nums1Tests[i],
                nums2Tests[i]
            );

            System.out.println(
                "Test " + (i + 1) + ": " +
                Arrays.toString(answer)
            );
        }

        /*
        Expected answers:

        Test 1: [2, 2]
        Test 2: [2, 2]
        Test 3: [4, 9]          // order may vary
        Test 4: [2, 2, 1]
        Test 5: [1, 1]
        Test 6: [3, 4, 5]
        Test 7: [ ]
        Test 8: [4, 4, 9]       // order may vary
        */
    }
}