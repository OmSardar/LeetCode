// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: XOR Method — O(n) Time, O(1) Space — BEST PRACTICAL / INTERVIEW FAVORITE / NO OVERFLOW RISK
class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }
}


// RANK 2: Mathematical Difference — O(n) Time, O(1) Space — SIMPLE / EFFICIENT / NO OVERFLOW RISK
// class Solution {
//     public int missingNumber(int[] nums) {
//         int result = nums.length;

//         for (int i = 0; i < nums.length; i++) {
//             int difference = i - nums[i];
//             result += difference;
//         }

//         return result;
//     }
// }

// RANK 3: Sum Formula — O(n) Time, O(1) Space — MOST COMMON / SIMPLE / POTENTIAL INTEGER OVERFLOW
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int expected = n * (n + 1) / 2;
//         int actual = 0;

//         for (int num : nums) {
//             actual += num;
//         }

//         return expected - actual;
//     }
// }

// RANK 4: HashSet — O(n) Average Time, O(n) Space — SIMPLE / EASY TO UNDERSTAND / EXTRA SPACE

// import java.util.HashSet;

// class Solution {
//     public int missingNumber(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }
//         for (int i = 0; i <= nums.length; i++) {
//             if (!set.contains(i)) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// RANK 5: Sorting — O(n log n) Time, O(1) Auxiliary Space — SIMPLE / LEAST EFFICIENT

// import java.util.Arrays;

// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != i) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

// Driver code to test the Solution class
public class MissingNumber {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // Test 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Missing Number: " + obj.missingNumber(nums1));   // 2

        // Test 2
        int[] nums2 = {0, 1};
        System.out.println("Missing Number: " + obj.missingNumber(nums2));   // 2

        // Test 3
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing Number: " + obj.missingNumber(nums3));   // 8

        // Test 4
        int[] nums4 = {0};
        System.out.println("Missing Number: " + obj.missingNumber(nums4));   // 1
    }
}