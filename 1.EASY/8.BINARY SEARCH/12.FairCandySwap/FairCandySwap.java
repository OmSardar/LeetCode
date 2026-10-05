// ============================ FINAL DESTINATION ============================

// RANK 1: HashSet + Total Difference — O(n + m) TIME, O(m) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.HashSet;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceTotal = 0;
        int bobTotal = 0;

        // Calculate Alice's total.
        for (int candy : aliceSizes) {
            aliceTotal += candy;
        }

        // Calculate Bob's total
        // and store Bob's candy sizes.
        HashSet<Integer> bobCandies = new HashSet<>();

        for (int candy : bobSizes) {
            bobTotal += candy;
            bobCandies.add(candy);
        }

        // We need:
        //
        // x - y = (aliceTotal - bobTotal) / 2
        //
        // Therefore:
        //
        // y = x - (aliceTotal - bobTotal) / 2

        int difference = (aliceTotal - bobTotal) / 2;

        for (int x : aliceSizes) {

            int y = x - difference;

            // If Bob has y, swapping x and y
            // will make both totals equal.
            if (bobCandies.contains(y)) {
                return new int[] { x, y };
            }
        }

        return new int[0];
    }
}

// RANK 2: HashSet + Different Difference Calculation — O(n + m) TIME, O(m) SPACE — Alternative

// import java.util.HashSet;

// class Solution {
//     public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
//
//         int aliceTotal = 0;
//         int bobTotal = 0;
//
//         HashSet<Integer> bobCandies = new HashSet<>();
//
//         for (int candy : aliceSizes) {
//             aliceTotal += candy;
//         }
//
//         for (int candy : bobSizes) {
//             bobTotal += candy;
//             bobCandies.add(candy);
//         }
//
//         // Alice needs to gain:
//         // (bobTotal - aliceTotal) / 2
//         //
//         // If Alice gives x,
//         // Bob must give:
//
//         int gainNeeded = (bobTotal - aliceTotal) / 2;
//
//         for (int x : aliceSizes) {
//
//             int y = x + gainNeeded;
//
//             if (bobCandies.contains(y)) {
//                 return new int[]{x, y};
//             }
//         }
//
//         return new int[0];
//     }
// }

// RANK 3: Brute Force — O(n × m) TIME, O(1) SPACE — Simple / Direct

// class Solution {
//     public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
//
//         int aliceTotal = 0;
//         int bobTotal = 0;
//
//         for (int candy : aliceSizes) {
//             aliceTotal += candy;
//         }
//
//         for (int candy : bobSizes) {
//             bobTotal += candy;
//         }
//
//         for (int x : aliceSizes) {
//
//             for (int y : bobSizes) {
//
//                 // Alice after swap:
//                 // aliceTotal - x + y
//                 
//                 // Bob after swap:
//                 // bobTotal - y + x
//
//                 if (aliceTotal - x + y == bobTotal - y + x) {
//                     return new int[]{x, y};
//                 }
//             }
//         }
//
//         return new int[0];
//     }
// }


// Driver code to test the Solution class
public class FairCandySwap {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] aliceSizes1 = { 1, 1 };
        int[] bobSizes1 = { 2, 2 };

        int[] answer1 = solution.fairCandySwap(aliceSizes1, bobSizes1);

        System.out.println(answer1[0] + " " + answer1[1]);
        // Answer: 1 2

        // Test Case 2
        int[] aliceSizes2 = { 1, 2, 5 };
        int[] bobSizes2 = { 2, 4 };

        int[] answer2 = solution.fairCandySwap(aliceSizes2, bobSizes2);

        System.out.println(answer2[0] + " " + answer2[1]);
        // Answer: 5 4

        // Test Case 3
        int[] aliceSizes3 = { 2 };
        int[] bobSizes3 = { 1, 3 };

        int[] answer3 = solution.fairCandySwap(aliceSizes3, bobSizes3);

        System.out.println(answer3[0] + " " + answer3[1]);
        // Answer: 2 1

        // Test Case 4
        int[] aliceSizes4 = { 1, 2, 3, 4 };
        int[] bobSizes4 = { 2, 3, 4, 5 };

        int[] answer4 = solution.fairCandySwap(aliceSizes4, bobSizes4);

        System.out.println(answer4[0] + " " + answer4[1]);
        // Answer: 1 2

        // Test Case 5
        int[] aliceSizes5 = { 2, 2, 2, 2 };
        int[] bobSizes5 = { 2, 2, 2, 2 };

        int[] answer5 = solution.fairCandySwap(aliceSizes5, bobSizes5);

        System.out.println(answer5[0] + " " + answer5[1]);
        // Answer: 2 2
    }
}