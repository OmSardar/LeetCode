// ============================ FINAL DESTINATION ============================
import java.util.*;

// RANK 1: Min Heap of Size K — O(n log k) TIME, O(k) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {

            minHeap.offer(new int[]{nums[i], i});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] selected = new int[k][2];

        for (int i = 0; i < k; i++) {
            selected[i] = minHeap.poll();
        }

        Arrays.sort(selected, (a, b) -> a[1] - b[1]);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = selected[i][0];
        }

        return result;
    }
}


// RANK 2: Sort Indices by Value — O(n log n) TIME, O(n) SPACE — Simple / Direct
// import java.util.*;
//
// class Solution {
//     public int[] maxSubsequence(int[] nums, int k) {
//
//         Integer[] indices = new Integer[nums.length];
//
//         for (int i = 0; i < nums.length; i++) {
//             indices[i] = i;
//         }
//
//         Arrays.sort(indices, (a, b) -> nums[b] - nums[a]);
//
//         Integer[] selected = Arrays.copyOf(indices, k);
//
//         Arrays.sort(selected);
//
//         int[] result = new int[k];
//
//         for (int i = 0; i < k; i++) {
//             result[i] = nums[selected[i]];
//         }
//
//         return result;
//     }
// }

// RANK 3: Sort Value-Index Pairs — O(n log n) TIME, O(n) SPACE — Alternative
// class Solution {
//     public int[] maxSubsequence(int[] nums, int k) {

//         int[][] pairs = new int[nums.length][2];

//         for (int i = 0; i < nums.length; i++) {
//             pairs[i][0] = nums[i];
//             pairs[i][1] = i;
//         }

//         Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

//         int[][] selected = Arrays.copyOf(pairs, k);

//         Arrays.sort(selected, (a, b) -> a[1] - b[1]);

//         int[] result = new int[k];

//         for (int i = 0; i < k; i++) {
//             result[i] = selected[i][0];
//         }

//         return result;
//     }
// }


// Driver code to test the Solution class
public class FindSubsequenceOfLengthKWithTheLargestSum {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {2, 1, 3, 3};
        int k1 = 2;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums1, k1)));
        // Answer: [3, 3]


        // Test Case 2
        int[] nums2 = {-1, -2, 3, 4};
        int k2 = 3;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums2, k2)));
        // Answer: [-1, 3, 4]


        // Test Case 3
        int[] nums3 = {3, 4, 3, 3};
        int k3 = 2;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums3, k3)));
        // Answer: [3, 4]


        // Test Case 4
        int[] nums4 = {50, -1, -2, 40, 30};
        int k4 = 3;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums4, k4)));
        // Answer: [50, 40, 30]


        // Test Case 5
        int[] nums5 = {1, 2, 3, 4, 5};
        int k5 = 3;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums5, k5)));
        // Answer: [3, 4, 5]


        // Test Case 6
        int[] nums6 = {-5, -2, -8, -1};
        int k6 = 2;

        System.out.println(Arrays.toString(solution.maxSubsequence(nums6, k6)));
        // Answer: [-2, -1]
    }
}
