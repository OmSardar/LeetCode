// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Boyer–Moore Voting Algorithm — O(n), O(1) — BEST / MOST EFFICIENT
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

// RANK 2: HashMap (Frequency Count) — O(n), O(n) — EASY / STRAIGHTFORWARD

// import java.util.HashMap;

// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int n = nums.length;
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0)+1);

//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }
//         return -1;
//     }
// }

// RANK 3: Sorting Method — O(n log n), O(log n) AUXILIARY SPACE — SIMPLE / PRACTICAL

// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         return nums[n / 2];
//     }
// }

// RANK 4: Bit Manipulation — O(32n) = O(n), O(1) — CORRECT, BUT UNNECESSARY COMPLEXITY
// class Solution {
//     public int majorityElement(int[] nums) {
//         int result = 0;
//         int n = nums.length;

//         for (int i = 0; i < 32; i++) {
//             int count = 0;
//             for (int num : nums) {
//                 if (((num >> i) & 1) == 1) {
//                     count++;
//                 }
//             }
//             if (count > n / 2) {
//                 result |= (1 << i);
//             }
//         }
//         return result;
//     }
// }

// RANK 5: Brute Force — O(n²), O(1) — SIMPLE, BUT LEAST EFFICIENT
// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//                 int count = 0;
//             for (int j = 0; j < n; j++) {
//                 if (nums[i] == nums[j]) {
//                     count++;
//                 }
//             }
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }

// Driver code to test the Solution class
public class MajorityElement {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // TEST CASE 1
        // [3, 2, 3] → 3
        int[] nums1 = { 3, 2, 3 };
        System.out.println(obj.majorityElement(nums1));
        // Output: 3

        // TEST CASE 2
        // [2, 2, 1, 1, 1, 2, 2] → 2
        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(obj.majorityElement(nums2));
        // Output: 2

        // TEST CASE 3
        // [1] → 1
        int[] nums3 = { 1 };
        System.out.println(obj.majorityElement(nums3));
        // Output: 1

        // TEST CASE 4
        // [1, 1, 1, 2, 2] → 1
        int[] nums4 = { 1, 1, 1, 2, 2 };
        System.out.println(obj.majorityElement(nums4));
        // Output: 1

        // TEST CASE 5
        // [6, 5, 5] → 5
        int[] nums5 = { 6, 5, 5 };
        System.out.println(obj.majorityElement(nums5));
        // Output: 5

        // TEST CASE 6
        // [7, 7, 7, 3, 3] → 7
        int[] nums6 = { 7, 7, 7, 3, 3 };
        System.out.println(obj.majorityElement(nums6));
        // Output: 7
    }
}