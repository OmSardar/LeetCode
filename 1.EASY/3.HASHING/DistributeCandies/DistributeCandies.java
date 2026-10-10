// ============================ FINAL DESTINATION ============================

import java.util.*;

// RANK 1: HashSet — O(n) TIME, O(n) SPACE — BEST / MOST PRACTICAL
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}

// RANK 2: Sorting + Counting Distinct Types — O(n log n) TIME, O(1) EXTRA SPACE — Alternative
// import java.util.Arrays;
//
// class Solution {
//     public int distributeCandies(int[] candyType) {
//
//         Arrays.sort(candyType);
//
//         int distinct = 1;
//
//         for (int i = 1; i < candyType.length; i++) {
//
//             if (candyType[i] != candyType[i - 1]) {
//                 distinct++;
//             }
//         }
//
//         return Math.min(distinct, candyType.length / 2);
//     }
// }

// RANK 3: Brute Force Distinct Counting — O(n²) TIME, O(n) SPACE — Basic / Educational
// class Solution {
//     public int distributeCandies(int[] candyType) {
//
//         List<Integer> distinct = new ArrayList<>();
//
//         for (int candy : candyType) {
//
//             if (!distinct.contains(candy)) {
//                 distinct.add(candy);
//             }
//         }
//
//         return Math.min(distinct.size(), candyType.length / 2);
//     }
// }


// Driver code to test the Solution class
public class DistributeCandies {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] candyType1 = {1, 1, 2, 2, 3, 3};

        System.out.println(solution.distributeCandies(candyType1));
        // Answer: 3


        // Test Case 2
        int[] candyType2 = {1, 1, 2, 3};

        System.out.println(solution.distributeCandies(candyType2));
        // Answer: 2


        // Test Case 3
        int[] candyType3 = {6, 6, 6, 6};

        System.out.println(solution.distributeCandies(candyType3));
        // Answer: 1


        // Test Case 4
        int[] candyType4 = {1, 2, 3, 4};

        System.out.println(solution.distributeCandies(candyType4));
        // Answer: 2


        // Test Case 5
        int[] candyType5 = {1, 1, 2, 2, 3, 4, 5, 5};

        System.out.println(solution.distributeCandies(candyType5));
        // Answer: 4


        // Test Case 6
        int[] candyType6 = {1, 1, 1, 2, 2, 2};

        System.out.println(solution.distributeCandies(candyType6));
        // Answer: 2
    }
}