// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Reverse Traversal (Right-to-Left) — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = max;
            max = Math.max(max, current);
        }
        return arr;
    }
}

// RANK 2: Using Extra Array (Suffix Maximum) — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int[] replaceElements(int[] arr) {
//         int n = arr.length;
//         int[] suffixMax = new int[n];

//         suffixMax[n - 1] = -1;
//         int max = arr[n - 1];

//         for (int i = n - 2; i >= 0; i--) {
//             suffixMax[i] = max;
//             max = Math.max(max, arr[i]);
//         }
//         return suffixMax;
//     }
// }

// RANK 3: Brute Force (Naive) — O(n²) TIME, O(1) EXTRA SPACE — SIMPLE / LEAST EFFICIENT
// class Solution {
//     public int[] replaceElements(int[] arr) {
//         int n = arr.length;
//         for (int i = 0; i < n; i++) {
//             int max = -1;
//             for (int j = i + 1; j < n; j++) {
//                 max = Math.max(max, arr[j]);
//             }
//             arr[i] = max;
//         }
//         return arr;
//     }
// }

// Driver code to test the Solution class
public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[] arr1 = {17, 18, 5, 4, 6, 1};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr1))); // Answer: [18, 6, 6, 6, 1, -1]

        // Test Case 2: Single element
        int[] arr2 = {400};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr2))); // Answer: [-1]

        // Test Case 3: Two elements
        int[] arr3 = {5, 2};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr3))); // Answer: [2, -1]

        // Test Case 4: Increasing order
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr4))); // Answer: [5, 5, 5, 5, -1]

        // Test Case 5: Decreasing order
        int[] arr5 = {5, 4, 3, 2, 1};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr5))); // Answer: [4, 3, 2, 1, -1]

        // Test Case 6: All elements equal
        int[] arr6 = {7, 7, 7, 7};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr6))); // Answer: [7, 7, 7, -1]

        // Test Case 7: Negative values
        int[] arr7 = {-1, -2, -3, -4};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr7))); // Answer: [-1, -1, -1, -1]

        // Test Case 8: Greatest element in the middle
        int[] arr8 = {2, 1, 10, 3, 5};
        System.out.println(java.util.Arrays.toString(solution.replaceElements(arr8))); // Answer: [10, 10, 5, 5, -1]
    }
}