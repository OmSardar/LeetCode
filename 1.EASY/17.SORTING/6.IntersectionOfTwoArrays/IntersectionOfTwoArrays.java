// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: HashSet — O(n + m) TIME, O(n + m) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];

        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}

// RANK 2: Sorting + Two Pointers — O(n log n + m log m) TIME, O(1) EXTRA SPACE*
// *Ignoring the space used by the sorting implementation
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {

//         Arrays.sort(nums1);
//         Arrays.sort(nums2);

//         HashSet<Integer> resultSet = new HashSet<>();

//         int i = 0;
//         int j = 0;

//         while (i < nums1.length && j < nums2.length) {

//             if (nums1[i] == nums2[j]) {
//                 resultSet.add(nums1[i]);
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

//         int[] result = new int[resultSet.size()];

//         int k = 0;
//         for (int num : resultSet) {
//             result[k++] = num;
//         }

//         return result;
//     }
// }

// RANK 3: HashSet + Remove — O(n + m) TIME, O(n + m) SPACE — SIMPLE / CLEAN ALTERNATIVE
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {

//         HashSet<Integer> set = new HashSet<>();

//         for (int num : nums1) {
//             set.add(num);
//         }

//         HashSet<Integer> resultSet = new HashSet<>();

//         for (int num : nums2) {
//             if (set.remove(num)) {
//                 resultSet.add(num);
//             }
//         }

//         int[] result = new int[resultSet.size()];

//         int i = 0;
//         for (int num : resultSet) {
//             result[i++] = num;
//         }

//         return result;
//     }
// }

// RANK 4: Brute Force — O(n × m) TIME, O(min(n, m)) SPACE — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {

//         HashSet<Integer> resultSet = new HashSet<>();

//         for (int num1 : nums1) {

//             for (int num2 : nums2) {

//                 if (num1 == num2) {
//                     resultSet.add(num1);
//                     break;
//                 }
//             }
//         }

//         int[] result = new int[resultSet.size()];

//         int i = 0;
//         for (int num : resultSet) {
//             result[i++] = num;
//         }

//         return result;
//     }
// }

// Driver code to test the Solution class
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] nums1Tests = {
            {1, 2, 2, 1},
            {4, 9, 5},
            {1, 2, 3},
            {1, 2, 2, 1},
            {1},
            {1, 2, 3, 4, 5},
            {7, 7, 7},
            {1, 2, 3}
        };

        int[][] nums2Tests = {
            {2, 2},
            {9, 4, 9, 8, 4},
            {4, 5, 6},
            {2},
            {1},
            {6, 7, 8},
            {7, 7},
            {4, 5, 6}
        };

        for (int i = 0; i < nums1Tests.length; i++) {

            int[] answer = solution.intersection(
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

        Test 1: [2]
        Test 2: [4, 9]      // order may vary
        Test 3: [ ]
        Test 4: [2]
        Test 5: [1]
        Test 6: [ ]
        Test 7: [7]
        Test 8: [ ]
        */
    }
}