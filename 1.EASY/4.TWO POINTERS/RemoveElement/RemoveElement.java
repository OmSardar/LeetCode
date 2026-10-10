// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Two Pointer (Slow–Fast) O(n), O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// RANK 2: Two Pointer (Swap from End) O(n), O(1)
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         if (nums.length == 0) {
//             return 0;
//         }
//         int left = 0;
//         int right = nums.length - 1;
//         while (left <= right) {
//             if (nums[left] == val) {
//                 nums[left] = nums[right];
//                 right--;
//             } else {
//                 left++;
//             }
//         }
//         return left;        
//     }
// }

// RANK 3: Enhanced For Loop (Copy Style) O(n), O(1)
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int index = 0;
//         for (int num : nums) {
//             if (nums[num] != val) {
//                 nums[index++] = num;
//             }
//         }
//         return index;     
//     }
// }

// RANK 4: Using Java Streams O(n), O(n)
// import java.util.Arrays;
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int arr[] = Arrays.stream(nums).filter(x -> x != val).toArray();
//         System.arraycopy(arr, 0, nums, 0, arr.length);
//         return arr.length;    
//     }
// }

// RANK 5: Brute Force (Shifting Elements) O(n²), O(1)
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int i = 0;
//         int n = nums.length;
//         while (i < n) {
//             if (nums[i] == val) {
//                 int j = i;
//                 while (j < n - 1) {
//                     nums[j] = nums[j + 1];
//                     j++;
//                 }
//                 n--;
//             } else {
//                 i++;
//             }
//         }
//         return n;
//     }
// }

//Driver code to test the Solution class
public class RemoveElement {
    public static void main(String[] args) {

        int[] nums = { 3, 2, 2, 3 };
        int val = 3;

        Solution obj = new Solution();

        System.out.print("Original array: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\nRemoved element: " + val);
        int k = obj.removeElement(nums, val);

        System.out.println("Total element count k = " + k);

        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
