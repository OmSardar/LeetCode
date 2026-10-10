// ============================ FINAL DESTINATION ============================

// RANK 1: Two Pointers + In-Place — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Put every non-zero element at the next available position.
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill the remaining positions with zeroes.
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}

// RANK 2: Two Pointers + Swapping — O(n) TIME, O(1) EXTRA SPACE — IN-PLACE / VERY COMMON
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int insertPos = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 int temp = nums[i];
//                 nums[i] = nums[insertPos];
//                 nums[insertPos] = temp;
//                 insertPos++;
//             }
//         }
//     }
// }

// RANK 3: Extra Array — O(n) TIME, O(n) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int[] result = new int[nums.length];
//         int index = 0;

//         for (int num : nums) {
//             if (num != 0) {
//                 result[index] = num;
//                 index++;
//             }
//         }

//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = result[i];
//         }
//     }
// }


// RANK 4: Brute Force Shifting — O(n²) TIME, O(1) EXTRA SPACE — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public void moveZeroes(int[] nums) {

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 for (int j = i + 1; j < nums.length; j++) {
//                     if (nums[j] != 0) {
//                         int temp = nums[i];
//                         nums[i] = nums[j];
//                         nums[j] = temp;
//                         break;
//                     }
//                 }
//             }
//         }
//     }
// }

// Driver code to test the Solution class
public class MoveZeroes {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums1 = {0, 1, 0, 3, 12};
        s.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1));
        // Answer: [1, 3, 12, 0, 0]


        int[] nums2 = {0};
        s.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2));
        // Answer: [0]


        int[] nums3 = {1, 0, 2, 0, 3};
        s.moveZeroes(nums3);
        System.out.println(java.util.Arrays.toString(nums3));
        // Answer: [1, 2, 3, 0, 0]


        int[] nums4 = {1, 2, 3};
        s.moveZeroes(nums4);
        System.out.println(java.util.Arrays.toString(nums4));
        // Answer: [1, 2, 3]


        int[] nums5 = {0, 0, 1};
        s.moveZeroes(nums5);
        System.out.println(java.util.Arrays.toString(nums5));
        // Answer: [1, 0, 0]
    }
}