// ============================ FINAL DESTINATION ============================

// RANK 1: Prefix Sum — O(n) PREPROCESSING, O(1) PER QUERY, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL
class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

// RANK 2: Prefix Sum Without Extra Leading Zero — O(n) PREPROCESSING, O(1) PER QUERY, O(n) SPACE — GOOD ALTERNATIVE
// class NumArray {

//     private int[] prefix;

//     public NumArray(int[] nums) {
//         prefix = new int[nums.length];
//         if (nums.length == 0) return;

//         prefix[0] = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             prefix[i] = prefix[i - 1] + nums[i];
//         }
//     }

//     public int sumRange(int left, int right) {
//         if (left == 0) {
//             return prefix[right];
//         }

//         return prefix[right] - prefix[left - 1];
//     }
// }


// RANK 3: Brute Force — O(n) PER QUERY, O(1) EXTRA SPACE — SIMPLE / LEAST EFFICIENT FOR MANY QUERIES
// class NumArray {
//     private int[] nums;
//     public NumArray(int[] nums) {
//         this.nums = nums;
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         for (int i = left; i <= right; i++) {
//             sum += nums[i];
//         }
//         return sum;
//     }
// }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// Driver code to test the Solution class
public class RangeSumQueryImmutable {
    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        NumArray obj1 = new NumArray(nums1);

        System.out.println(obj1.sumRange(0, 2));
        // Answer: 1

        System.out.println(obj1.sumRange(2, 5));
        // Answer: -1

        System.out.println(obj1.sumRange(0, 5));
        // Answer: -3


        // Test Case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        NumArray obj2 = new NumArray(nums2);

        System.out.println(obj2.sumRange(0, 2));
        // Answer: 6

        System.out.println(obj2.sumRange(1, 3));
        // Answer: 9

        System.out.println(obj2.sumRange(2, 4));
        // Answer: 12


        // Test Case 3
        int[] nums3 = {5};
        NumArray obj3 = new NumArray(nums3);

        System.out.println(obj3.sumRange(0, 0));
        // Answer: 5
    }
}