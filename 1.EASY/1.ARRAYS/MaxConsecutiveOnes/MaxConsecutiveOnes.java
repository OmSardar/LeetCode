// ============================ FINAL DESTINATION ============================

// RANK 1: One Pass Counting — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int currentCount = 0;
        int maxCount = 0;

        for (int num : nums) {

            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}

// RANK 2: One Pass with Reset — O(n) TIME, O(1) SPACE — Simple / Direct
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {

//         int count = 0;
//         int max = 0;

//         for (int num : nums) {

//             if (num == 1) {
//                 count++;
//             } else {
//                 count = 0;
//             }

//             if (count > max) {
//                 max = count;
//             }
//         }

//         return max;
//     }
// }

// RANK 3: Brute Force — O(n²) TIME, O(1) SPACE — Basic / Educational
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int max = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 1) {
//                 int count = 0;
//                 for (int j = i; j < nums.length; j++) {
//                     if (nums[j] == 1) {
//                         count++;
//                     } else {
//                         break;
//                     }
//                 }
//                 max = Math.max(max, count);
//             }
//         }
//         return max;
//     }
// }

// Driver code to test the Solution class
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};

        System.out.println(solution.findMaxConsecutiveOnes(nums1));
        // Answer: 3


        // Test Case 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println(solution.findMaxConsecutiveOnes(nums2));
        // Answer: 2


        // Test Case 3
        int[] nums3 = {1, 1, 1, 1};

        System.out.println(solution.findMaxConsecutiveOnes(nums3));
        // Answer: 4


        // Test Case 4
        int[] nums4 = {0, 0, 0, 0};

        System.out.println(solution.findMaxConsecutiveOnes(nums4));
        // Answer: 0


        // Test Case 5
        int[] nums5 = {1};

        System.out.println(solution.findMaxConsecutiveOnes(nums5));
        // Answer: 1


        // Test Case 6
        int[] nums6 = {0, 1, 1, 1, 0, 1, 1};

        System.out.println(solution.findMaxConsecutiveOnes(nums6));
        // Answer: 3
    }
}