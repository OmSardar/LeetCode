// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Binary Search (BEST) O(log n), O(1)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}


// RANK 2: Binary Search (Lower Bound Style) O(log n), O(1)
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int low = 0, high = nums.length;

//         while (low < high) {
//             int mid = low + (high - low) / 2;

//             if (nums[mid] < target)
//                 low = mid + 1;
//             else
//                 high = mid;
//         }
//         return low;
//     }
// }

// RANK 3: Using Java Built-in Binary Search O(log n), O(1)
// import java.util.Arrays;

// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int index = Arrays.binarySearch(nums, target);

//         if (index >= 0)
//             return index;
//         else
//             return -index - 1;
//     }
// }

// RANK 4: Linear Scan (Brute Force) O(n), O(1)
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] >= target) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

//Driver code to test the Solution class
public class SearchInsertPosition {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 1, 3, 5, 6 };
        int target = 5;

        int result = solution.searchInsert(nums, target);

        System.out.println("Insert position: " + result);
    }
}
