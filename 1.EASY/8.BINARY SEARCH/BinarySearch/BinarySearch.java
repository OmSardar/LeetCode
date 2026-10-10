// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Iterative Binary Search — O(log n) time, O(1) space — BEST PRACTICAL / MOST EFFICIENT / MOST USED
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

// RANK 2: Recursive Binary Search — O(log n) time, O(log n) space — CLEAN / ELEGANT / LESS SPACE-EFFICIENT
// class Solution {
//     public int search(int[] nums, int target) {
//         int index = helper(0, nums.length - 1, nums, target);
//         return index;
//     }

//     private int helper(int low, int high, int[] nums, int target) {
//         if(low > high){
//             return -1;
//         }
//         int mid = (low + high) / 2;
//         if (target == nums[mid]) {
//             return mid;
//         } else if (target < nums[mid]) {
//             return helper(low, mid - 1, nums, target);
//         } else {
//             return helper(mid + 1, high, nums, target);
//         }
//     }
// }

// RANK 3: Java Built-in Binary Search — O(log n) time, O(1) space — SHORTEST / CONVENIENT / LESS PREFERRED FOR INTERVIEWS

// import java.util.Arrays;

// class Solution {
//     public int search(int[] nums, int target) {
//         int index = Arrays.binarySearch(nums, target);
//         return index >= 0 ? index : -1;
//     }
// }

// Driver code to test the Solution class
public class BinarySearch {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 4, 6, 8, 10};
        int[] nums3 = {1, 3, 5, 7, 9};

        System.out.println(obj.search(nums1, 4));  // 3
        System.out.println(obj.search(nums2, 6));  // 2
        System.out.println(obj.search(nums3, 8));  // -1
        System.out.println(obj.search(new int[]{}, 5)); // -1
    }
}
