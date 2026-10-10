// ============================ FINAL DESTINATION ============================


// RANK 1: Sorting + Adjacent Pairing — O(n log n) TIME, O(1) EXTRA SPACE* — BEST / OPTIMAL / MOST PRACTICAL
// *Ignoring the space used internally by the sorting implementation.
import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num = 0; num < nums.length; num += 2) {
            sum += nums[num];
        }
        return sum;
    }
}

// RANK 2: Counting Sort — O(n + k) TIME, O(k) SPACE — BOUNDED-VALUE OPTIMIZATION

// class Solution {
//     public int arrayPairSum(int[] nums) {
//
//         int[] count = new int[20001];
//
//         for (int num : nums) {
//             count[num + 10000]++;
//         }
//
//         int sum = 0;
//         boolean take = true;
//
//         for (int i = 0; i < count.length; i++) {
//
//             while (count[i] > 0) {
//
//                 if (take) {
//                     sum += i - 10000;
//                 }
//
//                 take = !take;
//                 count[i]--;
//             }
//         }
//
//         return sum;
//     }
// }


// RANK 3: Brute Force Pairing — O(n²) TIME, O(n) SPACE — SIMPLE / LEAST EFFICIENT

// class Solution {
//     public int arrayPairSum(int[] nums) {
//
//         boolean[] used = new boolean[nums.length];
//         int sum = 0;
//
//         for (int i = 0; i < nums.length; i++) {
//
//             if (used[i]) {
//                 continue;
//             }
//
//             int best = -1;
//
//             for (int j = i + 1; j < nums.length; j++) {
//
//                 if (!used[j]) {
//
//                     if (best == -1 || nums[j] < nums[best]) {
//                         best = j;
//                     }
//                 }
//             }
//
//             if (best != -1) {
//                 used[i] = true;
//                 used[best] = true;
//                 sum += Math.min(nums[i], nums[best]);
//             }
//         }
//
//         return sum;
//     }
// }


// Driver code to test the Solution class
public class ArrayPartition {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.arrayPairSum(new int[]{1, 4, 3, 2})
        ); // Answer: 4

        // Test Case 2
        System.out.println(
            solution.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2})
        ); // Answer: 9

        // Test Case 3
        System.out.println(
            solution.arrayPairSum(new int[]{1, 1})
        ); // Answer: 1

        // Test Case 4
        System.out.println(
            solution.arrayPairSum(new int[]{1, 2, 3, 4, 5, 6})
        ); // Answer: 9

        // Test Case 5
        System.out.println(
            solution.arrayPairSum(new int[]{-1, -2, -3, -4})
        ); // Answer: -6
    }
}