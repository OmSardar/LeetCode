// ============================ FINAL DESTINATION ============================

// RANK 1: Running Sum + Minimum Prefix Sum — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int minStartValue(int[] nums) {

        int sum = 0;
        int minSum = 0;

        for (int num : nums) {

            sum += num;

            minSum = Math.min(minSum, sum);
        }

        return 1 - minSum;
    }
}


// RANK 2: Running Sum + Track Required Start — O(n) TIME, O(1) SPACE — SIMPLE / DIRECT

// class Solution {
//     public int minStartValue(int[] nums) {
//
//         int sum = 0;
//         int startValue = 1;
//
//         for (int num : nums) {
//
//             sum += num;
//
//             if (sum + startValue <= 0) {
//                 startValue = 1 - sum;
//             }
//         }
//
//         return startValue;
//     }
// }





// RANK 3: Brute Force Starting Values — O(n × k) TIME, O(1) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public int minStartValue(int[] nums) {

//         int start = 1;

//         while (true) {

//             int sum = start;
//             boolean valid = true;

//             int i = 0;
//             while (i < nums.length) {

//                 sum += nums[i];

//                 if (sum < 1) {
//                     valid = false;
//                     break;
//                 }

//                 i++;
//             }

//             if (valid) {
//                 return start;
//             }

//             start++;
//         }
//     }
// }

// Driver code to test the Solution class
public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.minStartValue(new int[]{-3, 2, -3, 4, 2})
        ); // Answer: 5

        // Test Case 2
        System.out.println(
            solution.minStartValue(new int[]{1, 2})
        ); // Answer: 1

        // Test Case 3
        System.out.println(
            solution.minStartValue(new int[]{1, -2, -3})
        ); // Answer: 5

        // Test Case 4
        System.out.println(
            solution.minStartValue(new int[]{-5, 4, -2, 3, 1})
        ); // Answer: 6

        // Test Case 5
        System.out.println(
            solution.minStartValue(new int[]{2, -3, 4, -1})
        ); // Answer: 2
    }
}