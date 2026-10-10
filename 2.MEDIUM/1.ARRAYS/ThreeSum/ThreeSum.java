// ============================ FINAL DESTINATION ============================
import java.util.*;

// RANK 1: Sorting + Two Pointers — O(n²) TIME, O(1) EXTRA SPACE* — BEST / OPTIMAL / MOST PRACTICAL
// *Ignoring the space used internally by the sorting algorithm and output list.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort the array first.
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // If the current number is greater than 0,
            // the remaining numbers will also be >= 0.
            // Therefore, their sum cannot be 0.
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first number.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(
                        Arrays.asList(nums[i], nums[left], nums[right])
                    );

                    // Skip duplicate second numbers.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate third numbers.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    // Need a larger sum.
                    left++;

                } else {
                    // Need a smaller sum.
                    right--;
                }
            }
        }

        return result;
    }
}

// RANK 2: Sorting + Binary Search — O(n² log n) TIME, O(1) EXTRA SPACE* — GOOD ALTERNATIVE
// *Ignoring the space used internally by the sorting algorithm and output list.
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         List<List<Integer>> result = new ArrayList<>();
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length - 2; i++) {

//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }

//             for (int j = i + 1; j < nums.length - 1; j++) {

//                 if (j > i + 1 && nums[j] == nums[j - 1]) {
//                     continue;
//                 }

//                 int target = -(nums[i] + nums[j]);

//                 int left = j + 1;
//                 int right = nums.length - 1;

//                 while (left <= right) {
//                     int mid = left + (right - left) / 2;

//                     if (nums[mid] == target) {
//                         result.add(
//                             Arrays.asList(nums[i], nums[j], nums[mid])
//                         );
//                         break;
//                     } else if (nums[mid] < target) {
//                         left = mid + 1;
//                     } else {
//                         right = mid - 1;
//                     }
//                 }
//             }
//         }

//         return result;
//     }
// }


// RANK 3: Brute Force — O(n³) TIME, O(1) EXTRA SPACE* — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 for (int k = j + 1; k < nums.length; k++) {
//                     if ((nums[i] + nums[j] + nums[k]) == 0) {
//                     //    List<Integer> triplet = Arrays.asList(
//                     //         nums[i],
//                     //         nums[j],
//                     //         nums[k]
//                     //    );
//                         List<Integer> triplet = new ArrayList<>();
//                         triplet.add(nums[i]);
//                         triplet.add(nums[j]);
//                         triplet.add(nums[k]);

//                         result.add(triplet);
//                     }
//                 }
//             }
//         }
//         return result;
//     }
// }

// Driver code to test the Solution class
public class ThreeSum {
    public static void main(String[] args) {

        Solution s = new Solution();


        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums1));
        // Output: [[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]


        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println(s.threeSum(nums2));
        // Output: []


        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.println(s.threeSum(nums3));
        // Output: [[0, 0, 0]]


        // Test Case 4
        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.println(s.threeSum(nums4));
        // Output: [[-2, 0, 2], [-2, 1, 1]]


        // Test Case 5
        int[] nums5 = {-1, 0, 1, 0};
        System.out.println(s.threeSum(nums5));
        // Output: [[-1, 0, 1], [-1, 1, 0]]
    }
}