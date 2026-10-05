// ============================ FINAL DESTINATION ============================

// RANK 1: ArrayList Simulation — O(n²) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.ArrayList;

class Solution {
    public int minimumPairRemoval(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

  
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while (!isNonDecreasing(list)) {

            int minSum = list.get(0) + list.get(1);
            int minIndex = 0;

          
            for (int i = 1; i < list.size() - 1; i++) {

                int currentSum = list.get(i) + list.get(i + 1);

                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }

            list.set(minIndex, minSum);

          
            list.remove(minIndex + 1);

            operations++;
        }

        return operations;
    }


    // Checks whether the array is non-decreasing.
    private boolean isNonDecreasing(ArrayList<Integer> list) {

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}


// RANK 2: Array Simulation — O(n²) TIME, O(n) SPACE — Direct Simulation

// class Solution {
//     public int minimumPairRemoval(int[] nums) {
//
//         ArrayList<Integer> list = new ArrayList<>();
//
//         for (int num : nums) {
//             list.add(num);
//         }
//
//         int operations = 0;
//
//         while (!isSorted(list)) {
//
//             int minSum = Integer.MAX_VALUE;
//             int minIndex = 0;
//
//             for (int i = 0; i < list.size() - 1; i++) {
//
//                 int sum = list.get(i) + list.get(i + 1);
//
//                 if (sum < minSum) {
//                     minSum = sum;
//                     minIndex = i;
//                 }
//             }
//
//             list.set(minIndex, minSum);
//             list.remove(minIndex + 1);
//
//             operations++;
//         }
//
//         return operations;
//     }
//
//     private boolean isSorted(ArrayList<Integer> list) {
//
//         for (int i = 1; i < list.size(); i++) {
//
//             if (list.get(i) < list.get(i - 1)) {
//                 return false;
//             }
//         }
//
//         return true;
//     }
// }


// RANK 3: ArrayList Simulation with Sorted Copy Check — O(n² log n) TIME, O(n) SPACE — Alternative

// class Solution {
//     public int minimumPairRemoval(int[] nums) {
//
//         ArrayList<Integer> list = new ArrayList<>();
//
//         for (int num : nums) {
//             list.add(num);
//         }
//
//         int operations = 0;
//
//         while (true) {
//
//             ArrayList<Integer> sorted = new ArrayList<>(list);
//             sorted.sort(Integer::compareTo);
//
//             if (list.equals(sorted)) {
//                 return operations;
//             }
//
//             int minSum = Integer.MAX_VALUE;
//             int minIndex = 0;
//
//             for (int i = 0; i < list.size() - 1; i++) {
//
//                 int sum = list.get(i) + list.get(i + 1);
//
//                 if (sum < minSum) {
//                     minSum = sum;
//                     minIndex = i;
//                 }
//             }
//
//             list.set(minIndex, minSum);
//             list.remove(minIndex + 1);
//
//             operations++;
//         }
//     }
// }




// Driver code to test the Solution class
public class MinimumPairRemovalToSortArrayI {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] nums1 = {5, 2, 3, 1};

        System.out.println(solution.minimumPairRemoval(nums1));
        // Answer: 2


        // Test Case 2
        int[] nums2 = {1, 2, 2};

        System.out.println(solution.minimumPairRemoval(nums2));
        // Answer: 0


        // Test Case 3
        int[] nums3 = {1, 3, 2, 4};

        System.out.println(solution.minimumPairRemoval(nums3));
        // Answer: 1


        // Test Case 4
        int[] nums4 = {5, 4, 3, 2, 1};

        System.out.println(solution.minimumPairRemoval(nums4));
        // Answer: 3


        // Test Case 5
        int[] nums5 = {1};

        System.out.println(solution.minimumPairRemoval(nums5));
        // Answer: 0


        // Test Case 6
        int[] nums6 = {1, 1, 1, 1};

        System.out.println(solution.minimumPairRemoval(nums6));
        // Answer: 0


        // Test Case 7
        int[] nums7 = {2, 1, 1};

        System.out.println(solution.minimumPairRemoval(nums7));
        // Answer: 1
    }
}