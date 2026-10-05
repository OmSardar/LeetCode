// ============================ FINAL DESTINATION ============================

// RANK 1: Three Variables — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {

            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second) {
                third = second;
                second = num;
            }
            else if (num > third) {
                third = num;
            }
        }

        if (third == Long.MIN_VALUE) {
            return (int) first;
        }

        return (int) third;
    }
}

// RANK 2: Sorting + Skip Duplicates — O(n log n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND

// import java.util.Arrays;

// class Solution {
//     public int thirdMax(int[] nums) {
//         Arrays.sort(nums);
//         int count = 0;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             if (i == nums.length - 1 || nums[i] != nums[i+1]) {
//                 count++;
//             }
//             if (count == 3) {
//                 return nums[i];
//             }
//         }
//         return nums[nums.length - 1];
//     }
// }

// RANK 3: HashSet + PriorityQueue — O(n log 3) TIME, O(n) SPACE — GENERAL / GOOD ALTERNATIVE

// import java.util.HashSet;
// import java.util.PriorityQueue;
//
// class Solution {
//     public int thirdMax(int[] nums) {
//
//         HashSet<Integer> set = new HashSet<>();
//
//         for (int num : nums) {
//             set.add(num);
//         }
//
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//         for (int num : set) {
//
//             pq.offer(num);
//
//             if (pq.size() > 3) {
//                 pq.poll();
//             }
//         }
//
//         if (pq.size() < 3) {
//             while (pq.size() > 1) {
//                 pq.poll();
//             }
//         }
//
//         return pq.peek();
//     }
// }


// RANK 4: Brute Force — O(n²) TIME, O(n) SPACE — SIMPLE / LEAST EFFICIENT

// import java.util.HashSet;

// class Solution {
//     public int thirdMax(int[] nums) {

//         HashSet<Integer> set = new HashSet<>();

//         for (int num : nums) {
//             set.add(num);
//         }

//         if (set.size() < 3) {

//             int max = Integer.MIN_VALUE;

//             for (int num : set) {
//                 max = Math.max(max, num);
//             }

//             return max;
//         }

//         int first = Integer.MIN_VALUE;

//         for (int num : set) {
//             first = Math.max(first, num);
//         }

//         int second = Integer.MIN_VALUE;

//         for (int num : set) {
//             if (num < first) {
//                 second = Math.max(second, num);
//             }
//         }

//         int third = Integer.MIN_VALUE;

//         for (int num : set) {
//             if (num < second) {
//                 third = Math.max(third, num);
//             }
//         }

//         return third;
//     }
// }

// Driver code to test the Solution class
public class ThirdMaximumNumber {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.thirdMax(new int[] { 3, 2, 1 })); // Answer: 1

        // Test Case 2
        System.out.println(
                solution.thirdMax(new int[] { 1, 2 })); // Answer: 2

        // Test Case 3
        System.out.println(
                solution.thirdMax(new int[] { 2, 2, 3, 1 })); // Answer: 1

        // Test Case 4
        System.out.println(
                solution.thirdMax(new int[] { 1, 2, 2, 5, 3, 5 })); // Answer: 2

        // Test Case 5
        System.out.println(
                solution.thirdMax(new int[] { 1 })); // Answer: 1
    }
}