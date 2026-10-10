// ============================ FINAL DESTINATION ============================

// RANK 1: Total Sum + Left Sum — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}


// RANK 2: Prefix Sum + Suffix Sum — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND

// class Solution {
//     public int pivotIndex(int[] nums) {

//         int n = nums.length;
//         int[] prefix = new int[n];
//         int[] suffix = new int[n];

//         prefix[0] = nums[0];

//         for (int i = 1; i < n; i++) {
//             prefix[i] = prefix[i - 1] + nums[i];
//         }

//         suffix[n - 1] = nums[n - 1];

//         for (int i = n - 2; i >= 0; i--) {
//             suffix[i] = suffix[i + 1] + nums[i];
//         }

//         for (int i = 0; i < n; i++) {

//             int leftSum = (i == 0) ? 0 : prefix[i - 1];
//             int rightSum = (i == n - 1) ? 0 : suffix[i + 1];

//             if (leftSum == rightSum) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }


// RANK 3: Brute Force — O(n²) TIME, O(1) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public int pivotIndex(int[] nums) {

//         for (int i = 0; i < nums.length; i++) {

//             int leftSum = 0;
//             int rightSum = 0;

//             for (int j = 0; j < i; j++) {
//                 leftSum += nums[j];
//             }

//             for (int j = i + 1; j < nums.length; j++) {
//                 rightSum += nums[j];
//             }

//             if (leftSum == rightSum) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }


// Driver code to test the Solution class
public class FindPivotIndex {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 })); // Answer: 3

        // Test Case 2
        System.out.println(
                solution.pivotIndex(new int[] { 1, 2, 3 })); // Answer: -1

        // Test Case 3
        System.out.println(
                solution.pivotIndex(new int[] { 2, 1, -1 })); // Answer: 0

        // Test Case 4
        System.out.println(
                solution.pivotIndex(new int[] { 1, -1, 2 })); // Answer: 2

        // Test Case 5
        System.out.println(
                solution.pivotIndex(new int[] { 0, 0, 0, 0 })); // Answer: 0
    }
}