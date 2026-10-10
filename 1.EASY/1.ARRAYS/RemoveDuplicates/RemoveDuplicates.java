// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two Pointer (In-Place) O(n), O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// RANK 2: Two Pointer (Extra Array) O(n), O(n)
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         if (nums.length == 0) {
//             return 0;
//         }
//         int temp[] = new int[nums.length];
//         int k = 0;
//         temp[k++] = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] != nums[i - 1]) {
//                 temp[k++] = nums[i];
//             }
//         }
//         for (int i = 0; i < k; i++) {
//             nums[i] = temp[i];
//         }
//         return k;
//     }
// }

// RANK 3: Using Arrays Class Streams (distinct()) O(n), O(n)
// import java.util.Arrays;
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int unique[] = Arrays.stream(nums).distinct().toArray();
//         for (int i = 0; i < unique.length; i++) {
//             nums[i] = unique[i];
//         }
//         return unique.length;
//     }
// }

//Driver code to test the Solution class
public class RemoveDuplicates {
    public static void main(String[] args) {
        // Example input
        int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5 };

        // Create Solution object
        Solution solution = new Solution();

        // Call the method
        int k = solution.removeDuplicates(nums);

        // Print the returned length
        System.out.println("Number of unique elements: " + k);

        // Print only the first k elements of the array
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
