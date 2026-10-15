// ============================ FINAL DESTINATION ============================

// RANK 1: Contribution Counting — O(n) TIME, O(1) SPACE — Most Efficient

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i;
            int totalSubarrays = left * right;
            int oddSubarrays = (totalSubarrays + 1) / 2;

            total += arr[i] * oddSubarrays;
        }

        return total;
    }
}

// RANK 2: Prefix Sum — O(n²) TIME, O(n) SPACE — Efficient / Practical
// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
//         int n = arr.length;
//         int[] prefix = new int[n + 1];
//
//         for (int i = 0; i < n; i++) {
//             prefix[i + 1] = prefix[i] + arr[i];
//         }
//
//         int total = 0;
//
//         for (int start = 0; start < n; start++) {
//             for (int end = start; end < n; end += 2) {
//                 total += prefix[end + 1] - prefix[start];
//             }
//         }
//
//         return total;
//     }
// }

// RANK 3: Brute Force — O(n³) TIME, O(1) SPACE — Basic / Educational
// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
        
//         int total = 0;
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i; j < arr.length; j++) {
//                 int length = j - i + 1;
//                 if (length % 2 == 1) {
//                     int sum = 0;
//                     for (int k = i; k <= j; k++) {
//                         sum += arr[k];
//                     }
//                     total += sum;
//                 }
//             }
//         }
//         return total;
//     }
// }

// Driver code to test the Solution class
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {1, 4, 2, 5, 3};
        System.out.println(solution.sumOddLengthSubarrays(arr1));
        // Answer: 58

        int[] arr2 = {1, 2};
        System.out.println(solution.sumOddLengthSubarrays(arr2));
        // Answer: 3

        int[] arr3 = {10, 11, 12};
        System.out.println(solution.sumOddLengthSubarrays(arr3));
        // Answer: 66

        int[] arr4 = {1};
        System.out.println(solution.sumOddLengthSubarrays(arr4));
        // Answer: 1

        int[] arr5 = {1, 2, 3, 4};
        System.out.println(solution.sumOddLengthSubarrays(arr5));
        // Answer: 20

        int[] arr6 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.sumOddLengthSubarrays(arr6));
        // Answer: 176
    }
}